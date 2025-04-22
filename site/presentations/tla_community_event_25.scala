package site.presentations

import site.*
import geny.Writable
import scalatags.Text.short.*
import scalatags.Text.tags2

object tla_community_event_25 extends Presentation:
  def path = os.sub / "presentations" / "tla_community_event_25.html"
  
  def titleH(mods: Modifier*): Modifier =
    h2(
      *.cls := "text-[2.5em]",
      *.cls := "font-black",
      mods,
    )

  def slides: List[Slide] = List(
    TitleSlide(
      titlePart = h1("Automating Trace Validation with PGo")
    ),
    ContentSlide(
      titlePart = titleH("Speaker Intro"),
      bodyPart = modifier(

      ),
    ),
    TitleSlide(
      titlePart = modifier(
        *.cls := "grid",
        *.cls := "grid-cols-[60fr_40fr]",
        *.cls := "items-center",
        *.cls := "px-[2em]",
        *.cls := "gap-[2em]",
        div(
          *.cls := "text-center",
          titleH(
            "Building and Running Distributed Systems is Notoriously Error-prone"
          ),
          div(
            *.cls := "pt-[.5em]",
            *.cls := "text-[1.6em]",
            *.cls := "text-gray-600",
            "👉 TLA+ helps with this",
          )
        ),
        ul(
          *.cls := "flex",
          *.cls := "flex-col",
          *.cls := "pl-[1em]",
          *.cls := "text-[1.8em]",
          *.cls := "list-outside",
          *.cls := "list-none",
          *.cls := "gap-[1.5em]",
          *.cls := "text-[3em]",
          *.cls := "*:marker:content-['🔥_']",
          li("Concurrency"),
          li("Partial Failure"),
          li("Networks"),
        ),
      ),
    ),
    ContentSlide(
      titlePart = titleH("The Trouble with Abstraction"),
      bodyPart = modifier(

      ),
    ),
    ContentSlide(
      titlePart = titleH("Known Ways to Relate Specification and Implementation"),
      bodyPart = modifier(
        ul(
          *.cls := "flex",
          *.cls := "flex-col",
          *.cls := "gap-[.5em]",
          *.cls := "pt-[.5em]",
          *.cls := "text-[2em]",
          *.cls := "pl-[2em]",
          *.cls := "*:marker:content-['💡_']",
          li("PGo: compile Modular PlusCal (MPCal) into Go"),
          li("Erla+: compile PlusCal into Erlang"),
          li("Model-guided Testing: use model checker state space to guide implementation tests [TODO: cites]"),
          li(
            *.cls := "marker:!content-['👉_']",
            "Trace Validation: instrument implementation, compare captured logs with TLA+ using TLC"
          ),
        ),
      ),
    ),
    ContentSlide(
      titlePart = titleH("Topic List"),
      bodyPart = modifier(
        ol(
          *.cls := "flex",
          *.cls := "flex-col",
          *.cls := "gap-[.5em]",
          *.cls := "pt-[.5em]",
          *.cls := "list-[upper-roman]",
          //*.cls := "*:marker:content-['👉_']",
          *.cls := "text-[2em]",
          *.cls := "pl-[2em]",
          li("Trace Validation in 5 minutes"),
          li("Auto-tracing PGo-compiled Implementations"),
          li("Demo Time"),
          li("Selected Issues we Found"),
          li("Going Forward"),
          li("Conclusion"),
        ),
      ),
    ),
    TitleSlide(
      titlePart = titleH("Trace Validation in 5 Minutes"),
    ),
    ContentSlide(
      titlePart = titleH("The Idea"),
      bodyPart = modifier(

      ),
    ),
    ContentSlide(
      titlePart = titleH("Brief History in Related Work"),
      bodyPart = modifier(

      ),
    ),
    ContentSlide(
      titlePart = titleH("Beyond a Manual Solution"),
      bodyPart = modifier(

      ),
    ),
    TitleSlide(
      titlePart = titleH("Auto-Tracing PGo-compiled Implementations"),
    ),
    ContentSlide(
      titlePart = titleH("Automatic Logging for PGo"),
      bodyPart = modifier(

      ),
    ),
    ContentSlide(
      titlePart = titleH("The Asynchronous Logging Problem"),
      bodyPart = modifier(

      ),
    ),
    ContentSlide(
      titlePart = titleH("Real Time and Vector Clocks"),
      bodyPart = modifier(

      ),
    ),
    ContentSlide(
      titlePart = titleH("Generating Trace Validation Boilerplate"),
      bodyPart = modifier(

      ),
    ),
    ContentSlide(
      titlePart = titleH("Accounting for MPCal Mapping Macros"),
      bodyPart = modifier(

      ),
    ),
    ContentSlide(
      titlePart = titleH("Causality Constraints"),
      bodyPart = modifier(

      ),
    ),
    ContentSlide(
      titlePart = titleH("Perturbing the Implementation"),
      bodyPart = modifier(

      ),
    ),
    TitleSlide(
      titlePart = titleH("Demo Time"),
    ),
    TitleSlide(
      titlePart = titleH("Selected Issues we Found"),
    ),
    ContentSlide(
      titlePart = titleH("MPCal Environment Assumptions"),
      bodyPart = modifier(

      ),
    ),
    ContentSlide(
      titlePart = titleH("PGo Miscompilation"),
      bodyPart = modifier(

      ),
    ),
    ContentSlide(
      titlePart = titleH("TraceLink Instrumentation Bugs"),
      bodyPart = modifier(

      ),
    ),
    TitleSlide(
      titlePart = titleH("Going Forward"),
    ),
    ContentSlide(
      titlePart = titleH("Considering Plain TLA+ Models"),
      bodyPart = modifier(

      ),
    ),
    ContentSlide(
      titlePart = titleH("Causality and Real Time"),
      bodyPart = modifier(

      ),
    ),
    ContentSlide(
      titlePart = titleH("Conclusion"),
      bodyPart = modifier(

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
