<template>
    <div class="section">
        <div class="content has-text-centered">
            <h2>Research Projects</h2>
        </div>
    </div>
    <div class="columns is-multiline is-centered is-variable is-8">
        <ResearchProject>
            <template #image>
                <img src="assets/pgo-logo.jpg" alt="PGo logo" />
            </template>
            <h3>
                PGo (<a href="https://github.com/UBC-NSS/pgo">on Github</a>)
            </h3>
            <p>
                A <em>distributed systems compiler</em>, aiming to provide compilation from abstract model-checkable specifications in PlusCal into Go code that can run on a real network.
                The project includes networking support libraries, and Modular Pluscal, a modular superset of PlusCal.
            </p>
        </ResearchProject>
        <ResearchProject>
            <template #image>
                <img src="assets/treegen_logo.png" alt="TreeGen logo" />
            </template>
            <h3>TreeGen (<a href="http://hdl.handle.net/10012/16133">MMath Thesis</a>)</h3>
            <p>
                My MMath thesis work.
                Designed to make Interface Definition Language implementation easier, it's an impure functional language with fully out-of-order processing, making order-of-operations bugs, even involving pointers, impossible.
            </p>
        </ResearchProject>
        <ResearchProject>
            <h3>mel (<a href="https://doi.org/10.1145/3365438.3410964">MODELS 2020</a>)</h3>
            <p>
                <em>mel</em> is a declarative, rule-based Model Extraction Language for extracting facts from XML-structured models of software.
                This is a collaboration with <a href="https://watform.uwaterloo.ca/">WatForm</a>, centered around Rob Hackman's thesis under <a href="https://cs.uwaterloo.ca/~jmatlee/">Jo Atlee</a>.
                I primarily contributed evaluation work, comparing <em>mel</em> with&nbsp;<a href="https://www.w3.org/TR/xquery/">XQuery</a>, an established web standard with related properties.
            </p>
        </ResearchProject>
    </div>
</template>