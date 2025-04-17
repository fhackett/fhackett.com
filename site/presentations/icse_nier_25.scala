package site.presentations

import site.*
import geny.Writable
import scalatags.Text.short.*
import scalatags.Text.tags2

object icse_nier_25 extends Target:
  def path = os.sub / "presentations" / "icse_nier_25.html"

  def content: Writable =
    wrapHeader:
      scalatags.Text.all.frag(
        script(*.`type` := "module", *.src := "./eventHandlers.js"),
        tags2.main(
          *.cls := "mx-auto",
          *.cls := "relative",
          *.cls := "bg-black",
          *.cls := "font-[FiraSans]",
          *.cls := "text-[2dvh]", // 2.5
          *.cls := "h-[80dvh]", // 100
          *.cls := "slideshow-root",
          *.tabindex := 0,
          slides.zipWithIndex
            .map((slide, idx) => slide.renderWithNumber(idx + 1)),
        ),
      )

  def titleH(mods: Modifier*): Modifier =
    h2(
      *.cls := "text-[2.5em]",
      *.cls := "font-black",
      mods,
    )

  def code(mods: Modifier*): Modifier =
    span(
      *.cls := "font-[Source_Code_Pro]",
      mods,
    )

  val slides: List[Slide] = List(
    TitleSlide(
      titlePart = modifier(
        *.cls := "text-center",
        h1(
          *.cls := "font-bold",
          *.cls := "text-[3em]",
          "Listening to the Firehose with Z3Hydrant",
        ),
        div(
          List(
            "../icons/artifacts_evaluated_functional_v1_1.png",
            "../icons/artifacts_available_v1_1.png",
            "../icons/artifacts_reusable_v1_1.png",
          ).map: imgSrc =>
            img(
              *.src := imgSrc,
              *.cls := "inline-block",
              *.cls := "h-[3em]",
              *.cls := "px-[.5em]",
            ),
        ),
        p(
          *.cls := "font-medium",
          *.cls := "text-[2em]",
          *.cls := "text-gray-600",
          "Finn Hackett and Ivan Beschastnikh",
        ),
        p(
          *.cls := "font-medium",
          *.cls := "italic",
          *.cls := "text-[2em]",
          *.cls := "text-gray-600",
          "University of British Columbia",
        ),
        img(
          *.src := "ubc-logo-2018-crest-blue-cmyk.svg",
          *.cls := "p-[1em]",
          *.cls := "w-[9em]",
          *.cls := "mx-auto",
        ),
      ),
    ),
    ContentSlide(
      titlePart = titleH("Motivation"),
      bodyPart = modifier(
        *.cls := "grid",
        *.cls := "justify-items-center",
        img(
          *.src := "icse_nier_25/z3_summary.svg",
          *.cls := "w-[90%]",
          *.cls := "pt-[3em]",
        ),
      ),
    ),
    ContentSlide(
      titlePart = titleH("The Idea"),
      bodyPart = modifier(
        *.cls := "grid",
        *.cls := "justify-items-center",
        img(
          *.src := "icse_nier_25/z3_log_gen.svg",
          *.cls := "w-[90%]",
          *.cls := "pt-[3em]",
        ),
      ),
    ),
    ContentSlide(
      titlePart = titleH("The Process"),
      bodyPart = modifier(
        img(
          *.src := "icse_nier_25/wav_generation.svg",
          *.cls := "w-[90%]",
          *.cls := "pt-[3em]",
          *.cls := "mx-auto",
        ),
        ul(
          *.cls := "text-[1.8em]",
          *.cls := "w-[90%]",
          *.cls := "mx-auto",
          *.cls := "pt-[1.5em]",
          *.cls := "pl-[1em]",
          *.cls := "list-outside",
          *.cls := "list-[square]",
          li(
            txt"Log line labels ${code("[mk-app]")}, ${code("[instance]")} are consistently mapped to 0.09 and 0, respectively.",
          ),
          li("Play it back at audio rate (44.1 kHz, in our case)."),
        ),
      ),
    ),
    ContentSlide(
      titlePart = titleH("Initial Observations"),
      bodyPart = modifier(
        *.cls := "pl-[1.5em]",
        *.cls := "pt-[1em]",
        *.cls := "gap-[.5em]",
        *.cls := "grid",
        *.cls := "grid-cols-2",
        *.cls := "items-start",
        div(
          div(
            *.cls := "text-[2em]",
            *.cls := "font-bold",
            "Intelligible Sonic Sequences",
          ),
          div(
            *.cls := "text-[1.5em]",
            "Identify abstract patterns in behavior",
          ),
          div(
            *.cls := "text-[1.5em]",
            *.cls := "italic",
            "e.g., nested loops of similar inferences",
          ),
          audio(
            *.cls := "pt-[1em]",
            *.cls := "w-full",
            *.attr("controls").empty,
            *.src := "icse_nier_25/bench_11793.mp3",
          ),
        ),
        img(
          *.src := "icse_nier_25/observed_sonic_seq.png",
        ),
        div(
          div(
            *.cls := "text-[2em]",
            *.cls := "font-bold",
            "Held Tones and Silence",
          ),
          div(
            *.cls := "text-[1.5em]",
            "Represent extreme order",
          ),
          div(
            *.cls := "text-[1.5em]",
            *.cls := "italic",
            "e.g., large batches of repeated actions",
          ),
          audio(
            *.cls := "pt-[1em]",
            *.cls := "w-full",
            *.attr("controls").empty,
            *.src := "icse_nier_25/vlsat_b81.mp3",
          ),
        ),
        img(
          *.src := "icse_nier_25/observed_held_tones.png",
          *.cls := "mx-auto",
          *.cls := "row-span-2",
        ),
      ),
    ),
    ContentSlide(
      titlePart = titleH("Similar Sounds can Indicate Similar Behavior"),
      bodyPart = modifier(
        *.cls := "pt-[1em]",
        *.cls := "w-[75%]",
        *.cls := "mx-auto",
        img(
          *.src := "icse_nier_25/observed_similar_A.png",
        ),
        audio(
          *.cls := "pb-[1em]",
          *.cls := "w-full",
          *.attr("controls").empty,
          *.src := "icse_nier_25/ball_count_1d_plain.mp3",
        ),
        img(
          *.src := "icse_nier_25/observed_similar_B.png",
        ),
        audio(
          *.cls := "w-full",
          *.attr("controls").empty,
          *.src := "icse_nier_25/ball_count_2d_hill.mp3",
        ),
      ),
    ),
    ContentSlide(
      titlePart = titleH("Conclusion and Future Work"),
      bodyPart = modifier(
        ul(
          *.cls := "text-[1.8em]",
          *.cls := "pt-[1.5em]",
          *.cls := "pl-[1em]",
          *.cls := "list-outside",
          *.cls := "list-[square]",
          li("TODO"),
          li("TODO"),
        ),
      ),
    ),
  )

  final case class SlideNum(num: Int)

  type ModifierCtx = SlideNum ?=> Modifier

  sealed trait Slide:
    final def renderWithNumber(num: Int): Modifier =
      render(using SlideNum(num))

    def render: ModifierCtx
  end Slide

  abstract class AllSlides(backgroundStack: List[os.SubPath]) extends Slide:
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
          *.cls := "text-[2em]",
          *.cls := "absolute",
          *.cls := "bottom-0",
          *.cls := "right-0",
          *.cls := "px-[2em]",
          *.cls := "py-[1em]",
          summon[SlideNum].num,
        ),
      )
  end AllSlides

  final class TitleSlide(
      backgroundStack: List[os.SubPath] = Nil,
      titlePart: Modifier,
  ) extends AllSlides(backgroundStack):
    def renderContent: ModifierCtx =
      div(
        *.cls := "w-full",
        *.cls := "h-full",
        *.cls := "grid",
        *.cls := "place-items-center",
        div(
          titlePart,
        ),
      )

  final class ContentSlide(
      backgroundStack: List[os.SubPath] = Nil,
      titlePart: Modifier,
      bodyPart: Modifier,
  ) extends AllSlides(backgroundStack):
    def renderContent: ModifierCtx =
      div(
        *.cls := "w-full",
        *.cls := "h-full",
        *.cls := "flex",
        *.cls := "flex-col",
        *.cls := "p-[2em]",
        div(
          titlePart,
        ),
        div(
          *.cls := "flex-grow",
          bodyPart,
        ),
      )
