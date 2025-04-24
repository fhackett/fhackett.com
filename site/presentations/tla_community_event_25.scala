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
      titlePart = h1("Automating Trace Validation with PGo"),
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
            "Building and Running Distributed Systems is Notoriously Error-prone",
          ),
          div(
            *.cls := "pt-[.5em]",
            *.cls := "text-[1.6em]",
            *.cls := "text-gray-600",
            "👉 TLA+ helps with this",
          ),
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
          *.cls := "*:marker:content-['🤯_']",
          li("Concurrency"),
          li("Partial Failure"),
          li("Networks"),
        ),
      ),
    ),
    ContentSlide(
      titlePart = titleH("Implementation vs Abstraction in TLA+"),
      bodyPart = modifier(
        *.cls := "pt-[2em]",
        *.cls := "grid",
        *.cls := "grid-cols-2",
        div(
          *.cls := "pl-[1em]",
          h2(
            *.cls := "text-[2em]",
            *.cls := "font-medium",
            "The Helpful",
          ),
          ul(
            *.cls := "flex",
            *.cls := "flex-col",
            *.cls := "gap-[.5em]",
            *.cls := "pt-[.5em]",
            *.cls := "text-[1.5em]",
            *.cls := "pl-[2em]",
            *.cls := "*:marker:content-['✅_']",
            li(
              "Summarize complex behavior into a few state variables and actions",
            ),
            li("Abstraction helps simplify state space for model checking"),
          ),
        ),
        div(
          h2(
            *.cls := "text-[2em]",
            *.cls := "font-medium",
            "The Problematic",
          ),
          ul(
            *.cls := "flex",
            *.cls := "flex-col",
            *.cls := "gap-[.5em]",
            *.cls := "pt-[.5em]",
            *.cls := "text-[1.5em]",
            *.cls := "pl-[2em]",
            *.cls := "*:marker:content-['❌_']",
            li("Error-prone relationship with implementation"),
            li("Easy to assume subtly untrue things during modeling"),
            li(
              "Verified models, compiled systematically into implementations, can still fail!",
            ),
          ),
        ),
      ),
    ),
    ContentSlide(
      titlePart =
        titleH("Known Ways to Relate Specification and Implementation"),
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
          li(
            "Model-guided Testing: use model checker state space to guide implementation tests [TODO: cites]",
          ),
          li(
            *.cls := "marker:!content-['👉_']",
            "Trace Validation: instrument implementation, compare captured logs with TLA+ using TLC",
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
          *.cls := "text-[2em]",
          *.cls := "pl-[2em]",
          *.cls := "*:marker:font-bold",
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
      titlePart = titleH("The Concept"),
      bodyPart = modifier(
        img(
          *.cls := "pt-[1em]",
          *.cls := "mx-auto",
          *.cls := "w-[85%]",
          *.src := "tla_community_event_25/tracelink_concept.svg",
        ),
      ),
    ),
    ContentSlide(
      titlePart = titleH("Brief History in Related Work"),
      bodyPart = modifier(
        ul(
          *.cls := "flex",
          *.cls := "flex-col",
          *.cls := "gap-[.5em]",
          *.cls := "pt-[.5em]",
          *.cls := "pl-[2em]",
          List[(String, String)](
            (
              "eXtreme Modelling in Practice @ MongoDB [VLDB '20]",
              "Initial attempts, trouble bridging abstraction levels.",
            ),
            (
              "Bridging the Verifiability Gap @ Open Networking Foundation [TLA+Conf '20]",
              "Workaround: use only the properties asserted on the spec.",
            ),
            (
              "Validating Traces of Distributed Programs Against TLA+ Specifications [SEFM '24]",
              "Concept of splitting log events into parts with TLA+ interpretations.",
            ),
            (
              "Smart Casual Verification of the Confidential Consortium Framework [NSDI '25]",
              "Hand-written mappings from ambiguous log data to TLA+ meanings, at scale.",
            ),
            (
              "Trace Validation for etcd Raft (open-source impl)",
              "Industrial adoption of the above outside Microsoft.",
            ),
          ).map: (title, descr) =>
            li(
              span(
                *.cls := "text-[1.7em]",
                *.cls := "font-bold",
                title,
              ),
              div(
                *.cls := "pl-[2em]",
                *.cls := "text-[1.4em]",
                *.cls := "italic",
                descr,
              ),
            ),
        ),
      ),
    ),
    ContentSlide(
      titlePart = titleH("Beyond a Manual Solution"),
      bodyPart = modifier(
        ul(
          *.cls := "w-[70%]",
          *.cls := "h-[85%]",
          *.cls := "mx-auto",
          *.cls := "flex",
          *.cls := "flex-col",
          *.cls := "justify-center",
          *.cls := "gap-[.5em]",
          *.cls := "pt-[.5em]",
          *.cls := "pl-[2em]",
          *.cls := "text-[2em]",
          li(
            *.cls := "marker:content-['🤔_']",
            "How much of the action semantics in related work can we automate?",
          ),
          li(
            *.cls := "marker:content-['🤔_']",
            "Can we help auto-instrument the implementation too?",
          ),
          li(
            *.cls := "marker:content-['💡_']",
            *.cls := "pt-[2em]",
            "We have the PGo compiler, can that help?",
          ),
        ),
      ),
    ),
    ContentSlide(
      titlePart = titleH("PGo and How it Helps"),
      bodyPart = modifier(
        *.cls := "grid",
        *.cls := "grid-cols-[55%_auto]",
        img(
          // *.cls := "w-[55%]",
          // *.cls := "mx-auto",
          *.src := "tla_community_event_25/pgo_flow.svg",
        ),
        ul(
          *.cls := "flex",
          *.cls := "flex-col",
          *.cls := "justify-center",
          *.cls := "gap-[1.5em]",
          *.cls := "pt-[.5em]",
          *.cls := "pl-[2em]",
          *.cls := "text-[2em]",
          *.cls := "*:marker:content-['🎉_']",
          li("Full introspection of source model"),
          li("Metaprogrammable runtime library in implementation"),
        ),
      ),
    ),
    ContentSlide(
      titlePart = titleH("TraceLink: Push-button Validation of PGo Systems"),
      bodyPart = modifier(
        img(
          *.cls := "w-[85%]",
          *.cls := "mx-auto",
          *.src := "tla_community_event_25/tracelink_flow.svg",
        ),
      ),
    ),
    ContentSlide(
      titlePart = titleH("Anatomy of a Log Entry"),
      bodyPart = modifier(
        img(
          *.cls := "pt-[2em]",
          *.cls := "w-[85%]",
          *.cls := "mx-auto",
          *.src := "tla_community_event_25/log_anatomy.png",
        ),
        div(
          *.cls := "pt-[1em]",
          *.cls := "w-[85%]",
          *.cls := "mx-auto",
          *.cls := "grid",
          *.cls := "grid-cols-2",
          *.cls := "text-[1.3em]",
          *.cls := "italic",
          div(
            "Left: Modular PlusCal example, 1 critical section",
          ),
          div(
            *.cls := "pl-[1em]",
            "Right: Possible TraceLink implementation log",
          ),
        ),
        ul(
          *.cls := "flex",
          *.cls := "flex-col",
          *.cls := "justify-center",
          *.cls := "gap-[.5em]",
          *.cls := "pt-[1em]",
          *.cls := "pl-[2em]",
          *.cls := "text-[1.5em]",
          *.cls := "list-[square]",
          li("Semantics are in terms of environment read/write"),
          li("Environment includes local vars, globals, network"),
          li(
            "Entry ends in commit / abort: log first, then decide if it happened",
          ),
          li("Aborted entries: check reads, ignore writes"),
        ),
      ),
    ),
    ContentSlide(
      titlePart = titleH("The Asynchronous Logging Problem"),
      bodyPart = modifier(
        img(
          *.cls := "pt-[1em]",
          *.cls := "w-[80%]",
          *.cls := "mx-auto",
          *.src := "tla_community_event_25/log_order.svg",
        ),
        ul(
          *.cls := "flex",
          *.cls := "flex-col",
          *.cls := "gap-[.5em]",
          *.cls := "pt-[.5em]",
          *.cls := "text-[2em]",
          *.cls := "pl-[2em]",
          *.cls := "*:marker:content-['💡_']",
          li("Could sort by timestamps (see future work)"),
          li(
            *.cls := "marker:!content-['👉_']",
            "Track causality with vector clocks, get partial order",
          ),
        ),
      ),
    ),
    ContentSlide(
      titlePart = titleH("Example Log, Multiple Events"),
      bodyPart = modifier(
        img(
          *.cls := "pt-[2em]",
          *.cls := "w-[75%]",
          *.cls := "mx-auto",
          *.src := "tla_community_event_25/example_seq.svg",
        ),
        div(
          *.cls := "pt-[1.5em]",
          *.cls := "text-[1.5em]",
          *.cls := "italic",
          *.cls := "text-center",
          "Vector clocks map process id to logical clock (int), increase locally and merge during communication.",
        ),
      ),
    ),
    ContentSlide(
      titlePart = titleH("Interpretation of Example Log"),
      bodyPart = modifier(
        img(
          *.cls := "pt-[2em]",
          *.cls := "w-[65%]",
          *.cls := "mx-auto",
          *.src := "tla_community_event_25/example_seq_ord.svg",
        ),
      ),
    ),
    ContentSlide(
      titlePart = titleH("A Look at Trace Validation Boilerplate"),
      bodyPart = modifier(
        img(
          *.src := "tla_community_event_25/generated_cs_eg.png",
        ),
        // TODO: comment on it
      ),
    ),
    ContentSlide(
      titlePart = titleH("Helpful TLC Aliases"),
      bodyPart = modifier(
      ),
    ),
    ContentSlide(
      titlePart = titleH("About MPCal Mapping Macros"),
      bodyPart = modifier(
        img(
          *.src := "tla_community_event_25/mapping_macro_src.png",
        ),
        img(
          *.src := "tla_community_event_25/mapping_macro_compiled.png",
        ),
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
        // Vector clocks impractical?
        // Real time with timeboxes
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
