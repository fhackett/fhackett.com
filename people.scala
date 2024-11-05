package io.github.fhackett

import scalatags.Text.Modifier
import customtags.*

object people:
  trait Person:
    def name: String
    def href: Option[String]

    def link: Modifier =
      href match
        case None => name
        case Some(href) =>
          a(
            *.href := href,
            name,
          )

  def authorList(list: List[Person]): Modifier =
    list match
      case Nil => ""
      case List(single) => single.link
      case List(fst, snd) =>
        modifier(
          fst.link,
          " and ",
          snd.link,
        )
      case list =>
        // size >= 3
        modifier(
          list.head.link,
          list.tail.init
            .map: person =>
              modifier(
                ", ",
                person.link,
              ),
          ", and ",
          list.last.link,
        )

  object bestchai extends Person:
    val name = "Ivan Beschastnikh"
    val href = Some("https://www.cs.ubc.ca/~bestchai/")

  object olhotak extends Person:
    val name = "Ondřej Lhoták"
    val href = Some("https://plg.uwaterloo.ca/~olhotak/")

  object fhackett extends Person:
    val name = "Finn Hackett"
    val href = Some("https://fhackett.github.io/")

  object renatoCosta extends Person:
    val name = "Renato Costa"
    val href = None

  object matthewDo extends Person:
    val name = "Matthew Do"
    val href = Some("https://minhdo.org/")

  object shayanh extends Person:
    val name = "Shayan Hosseini"
    val href = Some("https://shayanh.com/")

  object ruchitPalrecha extends Person:
    val name = "Ruchit Palrecha"
    val href = None

  object yennisYe extends Person:
    val name = "Yennis Ye"
    val href = None

  object josuaRowe extends Person:
    val name = "Joshua Rowe"
    val href = None

  object makuppe extends Person:
    val name = "Markus Alexander Kuppe"
    val href = Some("https://lemmster.de/")

  object mariosKogias extends Person:
    val name = "Marios Kogias"
    val href = Some("https://marioskogias.github.io/")

  object heidiHoward extends Person:
    val name = "Heidi Howard"
    val href = Some("https://heidihoward.github.io/")

  object ryanGibb extends Person:
    val name = "Ryan Gibb"
    val href = Some("https://ryan.freumh.org/about.html")

  object matthewParkinson extends Person:
    val name = "Matthew Parkinson"
    val href = Some("https://www.microsoft.com/en-us/research/people/mattpark/")

  object nobukoYoshida extends Person:
    val name = "Nobuko Yoshida"
    val href = Some("https://www.cs.ox.ac.uk/people/nobuko.yoshida/")

  object annetteBieniusa extends Person:
    val name = "Annette Bieniusa"
    val href = Some("https://softech.cs.rptu.de/team/annettebieniusa")

  object rhackma extends Person:
    val name = "Robert Hackman"
    val href = None

  object jmatlee extends Person:
    val name = "Joanne M. Atley"
    val href = Some("https://cs.uwaterloo.ca/~jmatlee/")

  object migod extends Person:
    val name = "Michael W. Godfrey"
    val href = Some("https://plg.uwaterloo.ca/~migod/")
