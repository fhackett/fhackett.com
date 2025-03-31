package site

import customtags.*
import scalatags.Text
import scalatags.Text.tags
import scalatags.Text.tags2

import scala.collection.mutable

object music_releases extends Target:
  def path: os.SubPath = os.sub / "music_releases.html"

  def content: geny.Writable =
    wrapHeader:
      tags2.main(
        *.cls := "container",
        *.cls := "mx-auto",
        *.cls := "flex",
        *.cls := "flex-col",
        *.cls := "items-center",
        h2.withStyles(*.cls := "mt-4")(
          "Music Releases",
        ),
        p.withStyles(
          *.cls := "max-w-xl",
          *.cls := "text-center",
          *.cls := "mb-0",
        )(
          "Here is most of the music I've made since I started in high school, around 2010.",
          " Genres are just a label, but to give you an idea, I'm somehow inspired by dub, techno, ambient music, breakbeats, breakcore, math rock, stuff like that.",
        ),
        hr(
          *.cls := "w-sm",
          *.cls := "border-gray-500",
          *.cls := "border-solid",
          *.cls := "my-4",
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
          releases.map(_.render),
        ),
      )

  def credits(content: Text.Modifier*): Text.Modifier =
    div(
      span(
        "Credits: ",
      ),
      ul(
        *.cls := "mt-1",
        *.cls := "pl-4",
        *.cls := "list-square",
        content,
      ),
    )

  def showMore(maxCls: String)(content: Text.Modifier*): Text.Modifier =
    div(
      *.cls := "show-more-container",
      div(
        *.cls := "show-more-content",
        *.cls := maxCls,
        *.cls := s"show-more-cls-$maxCls",
        *.cls := "overflow-y-hidden",
        content,
      ),
      a(
        *.cls := "block",
        *.cls := "show-more-button-more",
        *.cls := "hidden",
        *.cls := "italic",
        *.cls := "pt-2",
        "...Show more",
      ),
      a(
        *.cls := "block",
        *.cls := "show-more-button-less",
        *.cls := "hidden",
        *.cls := "pt-2",
        "Show less",
      ),
    )

  val releases: List[Release] = List(
    Release(
      name = "dreamcatcher",
      date = "November'24",
      coverArt = "/album-covers/dreamcatcher.png",
      bandCamp =
        Some("https://alistairthemany.bandcamp.com/album/dreamcatcher"),
      soundCloud = Some("https://soundcloud.com/finnhackett/sets/dreamcatcher"),
      content = frag"""
          On a technical level, much of this album is me trying to better understand cymbals.
          For something you can reductively describe as lightly curved bits of metal, they are way more complex than you'd think.
          Mixing them to get that "big" sound is, likewise, quite tricky.

          I've always looked up to artists who can express complex, engaging patterns in music.
          Prog rock and math rock come to mind, but on a different day I might mention something else.
          It's not like most of my music doesn't have odd meters / timings / etc in it, especially with my latest album "half past never", but I wanted to really go all in on making something complex but catchy.
          Kind of like a little dream diary, of mostly fun and interesting dreams.
          Nightmares, we can do some other time.

          Well, here it is.
          Something to keep my mind off being away from home on an extended trip that's lasted almost 6 months.

          Several pieces are also inspired in part by Martin Hackett's flute playing.
          He sent me several samples, which I used in most of the tracks in the second half.

          The album art is an edited photo of graffiti that we found on a stone monolith in Parc Barbieux, Lille, France.
          Just towering out of the grass among the trees, with nothing else written on it.
          An odd sight, especially given the relatively atypical graffiti style.

          ${credits(
          li(
            """Martin Hackett, tin whistle, 笛子, and Quena on "fetch the etching fluid", "a hidden cavern full of lies", "but there's sand in the hourglass", "black hole in the river", and "and so I became non-linear".""",
          ),
          li(
            """Tim Straubinger, foley percussion on "black hole in the river" and "far woodpecker".""",
          ),
          li(
            """Shayan Hosseini: foley and chatter in between takes for an academic presentation on "black hole in the river".""",
          ),
          li("""Ivan Beschastnikh: birdsong foley on "the smallest puzzle"."""),
        )}
      """,
    ),
    Release(
      name = "half past never",
      date = "August'24",
      coverArt = "/album-covers/half past never.png",
      bandCamp =
        Some("https://alistairthemany.bandcamp.com/album/half-past-never"),
      soundCloud =
        Some("https://soundcloud.com/finnhackett/sets/half-past-never"),
      content = frag"""
          I wanted to focus on arrhythmia.
          It's easy when producing to let your DAW's tempo tell you what to do, and I wanted to push my attention toward avoiding that, while writing some faster stuff.

          To make the concept happen, I used a mixture of tempo automation, timestretched midi clips (so the notes shift on and off the grid), and modular delay/resampler patches.

          ${credits(
          li("Kaddy Beck, sculpture used in album art."),
          li(
            """Martin Hackett, Korg MS-20 on "crystal hexagons that don't melt"."""",
          ),
          li(
            """Tim Straubinger, databending on "crystal hexagons that don't melt"."""",
          ),
          li("""Kira Potter, vocals on "green algae on our cobalt beach""""),
        )}
        """,
    ),
    Release(
      name = "no clicks at all; there it is again",
      date = "February'24",
      coverArt = "/album-covers/lake with green and grey conifers.png",
      soundCloud = Some(
        "https://soundcloud.com/finnhackett/sets/no-clicks-at-all-there-it-is",
      ),
      content = frag"""
          Collaboration with Martin Hackett, whose synth playing is featured on all tracks.

          Originally an exercise in imagining Martin's playing as techno, the album grew out of different sessions of editing some performances he recorded for me.

          Credit to Kira Potter for keyboard arrangements woven into "sailor take warning", and general thoughts on the tracks.
        """,
    ),
    Release(
      name = "brain slice",
      date = "February'24",
      coverArt = "/album-covers/brain%20slice.png",
      soundCloud = Some("https://soundcloud.com/finnhackett/sets/brain-slice"),
      content = frag"""
          That's not a brain.
          It's a lot of progressive bass music.

          I wanted to make this one bigger and with weirder drum breaks.
          I learned some cool sound design stuff along the way.

          Credit to Kira Potter for little bits of advice on many tracks, and for inspiring the cover + title.
        """,
    ),
    Release(
      name = "kinda strictly sorta maybe?",
      date = "July'23",
      coverArt = "/album-covers/kinda strictly sorta maybe cover.png",
      soundCloud = Some(
        "https://soundcloud.com/finnhackett/sets/kinda-strictly-sorta-maybe",
      ),
      content = frag"""
          I guess...

          More focus on clear production and dynamics, but bringing in more tricky fun stuff. I had fun making these.

          ${credits(
          li(
            "Martin Hackett, Korg MS-20 played on \"monsieur hulot's pipe machine\".",
          ),
          li("Onkle Honky, horn demo on \"monsieur hulot's pipe machine\"."),
          li(
            "[redacted] Airlines, announcements on \"that's not wensleydale, gromit!\", \"modern glass\", and \"mercury\".",
          ),
          li(
            "Shayan Hosseini, academic presentation resampled on \"boat trip in amber\".",
          ),
        )}

          Other samples include Australian birdlife and foley I recorded on a trip.
          Mildly interesting: there is some heavily processed amateur beatboxing by me on "became flowers".
          A majority of the percussion is synthesized from basic waveforms, though not with any particular discipline or anything.
        """,
    ),
    Release(
      name = "athena's playground",
      date = "September'22",
      coverArt = "/album-covers/athena's playground cover.jpg",
      soundCloud =
        Some("https://soundcloud.com/finnhackett/sets/athenas-playground"),
      content = frag"""
          A collection of tracks I made while trying to improve my mixing skills, focusing on having clearer, punchier drums and bass.
          Not sure if I succeeded, but I think the results have been interesting overall.

          Most of the drum sounds are scratch-made modular patches using sine waves and filtered noise, which was an interesting challenge.

          ${credits(
          li("""Zach Morgenstern: vocals+lyrics on "avcodec mangrove nice""""),
          li(
            """Tim Straubinger: very nice.zip data bending on "avcodec mangrove nice" and "very nice digital mold.mkl_core"""",
          ),
          li(
            """Alex Trostanovsky: guitar and a MIDI clip on "triangle sound"""",
          ),
          li(
            """Shaurya Patel: spoken word on "an iridescent manifold", spoken word and Sitar on "very nice digital mold.mkl_core" and "one more time"""",
          ),
        )}

          Additional credit to Nicholas Ioannidis for translating the Greek joke text on the cover.
        """,
    ),
    Release(
      name = "the mountain underground",
      date = "April'22",
      coverArt = "/album-covers/the mountain underground cover.png",
      soundCloud = Some(
        "https://soundcloud.com/finnhackett/sets/the-mountain-underground",
      ),
      content = frag"""
          Some days, I'm not sure what this album is. It might be about me digging myself out of writer's block (or trying to).
          It might be about fairy tales, Gulliver's Travels, awe-inspiring rock formations, or it might be about none of those things at all.

          I pushed myself in terms of sound design, including some experiments with more aggressive use of generative sequencing and more complex, intentionally "broken sounding" distortion chains.

          I'm quite proud of the cover art.
          I'm not the most focused visual artist, and I think it's a step up for me in terms of visual interest.
          Like with others, it's a visual composite of geometric shapes and pictures I've taken.

          If anything, overall the result is maybe a little crowded, but I think that's just the way it's going to be.
          For now, this is the best version of this work that we'll have.

          Publish that thing, write that paragraph, go review your in-progress drafts.
          It's expected for your work to have flaws.
          More than just "don't listen to the haters" (I refer to criticism without substance here), we must not give up just because our work truly has flaws. Of course it does - we must simply strive to improve and address them as best we can.

          ${credits(
          li(
            "Kira Potter - comments on in-progress drafts, concept for the title.",
          ),
          li(
            "Martin Hackett - one of his paintaings is partially visible in the album art.",
          ),
        )}
          """,
    ),
    Release(
      name = "living elements",
      date = "March'22",
      coverArt = "/album-covers/living elements cover.jpg",
      soundCloud =
        Some("https://soundcloud.com/finnhackett/sets/living-elements"),
      content = frag"""
          Almost entirely composed of collaborations, this album can be said to contain living elements.

          ${credits(
          li("""Shaurya Patel: sitar on "dirty sunrise""""),
          li(
            """Martin Hackett: Korg MS-10 on "dirty sunrise" and "controlling the media"""",
          ),
          li(
            """Kira Potter: vocals on "controlling the media" and "panpipes"""",
          ),
          li(
            """Preeti Vyas: field recordings on "beachside" and "it's not that far"; vocals on "beachside"; spoken word on "it's not that far"""",
          ),
          li(
            """Zach Morgenstern: vocals on "blurry sunshine", "a hollow in the earth", and "green ball of energy"; guitar on "a hollow in the earth" and "green ball of energy"""",
          ),
        )}

          Note: all contributions are written/originated by the contributor in question, to then be remixed by myself into the released composition.

          The album art was taken under a bridge in Oxford, UK. The graffiti "contributor" is unknown.
        """,
    ),
    Release(
      name = "water, in bloom",
      date = "May'21",
      coverArt = "/album-covers/water in bloom cover.jpg",
      soundCloud =
        Some("https://soundcloud.com/finnhackett/sets/water-in-bloom"),
      content = frag"""
          This collection of tracks chronicles my recent experiments in absorbing and repurposing EDM and bass music production techniques.

          The resulting mood is a bit odd.
          It's uncharacteristic of me in a few ways... but also, it's really interesting to explore this more "commercial" production style (including more effort on melodic parts), while still keeping my fundamental motivation for making music intact.

          That's how I came up with the main image for the resulting tracklist: it's water, an inorganic thing, quite inert when pure... but it's blooming, as if it's full of life.
          I don't know why.
          Maybe it's beyond me to make sense of it, but I think it has a kind of fluid beauty to it, however one might interpret that.

          ${credits(
          li(
            """Tim Straubinger, a variety of short impacts and household items""",
          ),
          li(
            """Ivan Beschasnikh, some of the longer-form environmental field recordings, most notably on floating forest""",
          ),
        )}
        """,
    ),
    Release(
      name = "restransmit",
      date = "December'20",
      coverArt = "/album-covers/retransmit cover.png",
      soundCloud = Some("https://soundcloud.com/finnhackett/sets/retransmit"),
      content = frag"""
          Transmission failed. Retransmit.

          If it doesn't work the first time, try again.

          Lots of challenges on this album, artificial challenges, life challenges, accidental challenges. I've been inspired by a lot of more mainstream EDM/bass music, not that it shows much on the surface.

          This is also one of my first ever releases with actual vocals, albeit synthetic ones (courtesy of the flite speech synth).

          I hope you're making the best of whatever you've got.
        """,
    ),
    Release(
      name = "I saw skulls",
      date = "June'20",
      coverArt = "/album-covers/I saw skulls cover.jpg",
      soundCloud = Some("https://soundcloud.com/finnhackett/sets/i-saw-skulls"),
      content = frag"""
          After finishing almost all production on the album, I realised it's really an exploration of my relationship with grief and mortality through a musical lens.

          Originally I just had this vague idea to challenge myself by making musical choices that were deliberately "ugly".
          Not ugly in the sense that "metal is an ugly art form" (Devin Townsend), but more in the sense of "Man plays [song title] without actually learning it" (hi Kmac).
          Detuned, inharmonious playing in the style of traditional melodies.
          Also, fragments of a non-existent sci-fi movie about someone coming to terms with being lost and alone in a vast, ancient alien facility.

          The skull in the album cover is a decoration in my home - my partner rescued it from the UBC biology department's clear-out a few years ago.
        """,
    ),
    Release(
      name = "pixelated beach",
      date = "May'20",
      coverArt = "/album-covers/pixellated beach cover.png",
      soundCloud =
        Some("https://soundcloud.com/finnhackett/sets/pixellated-beach"),
      content = frag"""
          Experimenting with much more detailed sound design than I've had the tools for till now.
          Lots of modular/semi-modular stuff, and more advanced sample manipulation.
          That is to say, I am enjoying my recently-acquired copy of Bitwig Studio.
          
          The results ended up being some kind of noir-breakbeat-ambient... thing.
          Several tracks inspired by walking across the cliffs near Whitby in the UK, where I took some of the field recordings.
        """,
    ),
    Release(
      name = "plastick",
      date = "April'20",
      coverArt = "/album-covers/plastick cover.png",
      soundCloud = Some("https://soundcloud.com/finnhackett/sets/plastick"),
      content = frag"""
          An exploration of more traditional breakbeat stuff, with an overall sound that turned out kind of like ... plastic.

          Point of interest: except for the amens, all the drums are synthesized from basic waveforms (well, everything else is too, but that's more what you'd expect).
          It was an interesting learning experience.

          Also the first release I've made a conscious effort to master, so more learning there.
        """,
    ),
    Release(
      name = "alien adventure",
      date = "March'18",
      coverArt = "/album-covers/alien adventure cover.jpg",
      soundCloud =
        Some("https://soundcloud.com/finnhackett/sets/alien-adventure"),
      content = frag"""
          This album originally had no description.
          
          It is one of relatively few releases from the years I spent trying hardware synths and grooveboxes.
          I would work in a sort of "jam" format, record into Audacity, and then edit the results.

          The perhaps surprising conclusion, if you've heard the common sentiment of "hardware fosters creativity", is that the way I think is much better served by working on a computer.
          I actually like having to sit down and click on things, build my own characterful digital instruments from scratch as part of songwriting, and so forth.

          Well, it doesn't mean that this time was useless or meaningless.
          I still have most of the kit, and I learned how to do some jury-rigged live stuff.
        """,
    ),
    Release(
      name = "morning greyshadow",
      date = "November'17",
      coverArt = "/album-covers/morning greyshadow cover.jpg",
      soundCloud =
        Some("https://soundcloud.com/finnhackett/sets/morning-greyshadow"),
      content = frag"""
          An EP I made some time ago while experimenting with live recordings, sampling and audio treatments.
          Some rough edges.

          Possibly inspired by Clark and nuclear waste.
        """,
    ),
    Release(
      name = "sky in the fish (version)",
      date = "'14",
      coverArt = "/album-covers/sky in the fish (version) cover.png",
      soundCloud =
        Some("https://soundcloud.com/finnhackett/sets/sky-in-the-fish-version"),
      content = frag"""
          A work in progress (maybe?) made by cutting up live sequencing/playing of a set of Korg Volcas and a Roland SH-101.
          
          Helpful extras: Korg Kaoss Pad Quad, Monotron Delay.
        """,
    ),
    Release(
      name = "numbers",
      date = "'14",
      coverArt = "/album-covers/retransmit cover.png",
      soundCloud = Some("https://soundcloud.com/finnhackett/sets/numbers-1"),
      content = frag"""
          A brief moment of sanity.

          Thanks to Squarepusher's Go Plastic and Biosphere's Substrata for inspiration.
        """,
    ),
    Release(
      name = "generator",
      date = "June'13",
      coverArt = "/album-covers/generator cover.png",
      soundCloud = Some("https://soundcloud.com/finnhackett/sets/ocularis-1"),
      content = frag"""
          Album focusing more on ambience and minor details.
          
          Try not to overthink the genre tags, and I hope you enjoy the story/places/whatever-comes-to-mind.
        """,
    ),
  )

  final case class Release(
      name: String,
      date: String,
      coverArt: String,
      soundCloud: Option[String] = None,
      bandCamp: Option[String] = None,
      content: Modifier = "",
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
          *.cls := "flex",
          *.cls := "flex-row",
          *.cls := "flex-wrap",
          name,
          span(
            *.cls := "ml-3",
            *.cls := "color-gray-500",
            *.cls := "text-base",
            *.cls := "font-normal",
            *.cls := "italic",
            date,
          ),
          tags.span(
            *.cls := "flex-grow",
          ),
          bandCamp match
            case None => ""
            case Some(bandCamp) =>
              a(
                *.cls := "ml-3",
                *.href := bandCamp,
                img(
                  *.src := "/icons/bandcamp-logotype-color-128.png",
                  *.cls := "h-1em",
                  *.cls := "inline",
                  *.cls := "align-middle",
                ),
              ),
          soundCloud match
            case None => ""
            case Some(soundCloud) =>
              a(
                *.cls := "ml-3",
                *.href := soundCloud,
                img(
                  *.src := "/icons/54546-1717072325-sc-logo-cloud-black-7412d7.svg",
                  *.cls := "h-1em",
                  *.cls := "inline",
                ),
              ),
        ),
        div(
          *.cls := "music-release",
          *.cls := "grid",
          *.cls := "grid-cols-[minmax(0px,1fr)2fr]",
          *.cls := "gap-3",
          img(
            *.cls := "w-full",
            *.src := coverArt,
          ),
          showMore("max-h-200px")(
            content,
          ),
        ),
      )
