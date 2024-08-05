import { JSX } from "solid-js";

import * as authors from "../authors";

export default function ResearchProjects() {
  return (
    <main
      class="p-3 bg-cover"
      style={`background-image: url("/gfx/fish bg 1.png");`}
    >
      <div class="prose mx-auto text-center mb-4">
        <h1>Research Projects</h1>
      </div>

      <div class="gap-4 flex flex-col items-center">
        {(() => {
          interface ResearchProject {
            name: string;
            title: JSX.Element;
            img_src: string;
            description: JSX.Element;
          }

          const projects: ResearchProject[] = [
            {
              name: "PGo",
              img_src: "/logos/piggo_logo.png",
              title: (
                <>
                  <a href="https://distcompiler.github.io/">PGo</a> (
                  <a href="https://github.com/DistCompiler/pgo">on Github</a>)
                </>
              ),
              description: (
                <p>
                  A <em>distributed systems compiler</em>, aiming to provide
                  compilation from abstract model-checkable specifications in
                  PlusCal into Go code that can run on a real network. The
                  project includes networking support libraries, and Modular
                  Pluscal, a modular superset of PlusCal.
                </p>
              ),
            },
            {
              name: "TreeGen",
              img_src: "/logos/treegen_logo.png",
              title: (
                <>
                  TreeGen (
                  <a href="http://hdl.handle.net/10012/16133">MMath Thesis</a>)
                </>
              ),
              description: (
                <p>
                  My MMath thesis work. Designed to make Interface Definition
                  Language implementation easier, it's an impure functional
                  language with fully out-of-order processing, making
                  order-of-operations bugs, even involving pointers, impossible.
                </p>
              ),
            },
            {
              name: "mel",
              img_src: "/logos/gfx_missing.png",
              title: (
                <>
                  mel (
                  <a href="https://doi.org/10.1145/3365438.3410964">
                    MODELS 2020
                  </a>
                  )
                </>
              ),
              description: (
                <p>
                  <em>mel</em> is a declarative, rule-based Model Extraction
                  Language for extracting facts from XML-structured models of
                  software. This is a collaboration with{" "}
                  <a href="https://watform.uwaterloo.ca/">WatForm</a>, centered
                  around Rob Hackman's thesis under {authors.jmatlee.jsx()}. I
                  contributed evaluation work, comparing <em>mel</em> with&nbsp;
                  <a href="https://www.w3.org/TR/xquery/">XQuery</a>, an
                  established web standard with related properties.
                </p>
              ),
            },
          ];

          return projects.map((project) => (
            <div class="border border-zinc-600 rounded-lg p-3 shadow-lg bg-white">
              <div class="prose prose-zinc mb-2">
                <h2>{project.title}</h2>
              </div>
              <div class="flex flex-row flex-wrap gap-3">
                <img
                  class="w-64"
                  draggable="false"
                  src={project.img_src}
                  alt={`${project.name} logo`}
                />
                <div class="prose prose-zinc">{project.description}</div>
              </div>
            </div>
          ));
        })()}
      </div>
    </main>
  );
}
