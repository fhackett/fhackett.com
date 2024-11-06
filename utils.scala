package io.github.fhackett

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import scalatags.Text.tags
import scalatags.Text.tags2
import scalatags.text.Builder
import scalatags.Text

import scala.collection.mutable

object customtags:
  object noStyles extends Text.Modifier:
    def applyTo(t: Builder): Unit = ()

  export Text.short.{
    a as _,
    p as _,
    hr as _,
    h2 as _,
    h3 as _,
    li as _,
    span as _,
    *
  }

  trait CustomTag:
    def tag: Text.Tag
    def styles: Modifier

    def apply(mods: Text.Modifier*): Text.Modifier =
      tag(styles, mods)

  trait WithInnerSpan:
    self =>
    def tag: Text.Tag
    def styles: Text.Modifier
    def spanStyles: Text.Modifier

    def withStyles(mods: Text.Modifier*): WithInnerSpan =
      new WithInnerSpan:
        export self.{tag, spanStyles}
        val styles = modifier(self.styles, mods)

    def apply(mods: Text.Modifier*): Text.Modifier =
      tag(
        styles,
        tags.span(
          spanStyles,
          mods
        )
      )

  trait WithInnerWhiteBgSpan extends WithInnerSpan:
    def spanStyles: Text.Modifier =
      *.cls := "bg-white"

  object a extends CustomTag:
    val tag = tags.a
    val styles = List(
      *.cls := "underline",
      *.cls := "hover:no-underline",
      *.cls := "color-black",
      *.cls := "bg-white"
    )

  object p extends WithInnerWhiteBgSpan:
    val tag = tags.p
    val styles =
      *.cls := "mt-0"

  object h2 extends WithInnerWhiteBgSpan:
    val tag = tags.h2
    val styles =
      *.cls := "mt-0"

  object h3 extends WithInnerWhiteBgSpan:
    val tag = tags.h3
    val styles =
      modifier(
        *.cls := "mt-0",
        *.cls := "mb-2"
      )

  object li extends WithInnerWhiteBgSpan:
    val tag = tags.li
    val styles = noStyles

  object hr extends CustomTag:
    val tag = tags.hr
    val styles = List(
      *.cls := "border-solid-1",
      *.cls := "border-gray-50"
    )

  object span extends CustomTag:
    val tag = tags.span
    val styles =
      *.cls := "bg-white"

import customtags.*

trait Target:
  final def href: String = path.segments.mkString("/")
  def path: os.SubPath
  def content: geny.Writable

