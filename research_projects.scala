package io.github.fhackett

import customtags.*
import scalatags.Text.tags
import scalatags.Text.tags2
import scalatags.Text

object research_projects extends Target:
  def path: os.SubPath = os.sub / "research_projects.html"

  def content: geny.Writable =
    wrapHeader:
      tags2.main(
        *.cls := "container",
        *.cls := "mx-auto",
        *.cls := "flex",
        *.cls := "flex-col",
        *.cls := "items-center",
        h2.withStyles(*.cls := "mt-4")(
          "Research Projects",
        ),
        div(
          *.cls := "flex",
          *.cls := "flex-row",
          *.cls := "flex-wrap",
          *.cls := "container",
          *.cls := "justify-center",
          *.cls := "items-stretch",
          *.cls := "gap-4",
          *.cls := "mb-3",
          projects.map(_.render),
        ),
      )

  val projects: List[Project] = List(
    Project(
      name = "PGo",
      nameExtra = modifier(
        " ",
        a(
          *.href := "https://github.com/DistCompiler/pgo",
          img(
            *.src := "/icons/github-mark.svg",
            *.cls := "h-1.5em",
            *.cls := "inline",
            *.cls := "align-middle",
          ),
        ),
      ),
      href = Some("https://distcompiler.github.io/"),
      logo = "/logos/piggo.svg",
      content = 
        frag"""
          A ${tags.span(*.cls := "italic", "distributed systems compiler")}, providing compilation from abstract model-checkable Modular PlusCal specifications into Go.

          Have a look at our demo projects, such as a Raft-based key-value store, a CRDT implementation, and a primary-backup key-value store.
          The codebase also includes a variety of utilities for linking abstract specification concepts with concrete implementations.
          Commonly used examples are TCP connections, failure detectors, filesystem access, and native Go channels.
        """,
    ),
    Project(
      name = "TreeGen",
      nameExtra = modifier(
        " (",
        a(
          *.href := "http://hdl.handle.net/10012/16133",
          "MMath Thesis",
        ),
        ")",
      ),
      logo = "/logos/treegen_logo.png",
      content = 
        frag"""
          My MMath thesis work.
          Designed to make Interface Definition Language implementation easier, it's an impure functional language with fully out-of-order processing, making order-of-operations bugs, even involving pointers, impossible.
        """,
    ),
    Project(
      name = "mel",
      logo = "/logos/gfx_missing.png",
      content = 
        frag"""
          ${tags.span(*.cls := "italic", "mel")} is a declarative, rule-based Model Extraction Language for extracting facts from XML-structured models of software.

          This is a collaboration with ${a(
            *.href := "https://watform.uwaterloo.ca/",
            "WatForm",
          )}, centered around Rob Hackman's thesis under ${people.jmatlee.link}.
          I contributed evaluation work, comparing ${tags.span(*.cls := "italic", "mel")} with ${a(
            *.href := "https://www.w3.org/TR/xquery/",
            "XQuery",
          )}, a web standard with related features.
        """,
    )
  )

  final case class Project(
    name: String,
    nameExtra: Modifier = "",
    href: Option[String] = None,
    logo: String,
    content: Modifier,
  ) extends Renderable:
    def render: Text.Modifier =
      div(
        *.cls := "bg-white",
        *.cls := "border-rounded",
        *.cls := "drop-shadow",
        *.cls := "p-3",
        *.cls := "container",
        *.cls := "max-w-xl",
        h3(
          href match
            case None => name
            case Some(href) =>
              a(
                *.href := href,
                name,
              ),
          nameExtra,
        ),
        div(
          *.cls := "grid",
          *.cls := "grid-cols-[minmax(0px,1fr)2fr]",
          *.cls := "gap-3",
          img(
            *.cls := "w-full",
            *.src := logo,
          ),
          div(
            content,
          ),
        ),
      )
