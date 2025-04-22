package site.presentations

import site.*
import geny.Writable
import scalatags.Text.short.*
import scalatags.Text.tags2

val all: List[Presentation] = List(
  icse_nier_25,
  tla_community_event_25,
)

trait Presentation extends Target:
  def fontFamily: String = "FiraSans"

  final def content: Writable =
    wrapHeader:
      scalatags.Text.all.frag(
        script(*.`type` := "module", *.src := "./eventHandlers.js"),
        tags2.main(
          *.cls := "mx-auto",
          *.cls := "relative",
          *.cls := "bg-black",
          *.cls := s"font-[$fontFamily]",
          *.cls := "text-[2dvh]", // 2.5
          *.cls := "h-[80dvh]", // 100
          *.cls := "slideshow-root",
          *.tabindex := 0,
          slides.zipWithIndex
            .map((slide, idx) => slide.renderWithNumber(idx + 1)),
        ),
      )

  def slides: List[Slide]
end Presentation

final case class SlideNum(num: Int)

type ModifierCtx = SlideNum ?=> Modifier

trait Slide:
  final def renderWithNumber(num: Int): Modifier =
    render(using SlideNum(num))

  def render: ModifierCtx
end Slide

abstract class AnySlide(backgroundStack: List[os.SubPath]) extends Slide:
  def renderContent: ModifierCtx

  final def render: ModifierCtx =
    div(
      *.cls := "bg-white",
      *.cls := "mx-auto",
      *.cls := "outline-1",
      *.cls := "slideshow-slide",
      *.cls := "relative",
      *.cls := "aspect-video",
      *.cls := "h-full",
      *.cls := "overflow-clip",
      renderContent,
      div(
        *.cls := "text-[1.5em]",
        *.cls := "absolute",
        *.cls := "bottom-0",
        *.cls := "right-0",
        *.cls := "px-[2em]",
        *.cls := "py-[1em]",
        summon[SlideNum].num,
      ),
    )
end AnySlide