def wrapHeader(content: Frag): geny.Writable =
  val navBar =
    tags2.nav(
      *.role := "navigation",
      *.aria.label := "main navigation",
      *.cls := "container",
      *.cls := "mx-auto",
      *.cls := "bg-[url(/nav-mid.svg)]",
      *.cls := "bg-cover",
      *.cls := "bg-white",
      *.cls := "border-b-solid",
      *.cls := "border-1",
      *.cls := "border-rd-md",
      *.cls := "flex",
      *.cls := "flex-col",
      *.cls := "md:flex-row",
      tags.span(
        *.cls := "text-xl",
        *.cls := "flex-inline",
        *.cls := "flex-row",
        tags.a(
          *.cls := "p-2",
          *.cls := "color-black",
          *.cls := "font-bold",
          *.cls := "no-underline",
          *.href := "/",
          span(
            *.cls := "bg-white",
            "Finn Hackett",
            sub("(he/they)"),
            ", MMath"
          )
        ),
        tags.span(
          *.cls := "flex-grow"
        ),
        a(
          *.cls := "md:hidden",
          *.cls := "no-underline",
          *.cls := "color-black",
          img(
            *.cls := "h-1.5em",
            *.cls := "p-2",
            *.cls := "inline",
            *.id := "navbar-open",
            *.src := "data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='1em' height='1em' viewBox='0 0 24 24'%3E%3Cpath fill='black' d='M3 18h18v-2H3zm0-5h18v-2H3zm0-7v2h18V6z'/%3E%3C/svg%3E"
          ),
          img(
            *.cls := "h-1.5em",
            *.cls := "p-2",
            *.cls := "inline",
            *.cls := "hidden",
            *.id := "navbar-close",
            *.src := "data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='1em' height='1em' viewBox='0 0 20 20'%3E%3Cpath fill='black' d='M2.93 17.07A10 10 0 1 1 17.07 2.93A10 10 0 0 1 2.93 17.07m1.41-1.41A8 8 0 1 0 15.66 4.34A8 8 0 0 0 4.34 15.66m9.9-8.49L11.41 10l2.83 2.83l-1.41 1.41L10 11.41l-2.83 2.83l-1.41-1.41L8.59 10L5.76 7.17l1.41-1.41L10 8.59l2.83-2.83z'/%3E%3C/svg%3E"
          )
        )
      ),
      tags.span(
        *.cls := "hidden",
        *.cls := "md:flex-grow",
        *.cls := "md:inline"
      ),
      modifier(
        (Seq(
          ("Intro", index.href),
          ("Research Projects", research_projects.href),
          ("Music Releases", music_releases.href)
        ).map: (name, href) =>
          tags.a(
            *.cls := "p-2",
            *.cls := "text-xl",
            *.cls := "font-bold",
            *.cls := "color-black",
            *.cls := "underline",
            *.cls := "hover:no-underline",
            *.cls := "navbar-item",
            *.cls := "hidden",
            *.cls := "md:block",
            *.href := href,
            span(
              *.cls := "bg-white",
              name
            )
          ))*
      )
    )

  *.doctype("html"):
    html(
      *.lang := "en",
      head(
        meta(*.charset := "utf-8"),
        meta(
          *.name := "viewport",
          *.content := "width=device-width, initial-scale=1"
        ),
        link(*.rel := "icon", *.href := "/favicon.svg"),
        script(*.`type` := "module", *.src := "./main.js"),
        tags2.title("Finn Hackett")
      ),
      body(
        *.cls := "font-[Montserrat]",
        *.cls := "bg-[url(/bg.svg)]",
        *.cls := "bg-fixed",
        *.cls := "bg-cover",
        *.cls := "bg-white",
        *.cls := "flex",
        *.cls := "flex-col",
        *.cls := "m-0",
        *.cls := "p-0",
        *.cls := "min-h-screen",
        navBar,
        content,
        tags.span(*.cls := "flex-grow"),
        footer(
          *.cls := "container",
          *.cls := "mx-auto",
          *.cls := "text-center",
          *.cls := "p-3",
          *.cls := "bg-white",
          *.cls := "border-rd-md",
          span(
            "© ",
            LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy")),
            " Finn Hackett"
          )
        )
      )
    )

extension (ctx: StringContext)
  def frag(modifiers: Text.Modifier*): Text.Modifier =
    StringContext.checkLengths(modifiers, ctx.parts)

    val paragraphs =
      mutable.ArrayBuffer(mutable.ArrayBuffer.empty[Text.Modifier])

    enum InitMarker:
      case Part(part: String)
      case Line(line: String)

    ctx.parts.iterator
      .zip(modifiers.iterator.map(Some.apply) ++ Iterator.single(None))
      .flatMap:
        case (part, modOpt) =>
          val partLines = part.linesIterator.toSeq
          assert(partLines.nonEmpty)
          if partLines.size == 1
          then Iterator.single(InitMarker.Part(partLines.head) -> modOpt)
          else
            Iterator.single(InitMarker.Part(partLines.head) -> None)
              ++ (partLines.view
                .drop(1)
                .dropRight(1)
                .map: line =>
                  InitMarker.Line(line.stripLeading()) -> None)
              ++ Iterator.single(
                InitMarker.Line(partLines.last.stripLeading()) -> modOpt
              )
      .foreach:
        case (InitMarker.Part(""), None) =>
        case (InitMarker.Part(part), modOpt) =>
          paragraphs.last += part
          modOpt.foreach(paragraphs.last += _)
        case (InitMarker.Line(""), modOpt) =>
          paragraphs += mutable.ArrayBuffer.empty
          modOpt.foreach(paragraphs.last += _)
        case (InitMarker.Line(line), modOpt) =>
          paragraphs.last += "\n"
          paragraphs.last += line
          modOpt.foreach(paragraphs.last += _)

    // FIXME: why does this still ouput empty paragraphs?
    paragraphs.iterator
      .filter(_.nonEmpty)
      .map(_.toSeq)
      .map(p(_*))
      .toSeq
