//> using scala 3
//> using options -Werror -deprecation -feature -Yexplicit-nulls
//> using dep com.lihaoyi::os-lib:0.11.4
//> using dep com.lihaoyi::os-lib-watch:0.11.4
//> using dep com.lihaoyi::scalatags:0.13.1
package site

import scala.collection.mutable
import scala.util.Using
import java.io.Closeable
import scala.annotation.tailrec

object dirs:
  val public = os.pwd / "public"
  val prebuild = os.pwd / "prebuild"

private def doNpmInstall(): Unit =
  println("npm install")
  os.proc("npm", "install")
    .call(
      cwd = dirs.prebuild,
      stdin = os.Inherit,
      stdout = os.Inherit,
      stderr = os.Inherit,
    )

@main
def build(npmInstall: Boolean): Unit =
  val targets: List[Target] = List(
    index,
    music_releases,
    `404`,
  )

  val publicFiles =
    os.walk(dirs.public)
      .view
      .filter(os.isFile)
      .map(_.relativeTo(dirs.public))
      .toSet

  if !os.exists(dirs.prebuild)
  then os.makeDir(dirs.prebuild)
  else
    val prebuildFiles =
      os.walk(dirs.prebuild)
        .view
        .filterNot(_.startsWith(dirs.prebuild / "node_modules"))
        .filter(_ != dirs.prebuild / "bun.lockb")
        .map(_.relativeTo(dirs.prebuild))

    val forCleanup = prebuildFiles
      .filterNot(publicFiles)
      .filterNot(targets.view.map(_.path).toSet)

    forCleanup
      .map(dirs.prebuild / _)
      .tapEach(path => println(s"cleaning up $path"))
      .foreach(os.remove.all)

  publicFiles.foreach: file =>
    val shouldTouch =
      !os.exists(dirs.prebuild / file)
        || (os
          .stat(dirs.public / file)
          .mtime
          .compareTo(os.stat(dirs.prebuild / file).mtime) > 0)

    if shouldTouch
    then
      println(s"updating ${dirs.prebuild / file}")
      os.copy.over(
        from = dirs.public / file,
        to = dirs.prebuild / file,
        createFolders = true,
      )

  targets.foreach: target =>
    println(s"regenerating ${dirs.prebuild / target.path}")
    os.write.over(
      dirs.prebuild / target.path,
      target.content,
      createFolders = true,
    )

  if npmInstall
  then doNpmInstall()
end build

@main
def dev(): Unit =
  object state:
    private val changes = mutable.HashSet[os.Path](dirs.public)
    private var lastDebounce: Long = 0
    private var npmDevProc: Option[os.SubProcess] = None

    def witnessChanges(changes: Set[os.Path]): Unit =
      synchronized:
        if changes.nonEmpty
        then
          this.changes ++= changes
          println(s"saw changes:")
          changes.foreach: path =>
            println(s"  $path")
          lastDebounce = System.currentTimeMillis()
          println("debounced rebuild in >=500ms...")

    @tailrec
    def eventLoop(printMsg: Boolean): Unit =
      val printMsgRec =
        synchronized:
          if printMsg
          then
            println(
              s"watching for changes in ${os.pwd / "site"} and ${dirs.public}, Ctrl^C to end",
            )
          wait(500)
          if changes.nonEmpty && System
              .currentTimeMillis() - lastDebounce >= 500
          then
            changes.clear()
            println("rebuilding now.")
            val buildResult = os
              .proc(
                "scala-cli",
                "run",
                ".",
                "--main-class",
                "site.build",
                "--",
                "false",
              )
              .call(
                cwd = os.pwd,
                stdin = os.Inherit,
                stdout = os.Inherit,
                stderr = os.Inherit,
                check = false,
              )
            if buildResult.exitCode != 0
            then println(s"build failed with code ${buildResult.exitCode}")
            else
              npmDevProc match
                case None =>
                  doNpmInstall()
                  println("launching vite")
                  npmDevProc = Some:
                    os.proc(
                      "npm",
                      "run",
                      "dev",
                      "--",
                      "--host",
                    ).spawn(
                      cwd = os.pwd / "prebuild",
                      destroyOnExit = true,
                      stdout = os.Inherit,
                      stderr = os.Inherit,
                    )
                case Some(_) => // already running, leave it alone
            true
          else false
      eventLoop(printMsg = printMsgRec)

  Using.resource(
    os.watch.watch(
      Seq(
        dirs.public,
        os.pwd / "site",
      ),
      state.witnessChanges,
    ),
  ): _ =>
    state.eventLoop(printMsg = true)
