import * as util from "../util";
import * as authors from "../authors";
import * as venues from "../venues";

import { JSX } from "solid-js";

function fmtEnumeration(elems: JSX.Element[]): JSX.Element {
  return (<ul>{elems.map((elem, idx) => {
    let suffix =
      idx === 0 && elems.length === 2 ? (
        <>&nbsp;and&nbsp;</>
      ) : idx === elems.length - 2 ? (
        <>, and&nbsp;</>
      ) : idx < elems.length - 1 ?  (
        <>,&nbsp;</>
      ) : (
        <></>
      );

    return (
      <li classList={{'inline-block': true}}>
        {elem}
        {suffix}
      </li>
    );
  })}</ul>);
}

function fmtAuthors(authors: authors.Author[]) {
  if (authors) {
    return (
      <div class="pl-8 flex flex-row flex-wrap italic">
        {fmtEnumeration(authors.map((author) => author.jsx()))}
      </div>
    );
  } else {
    return <></>;
  }
}

function fmtOptHref(
  str: string,
  href?: string,
  cls: { [k: string]: boolean } = {}
) {
  if (href) {
    return (
      <a href={href} classList={{ ...util.hrefStyle, ...cls }}>
        {str}
      </a>
    );
  } else {
    return <span classList={cls}>{str}</span>;
  }
}

