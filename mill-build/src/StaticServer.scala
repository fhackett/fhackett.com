package site

import java.util.concurrent.ExecutorService
import io.undertow.Undertow

final class StaticServer(base: os.Path) extends cask.MainRoutes, AutoCloseable:
  @cask.get("/")
  def root() = cask.Redirect("/index.html")

  @cask.staticFiles("/:file")
  def staticFile(file: String): String = (base / file).toString

  initialize()

  private lazy val cachedHandlerExecutor: Option[ExecutorService] = None
  override protected def handlerExecutor(): Option[ExecutorService] =
    cachedHandlerExecutor

  if (!verbose) cask.main.Main.silenceJboss()
  private val server = Undertow.builder
    .addHttpListener(port, host)
    .setHandler(defaultHandler)
    .build
  server.start()
  println(
    s"Listening at http://$host:$port",
  )

  def close(): Unit =
    server.stop()
    cachedHandlerExecutor.foreach(_.shutdown())
    executionContext.shutdown()
    println("Dev server has shut down.")
  end close
end StaticServer
