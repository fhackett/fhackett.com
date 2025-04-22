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
    ContentSlide(
      titlePart = titleH("Distributed Systems are Hard to Understand"),
      bodyPart = modifier(

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

      ),
    ),
    ContentSlide(
      titlePart = titleH("Topic List"),
      bodyPart = modifier(

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
      titlePart = titleH("Auto-Tracing PGo-Compiled Implementations"),
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