export default function Intro() {
  return (
    <div class="md:grid md:grid-cols-[.7fr_.3fr]">
      <main class="p-4 prose prose-zinc container max-w-none prose-headings:mb-3 prose-hr:my-4">
        <h1>Self-Introduction</h1>

        <p>
          I'm a PhD student at the University of British Columbia, and I'm
          interested in programming language design in an applied context. I
          consider domain-specific problems from a linguistic viewpoint, and try
          to help people deal with a given issue easier by helping them express
          themselves more effectively.
        </p>

        <p>
          At the moment, I'm primarily working in the TLA+ ecosystem, where I am
          one of the main developers of the{" "}
          <a href="https://github.com/UBC-NSS/pgo">PGo project</a>. The
          project's goal is to take a simplified, more pragmatic approach to
          verified distributed systems development by providing lighter-weight
          model checking-based verification alongside a simplified
          imperative-like modeling language and a flexible API for
          interoperation between verified and unverified code.
        </p>

        <p>
          This site, like a CV but more colourful, combines information about my
          projects and other pursuits for those interested. Check out the links
          at the top for more information.
        </p>

        <hr />

        <h2>Education</h2>

        <ul>
          <li>
            PhD, University of British Columbia, 2020-current. Supervised by{" "}
            {authors.bestchai.jsx()}.
          </li>
          <li>
            MMath, University of Waterloo, 2018-2020. Supervised by{" "}
            {authors.olhotak.jsx()}.
          </li>
          <li>BSc w/Co-op, University of British Columbia, 2013-2018.</li>
        </ul>

        <hr />

        <h2>Contact</h2>

        <div class="not-prose grid grid-cols-[3em_1em_minmax(0,1fr)] gap-2">
          <div>Email</div>
          <div>📧</div>
          <div class="underline font-medium pl-3">
            <a href="mailto:fhackett@cs.ubc.ca">fhackett@cs.ubc.ca</a>
          </div>

          <div>Github</div>
          <img
            class="inline h-4 w-4"
            src="/icons/GitHub-Mark-32px.png"
            alt="Github icon"
          />
          <div class="underline font-medium pl-3">
            <a href="https://www.github.com/fhackett">
              https://www.github.com/fhackett
            </a>
          </div>
        </div>

        <hr />

        <h2>Talks</h2>

        <div classList={{'not-prose': true, 'pb-2': true}}>
          [Invited] <span classList={{'font-bold': true}}>Compiling Distributed System Models with PGo, and Beyond</span>
          <div classList={{'pl-8': true, 'flex': true, 'flex-row': true, 'flex-wrap': true}}>
            {fmtEnumeration([
              // <>@Oxford University</>,
              <>August'24 @<a href="https://www.imperial.ac.uk/computing" classList={util.hrefStyle}>Imperial College London</a> (hosted by&nbsp;<a href="https://marioskogias.github.io/" classList={util.hrefStyle}>Marios Kogias</a>)</>,
              <>July'24 @<a href="https://www.cst.cam.ac.uk/research/themes/systems-and-networking" classList={util.hrefStyle}>Cambridge University</a> (hosted by&nbsp;<a href="https://heidihoward.github.io/" classList={util.hrefStyle}>Heidi Howard</a>, <a href="https://ryan.freumh.org/about.html" classList={util.hrefStyle}>Ryan Gibb</a>)</>,
              <>January'24 @<a href="https://www.microsoft.com/en-us/research/group/azure-security-privacy/" classList={util.hrefStyle}>Microsoft Research Cambridge</a> (hosted by&nbsp;<a href="https://www.microsoft.com/en-us/research/people/mattpark/" classList={util.hrefStyle}>Matthew Parkinson</a>)</>,
            ])}
          </div>
        </div>

        {(() => {
          interface Talk {
            title: string;
            authors: authors.Author[];
            venue: venues.Venue;
            href?: string;
          }

          const talks: Talk[] = [
            {
              title:
                "Promises and Challenges in Bridging TLA+ Designs with Implementations",
              authors: [authors.finnHackett, authors.bestchai],
              venue: venues.tlaconf.at_year(
                "24",
                "https://conf.tlapl.us/2024/"
              ),
            },
            {
              title: "Turning an Incident Report into a Design Issue with TLA+",
              authors: [
                authors.finnHackett,
                authors.joshuaRowe,
                authors.makuppe,
              ],
              venue: venues.srecon
                .at_track(" Americas")
                .at_year(
                  "23",
                  "https://www.usenix.org/conference/srecon23americas"
                ),
              href: "https://www.youtube.com/watch?v=_-kthTsZ2qU",
            },
            {
              title:
                "Building Correct Distributed Systems with the PGo Compiler",
              authors: [
                authors.finnHackett,
                authors.shayanh,
                authors.ruchitp,
                authors.yennisy,
                authors.bestchai,
              ],
              venue: venues.tlaconf.at_year(
                "22",
                "https://conf.tlapl.us/2022/"
              ),
              href: "https://www.youtube.com/watch?v=XHqd60ZeUBo",
            },
            {
              title:
                "Compiling Distributed System Models into Implementations with PGo",
              authors: [
                authors.finnHackett,
                authors.bestchai,
                authors.renatocosta,
                authors.matthewdo,
              ],
              venue: venues.tlaconf.at_year(
                "19",
                "https://conf.tlapl.us/2019/"
              ),
              href: "https://www.youtube.com/watch?v=GvrpUeDN5zs",
            },
          ];

          return talks.map((talk) => (
            <div class="not-prose pb-2">
              {talk.venue.jsx()}
              &nbsp;
              {fmtOptHref(talk.title, talk.href, { "font-bold": true })}
              {fmtAuthors(talk.authors)}
            </div>
          ));
        })()}

        <hr />

        <h2>Publications</h2>

        {(() => {
          interface Publication {
            title: string;
            authors: authors.Author[];
            venue: venues.Venue;
            href?: string;
            pdf?: string;
            awards?: JSX.Element[];
          }

          const pubs: Publication[] = [
            {
              title: "Going Beyond an Incident Report with TLA+",
              authors: [
                authors.finnHackett,
                authors.joshuaRowe,
                authors.makuppe,
              ],
              venue: venues.login,
              href: "https://www.usenix.org/publications/loginonline/going-beyond-incident-report-tla",
              pdf: "/files/_login__Going_Beyond_an_Incident_Report_with_TLA_.pdf",
            },
            {
              title: "Compiling Distributed System Models with PGo",
              authors: [
                authors.finnHackett,
                authors.shayanh,
                authors.renatocosta,
                authors.matthewdo,
                authors.bestchai,
              ],
              venue: venues.asplos.at_year(
                "23",
                "https://asplos-conference.org/2023"
              ),
              href: "https://doi.org/10.1145/3575693.3575695",
              pdf: "/files/asplosb23main-p12-p-e73de3693c-62943-final.pdf",
              awards: [
                <a href="https://www.acm.org/publications/policies/artifact-review-and-badging-current#reproduced">
                  <img
                    src="/icons/results_reproduced_v1_1.png"
                    class="inline w-6"
                  />
                </a>,
                <a href="https://www.acm.org/publications/policies/artifact-review-and-badging-current#functional">
                  <img
                    src="/icons/artifacts_evaluated_functional_v1_1.png"
                    class="inline w-6"
                  />
                </a>,
                <a href="https://www.acm.org/publications/policies/artifact-review-and-badging-current#available">
                  <img
                    src="/icons/artifacts_available_v1_1.png"
                    class="inline w-6"
                  />
                </a>,
                <span class="font-['Bangers']">
                  + 🏆 Distinguished Artifact!
                </span>,
              ],
            },
            {
              title: "Understanding Inconsistency in Azure Cosmos DB with TLA+",
              authors: [
                authors.finnHackett,
                authors.joshuaRowe,
                authors.makuppe,
              ],
              venue: venues.icse
                .at_track("-SEIP")
                .at_year(
                  "23",
                  "https://conf.researchr.org/track/icse-2023/icse-2023-SEIP"
                ),
              href: "https://doi.org/10.1109/ICSE-SEIP58684.2023.00006",
              pdf: "/files/icse-seip-23-inconsistency.pdf",
            },
            {
              title:
                "mel- model extractor language for extracting facts from models",
              authors: [
                authors.rhackma,
                authors.jmatlee,
                authors.finnHackett,
                authors.migod,
              ],
              venue: venues.models.at_year(
                "20",
                "https://conf.researchr.org/home/models-2020"
              ),
              href: "https://doi.org/10.1145/3365438.3410964",
              awards: [
                <a href="https://www.acm.org/publications/policies/artifact-review-and-badging-current#functional">
                  <img
                    src="/icons/artifacts_evaluated_functional_v1_1.png"
                    class="inline w-6"
                  />
                </a>,
              ],
            },
          ];

          return pubs.map((pub) => {
            return (
              <div class="not-prose pb-2">
                {pub.venue.jsx()}
                &nbsp;
                {fmtOptHref(pub.title, pub.href, { "font-bold": true })}
                {pub.pdf ? (
                  <>
                    &nbsp;
                    <a href={pub.pdf} classList={util.hrefStyle}>
                      [pdf]
                    </a>
                  </>
                ) : (
                  <></>
                )}
                {pub.awards ? <>&nbsp;{pub.awards}</> : <></>}
                {fmtAuthors(pub.authors)}
              </div>
            );
          });
        })()}
      </main>

      <div class="hidden md:block bg-gradient-to-br from-white via-white to-zinc-400">
        <img
          src="/gfx/splash_img.png"
          class="w-full rounded-bl-[10rem]"
          draggable="false"
        />
      </div>
    </div>
  );
}
