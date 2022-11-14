import {createSignal, Switch, Match} from 'solid-js'

export function NavBar() {
    const items = [
        {
            name: 'Intro',
            href: '/',
        },
        {
            name: 'Research Projects',
            href: '/research_projects',
        },
        {
            name: 'Music Releases',
            href: '/music_releases',
        }
    ];

    const [navbarExpanded, setNavbarExpanded] = createSignal(false)

    return (<nav class="bg-zinc-700 text-white md:flex md:flex-row" role="navigation" aria-label="main navigation">
        <div class="flex flex-row align-items-center">
            <a class="text-2xl p-3" href="/">A. Finn Hackett<sub>(he/they)</sub>, MMath</a>

            <a role="button" class="md:hidden ml-auto hover:bg-zinc-900 w-14 p-3 text-center" onClick={() => setNavbarExpanded(prev => !prev)} aria-label="menu" aria-expanded={navbarExpanded()}>
                <Switch>
                    <Match when={navbarExpanded()}>
                        <span class="text-2xl">&#10005;</span>
                    </Match>
                    <Match when={!navbarExpanded()}>
                        <div class="space-y-2">
                            <span class="block w-8 h-1 bg-zinc-400"></span>
                            <span class="block w-8 h-1 bg-zinc-400"></span>
                            <span class="block w-8 h-1 bg-zinc-400"></span>
                        </div>
                    </Match>
                </Switch>
            </a>
        </div>
        <div class="border-t-2 border-zinc-600 md:border-none md:ml-auto text-lg flex md:flex flex-col md:flex-row" classList={{ 'hidden': !navbarExpanded() }}>
            {items.map(item => (
                <a class="hover:bg-zinc-900 p-3" href={item.href}>{item.name}</a>
            ))}
        </div>
    </nav>)
}
