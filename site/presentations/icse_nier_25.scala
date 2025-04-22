package site.presentations

import site.*
import geny.Writable
import scalatags.Text.short.*
import scalatags.Text.tags2

object icse_nier_25 extends Presentation:
  def path = os.sub / "presentations" / "icse_nier_25.html"

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
      titlePart = titleH("What is Z3?"),
      bodyPart = modifier(
        *.cls := "grid",
        *.cls := "grid-cols-[25%_auto]",
        *.cls := "pt-[2em]",
        *.cls := "gap-[5em]",
        img(
          *.src := "icse_nier_25/z3_summary.svg",
        ),
        div(
          ul(
            *.cls := "text-[1.8em]",
            *.cls := "list-outside",
            *.cls := "list-[square]",
            *.cls := "*:pt-[.5em]",
            li(
              "Powerful constraint solver for Satisfiability Modulo Theory problems.",
            ),
            li("11k citations since 2008, 2018 ETAPS test of time award."),
            li(
              "Widely used: program analysis, theorem prover automation, package manager dependency resolution...",
            ),
          ),
        ),
      ),
    ),
    ContentSlide(
      titlePart = titleH("The Issue"),
      bodyPart = modifier(
        *.cls := "grid",
        *.cls := "grid-cols-[25%_auto]",
        *.cls := "grid-cols-2",
        *.cls := "pt-[2em]",
        *.cls := "gap-[4em]",
        img(
          *.src := "icse_nier_25/z3_summary.svg",
        ),
        div(
          h3(
            *.cls := "pt-[.5em]",
            *.cls := "text-[1.9em]",
            *.cls := "font-bold",
            "Fundamental tech limitations",
          ),
          ul(
            *.cls := "pl-[1em]",
            *.cls := "text-[1.8em]",
            *.cls := "list-outside",
            *.cls := "list-[square]",
            li("Undecidable logic, not guaranteed to terminate"),
            li("Small changes in input affect termination"),
          ),
          h3(
            *.cls := "pt-[1em]",
            *.cls := "text-[1.9em]",
            *.cls := "font-bold",
            "When something goes wrong...",
          ),
          ul(
            *.cls := "pl-[1em]",
            *.cls := "text-[1.8em]",
            *.cls := "list-outside",
            *.cls := "list-[square]",
            li(
              "Large log files, no clear error indicators, too dense for conventional visualizers",
            ),
            li(
              "Axiom Profiler [TACAS'19]: useful specialist tool, but does not provide overview",
            ),
          ),
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
          li("Play it back at audio rate (44.1 kHz in our case)."),
        ),
      ),
    ),
    ContentSlide(
      titlePart = titleH("Potential Use Case"),
      bodyPart = modifier(
        *.cls := "grid",
        *.cls := "justify-items-center",
        img(
          *.src := "icse_nier_25/intended_use_case.svg",
          *.cls := "w-[85%]",
          *.cls := "pt-[2em]",
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
      titlePart = modifier(titleH("Conclusion and Future Work")),
      bodyPart = modifier(
        *.cls := "grid",
        *.cls := "grid-cols-[auto_10%]",
        *.cls := "gap-[1em]",
        div(
          h3(
            *.cls := "pt-[1em]",
            *.cls := "text-[2em]",
            *.cls := "font-bold",
            "Conclusion",
          ),
          ul(
            *.cls := "text-[2em]",
            *.cls := "pl-[1em]",
            *.cls := "list-outside",
            *.cls := "list-[square]",
            li("Can compress 100mb of logs into a 1min listen."),
            li("Retains identifiable structural features of underlying process."),
          ),
          h3(
            *.cls := "pt-[1em]",
            *.cls := "text-[2em]",
            *.cls := "font-bold",
            "Future Work",
          ),
          ul(
            *.cls := "text-[2em]",
            *.cls := "pl-[1em]",
            *.cls := "list-outside",
            *.cls := "list-[square]",
            li("Consider more log parameters, and/or Fourier synthesis."),
            li(
              "Use Z3Hydrant as coarse-grained initial \"view\" to complement more precise analyses.",
            ),
            li("Apply technique to other domains with similar logs."),
          ),
        ),
        div(
          *.cls := "self-center",
          img(
            *.src := "ubc-logo-2018-crest-blue-cmyk.svg",
            *.cls := "w-full",
            *.cls := "pb-[5em]",
          ),
          img(
            *.src := "icse_nier_25/preprint_mark.svg",
            *.cls := "w-full",
          ),
        ),
      ),
    ),
  )

  final class TitleSlide(
      backgroundStack: List[os.SubPath] = Nil,
      titlePart: Modifier,
  ) extends AnySlide(backgroundStack):
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
  ) extends AnySlide(backgroundStack):
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
