import {createSignal} from 'solid-js'

export function NavBar() {
    const [navbarExpanded, setNavbarExpanded] = createSignal(false)

    return (<nav class="navbar is-dark" role="navigation" aria-label="main navigation">
        <div class="navbar-brand">
            <a class="navbar-item" href="/">A. Finn Hackett<sub>(he/they)</sub>, MMath</a>

            <a role="button" onClick={() => setNavbarExpanded(prev => !prev)} classList={{ 'is-active': navbarExpanded(), 'navbar-burger': true }} aria-label="menu" aria-expanded={navbarExpanded()}>
            <span aria-hidden="true"></span>
            <span aria-hidden="true"></span>
            <span aria-hidden="true"></span>
            </a>
        </div>
        <div class="navbar-menu" classList={{ 'is-active': navbarExpanded() }}>
            <div class="navbar-start">
            </div>

            <div class="navbar-end">
            <a class="navbar-item" href="/">Intro</a>
            <a class="navbar-item" href="/research_projects">Research Projects</a>
            <a class="navbar-item" href="/music_releases">Music Releases</a>
            </div>
        </div>
    </nav>)
}
