package io.github.fhackett

import customtags.*
import scalatags.Text.tags
import scalatags.Text.tags2
import scalatags.Text

object index extends Target:
  def path: os.SubPath = os.sub / "index.html"

  private def placeImg(src: String): Modifier =
    div(
      *.cls := "bg-white",
      *.cls := "hidden",
      *.cls := "lg:block",
      *.cls := "border-1",
      *.cls := "border-solid",
      *.cls := "ml-3",
      *.cls := "mb-3",
      *.cls := "mt-3",
      *.cls := "justify-self-end",
      *.cls := "max-w-350px",
      *.cls := "h-min",
      img(
        *.src := src,
        *.cls := "object-scale-down",
        *.cls := "w-full"
      ),
      div(
        *.cls := "text-center",
        "© 2024 Martin Hackett"
      )
    )

  def content: geny.Writable =
    wrapHeader:
      tags2.main(
        *.cls := "container",
        *.cls := "mx-auto",
        *.cls := "divide-y",
        *.cls := "divide-gray",
        *.cls := "divide-solid",
        // ---
        tags2.section(
          *.cls := "pt-4",
          *.cls := "border-x-0",
          // single col version
          *.cls := "divide-y",
          *.cls := "divide-gray",
          *.cls := "divide-solid",
          // 2 col version
          *.cls := "lg:divide-y-0",
          *.cls := "lg:grid",
          *.cls := "lg:grid-cols-[repeat(1,auto)min-content]",
          tags2.section(
            *.cls := "lg:pr-2",
            *.cls := "lg:border-r-2",
            *.cls := "lg:border-r-gray",
            *.cls := "lg:border-r-double",
            h2("Self-Introduction 📖"),
            // TODO: add internships
            frag"""
              I'm a PhD student in the ${a(
                *.href := "https://systopia.cs.ubc.ca/",
                "Systopia"
              )} and ${a(
                *.href := "https://spl.cs.ubc.ca/index.html",
                "Software Practices"
              )} labs at the University of British Columbia.
              My interests relate to programming language design in an applied context, with an ongoing focus on formal modeling languages.
              I want full-stack verified software development, from modeling the target system to dealing with performance engineering practicalities and mainenance, to be a realistic option for developers.
              That switch, between modeling concerns and implementation issues, is a particular point of friction that I'm working to alleviate.

              My work so far has been as a developer of the ${a(
                *.href := "https://github.com/DistCompiler/pgo",
                "PGo project"
              )}, a compiler for verified distributed system models.
              I am also working on a follow-up project, ${a(
                *.href := "https://github.com/DistCompiler/dcal",
                "DCal"
              )} (note: very much pre-alpha), which introduces guided term rewriting into distributed system model compilation.
              The goal is to allow a developer to explain mismatches between their model and intended working system, such that the compiler can reliably generate that intended system.
              
              You might also be interested in my work on the interface-level ${a(
                *.href := "https://github.com/tlaplus/azure-cosmos-tla/tree/master/simple-model",
                "modeling of Azure Cosmos DB in TLA+"
              )}.

              Regardless of how up to date the above ideas are, this website is a catalog of things I've built or thought about.
              This includes my research projects, talks (including video links when possible), peer-reviewed publications, and over 10 years' worth of electronic music production.

              If you're an undergraduate student reading this who wants to get involved in research, feel free to get in touch.
              We could work out some sort of collaboration, or, failing that, I could at least point you toward someone whose work might be a better fit for your interests.

              Also, check out Martin Hackett, whose paintings I used as part of this website's design.
            """
          ),
          div(
            *.cls := "divide-y",
            *.cls := "divide-gray",
            *.cls := "divide-solid",
            *.cls := "border-x-0",
            tags2.section(
              *.cls := "pt-4",
              *.cls := "lg:pt-0",
              *.cls := "lg:pl-2",
              *.cls := "border-x-0",
              h2("Contact 📡"),
              div(
                *.cls := "inline-grid",
                *.cls := "grid-cols-[repeat(3,min-content)auto]",
                *.cls := "gap-3",
                *.cls := "mb-4",
                // row 1
                span("E-Mail"),
                span("📧", *.cls := "mx-auto"),
                span("≝"),
                tags.a(
                  *.cls := "underline",
                  *.cls := "hover:no-underline",
                  *.cls := "color-black",
                  *.href := "mailto:fhackett@cs.ubc.ca",
                  span("fhackett@cs.ubc.ca")
                ),
                // row 2
                span("Github"),
                img(
                  *.src := "/icons/github-mark.svg",
                  *.cls := "h-1em",
                  *.cls := "mx-auto"
                ),
                span("≝"),
                tags.a(
                  *.cls := "underline",
                  *.cls := "hover:no-underline",
                  *.cls := "color-black",
                  *.href := "https://www.github.com/fhackett",
                  span("https://www.github.com/fhackett")
                )
              )
            ),
            // ---
            tags2.section(
              *.cls := "pt-4",
              *.cls := "lg:pl-2",
              *.cls := "border-x-0",
              h2("Education 🧑‍🎓"),
              ul(
                *.cls := "list-none",
                *.cls := "m-0",
                *.cls := "mb-4",
                *.cls := "p-0",
                *.cls := "inline-grid",
                *.cls := "grid-cols-[repeat(1,min-content)auto]",
                *.cls := "gap-3",
                tags.span("🏫"),
                li(
                  "PhD, University of British Columbia, 2020-current. Supervised by ",
                  people.bestchai.link,
                  "."
                ),
                tags.span("🎓"),
                li(
                  "MMath, University of Waterloo, 2018-2020. Supervised by ",
                  people.olhotak.link,
                  "."
                ),
                tags.span("🎓"),
                li("BSc w/Co-op, University of British Columbia, 2013-2018.")
              )
            )
          )
        ),
        // ---
        tags2.section(
          *.cls := "pt-4",
          *.cls := "border-x-0",
          // lg image show
          *.cls := "lg:grid",
          *.cls := "lg:grid-cols-[repeat(1,3fr)1fr]",
          div(
            h2("Talks 🎙️"),
            talks.map(_.render)
          ),
          placeImg("/gfx/martin-1.png")
        ),
        // ---
        tags2.section(
          *.cls := "pt-4",
          *.cls := "border-x-0",
          // lg image show
          *.cls := "lg:grid",
          *.cls := "lg:grid-cols-[repeat(1,3fr)1fr]",
          div(
            h2("Publications 📜"),
            publications.map(_.render)
          ),
          placeImg("/gfx/martin-2.png")
        )
      )

  val talks: List[Talk | InvitedTalk] = List(
    InvitedTalk(
      title = "Compiling Distributed System Models with PGo, and Beyond",
      venues = List(
        Venue(
          date = "October'24",
          name = "RPTU Kaiserslautern-Landau",
          href = "https://softech.cs.rptu.de/",
          hosts = List(people.annetteBieniusa)
        ),
        Venue(
          date = "August'24",
          name = "Oxford University",
          href = "https://mrg.cs.ox.ac.uk/",
          hosts = List(people.nobukoYoshida)
        ),
        Venue(
          date = "August'24",
          name = "Imperial College London",
          href = "https://www.imperial.ac.uk/computing",
          hosts = List(people.mariosKogias)
        ),
        Venue(
          date = "July'24",
          name = "Cambridge University",
          href =
            "https://www.cst.cam.ac.uk/research/themes/systems-and-networking",
          hosts = List(people.heidiHoward, people.ryanGibb)
        ),
        Venue(
          date = "January'24",
          name = "Microsoft Research Cambridge",
          href =
            "https://www.microsoft.com/en-us/research/group/azure-security-privacy/",
          hosts = List(people.matthewParkinson)
        )
      )
    ),
    Talk(
      title =
        "Promises and Challenges in Bridging TLA+ Designs with Implementations",
      href = None,
      venueName = "TLA+Conf'24",
      venueHref = "https://conf.tlapl.us/2024/",
      authors = List(people.fhackett, people.bestchai)
    ),
    Talk(
      title = "Turning an Incident Report into a Design Issue with TLA+",
      href = Some("https://www.youtube.com/watch?v=_-kthTsZ2qU"),
      venueName = "SREcon'23 Americas",
      venueHref = "https://www.usenix.org/conference/srecon23americas",
      authors = List(people.fhackett, people.josuaRowe, people.makuppe)
    ),
    Talk(
      title = "Building Correct Distributed Systems with the PGo Compiler",
      href = Some("https://www.youtube.com/watch?v=XHqd60ZeUBo"),
      venueName = "TLA+Conf'22",
      venueHref = "https://conf.tlapl.us/2022/",
      authors = List(
        people.fhackett,
        people.shayanh,
        people.ruchitPalrecha,
        people.yennisYe,
        people.bestchai
      )
    ),
    Talk(
      title =
        "Compiling Distributed System Models into Implementations with PGo",
      href = Some("https://www.youtube.com/watch?v=GvrpUeDN5zs"),
      venueName = "TLA+Conf'19",
      venueHref = "https://conf.tlapl.us/2019/",
      authors = List(
        people.fhackett,
        people.bestchai,
        people.renatoCosta,
        people.matthewDo
      )
    )
  )

  final case class InvitedTalk(
      title: String,
      venues: List[Venue]
  ) extends Renderable:
    def render: Text.Modifier =
      div(
        *.cls := "mb-3",
        div(
          *.cls := "mb-2",
          span("Invited talk:"),
          " ",
          span(
            *.cls := "font-bold",
            title
          )
        ),
        ul(
          *.cls := "ml-8",
          *.cls := "my-0",
          *.cls := "p-0",
          *.cls := "list-none",
          modifier(venues.map(venue => li(venue.render))*)
        )
      )

  final case class Venue(
      date: String,
      name: String,
      href: String,
      hosts: List[people.Person]
  ) extends Renderable:
    def render: Text.Modifier =
      modifier(
        "📆 ",
        date,
        " ",
        a(
          *.href := href,
          s"@$name"
        ),
        " (hosted by ",
        people.authorList(hosts),
        ")"
      )

  final case class Talk(
      title: String,
      href: Option[String],
      venueName: String,
      venueHref: String,
      authors: List[people.Person],
      readBy: Option[Frag] = None
  ) extends Renderable:
    def render: Text.Modifier =
      div(
        *.cls := "mb-3",
        div(
          *.cls := "mb-2",
          a(
            *.href := venueHref,
            "[",
            venueName,
            "]"
          ),
          " ",
          href match
            case None =>
              span(
                *.cls := "font-bold",
                title
              )
            case Some(href) =>
              a(
                *.cls := "font-bold",
                *.href := href,
                title
              )
        ),
        div(
          *.cls := "ml-8",
          span(
            people.authorList(authors)
          )
        )
      )

  final case class Publication(
      title: String,
      href: String,
      venueName: String,
      venueHref: String,
      authors: List[people.Person],
      pdfLink: Option[String] = None,
      badges: Option[Text.Modifier] = None
  ) extends Renderable:
    def render: Text.Modifier =
      div(
        *.cls := "mb-3",
        div(
          *.cls := "mb-2",
          a(
            *.href := venueHref,
            "[",
            venueName,
            "]"
          ),
          " ",
          a(
            *.cls := "font-bold",
            *.href := href,
            title
          ),
          pdfLink match
            case None => ""
            case Some(pdfLink) =>
              modifier(
                " ",
                a(
                  *.href := pdfLink,
                  "[pdf]"
                )
              ),
          badges match
            case None => ""
            case Some(badges) =>
              modifier(
                " ",
                badges
              )
        ),
        div(
          *.cls := "ml-8",
          span(
            people.authorList(authors)
          )
        )
      )

  val publications: List[Publication] = List(
    Publication(
      title = "Going Beyond an Incident Report with TLA+",
      href =
        "https://www.usenix.org/publications/loginonline/going-beyond-incident-report-tla",
      venueName = ";login:",
      venueHref = "https://www.usenix.org/publications/loginonline/",
      pdfLink =
        Some("/files/_login__Going_Beyond_an_Incident_Report_with_TLA_.pdf"),
      authors = List(people.fhackett, people.josuaRowe, people.makuppe)
    ),
    Publication(
      title = "Compiling Distributed System Models with PGo",
      href = "https://doi.org/10.1145/3575693.3575695",
      venueName = "ASPLOS'23",
      venueHref = "https://asplos-conference.org/2023",
      pdfLink = Some("files/asplosb23main-p12-p-e73de3693c-62943-final.pdf"),
      badges = Some(
        modifier(
          tags.span(
            *.cls := "ml-1",
            *.cls := "space-x-1",
            modifier(
              (List(
                "/icons/results_reproduced_v1_1.png" -> "https://www.acm.org/publications/policies/artifact-review-and-badging-current#reproduced",
                "/icons/artifacts_evaluated_functional_v1_1.png" -> "https://www.acm.org/publications/policies/artifact-review-and-badging-current#functional",
                "/icons/artifacts_available_v1_1.png" -> "https://www.acm.org/publications/policies/artifact-review-and-badging-current#available"
              ).map: (src, href) =>
                tags.a(
                  *.href := href,
                  img(
                    *.src := src,
                    *.cls := "h-1.5em",
                    *.cls := "inline",
                    *.cls := "align-middle"
                  )
                ))*
            )
          ),
          " ",
          span(
            *.cls := "font-[Bangers]",
            "+ 🏆 Distinguished Artifact!"
          )
        )
      ),
      authors = List(
        people.fhackett,
        people.shayanh,
        people.renatoCosta,
        people.matthewDo,
        people.bestchai
      )
    ),
    Publication(
      title = "Understanding Inconsistency in Azure Cosmos DB with TLA+",
      href = "https://doi.org/10.1109/ICSE-SEIP58684.2023.00006",
      venueName = "ICSE-SEIP'23",
      venueHref = "https://conf.researchr.org/track/icse-2023/icse-2023-SEIP",
      pdfLink = Some("/files/icse-seip-23-inconsistency.pdf"),
      authors = List(people.fhackett, people.josuaRowe, people.makuppe)
    ),
    Publication(
      title = "mel- model extractor language for extracting facts from models",
      href = "https://doi.org/10.1145/3365438.3410964",
      venueName = "MODELS'20",
      venueHref = "https://conf.researchr.org/home/models-2020",
      badges = Some(
        tags.a(
          *.cls := "ml-1",
          *.href := "https://www.acm.org/publications/policies/artifact-review-and-badging-current#functional",
          img(
            *.src := "/icons/artifacts_evaluated_functional_v1_1.png",
            *.cls := "h-1.5em",
            *.cls := "inline",
            *.cls := "align-middle"
          )
        )
      ),
      authors =
        List(people.rhackma, people.jmatlee, people.fhackett, people.migod)
    )
  )
