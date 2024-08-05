export default function MusicReleases() {
  return (
    <main
      class="p-3 bg-cover"
      style={`background-image: url("/gfx/fish bg 2.jpg");`}
    >
      <div class="prose prose-zinc mx-auto text-center prose-headings:mb-3 mb-4">
        <h1>Music Releases</h1>
        <p>
          I produce experimental electronic music, which I post on{" "}
          <a href="https://soundcloud.com/finnhackett">SoundCloud</a>, as well
          as other music sites via a distributor. Not guaranteed to be easy
          listening, but I hope it's entertaining.
        </p>
      </div>

      <div class="mt-4 gap-4 flex flex-row flex-wrap justify-center">
        {(() => {
          interface MusicRelease {
            name: string;
            href: string;
            img: string;
          }

          const releases: MusicRelease[] = [
            {
              name: "no clicks at all; there it is again",
              href: "https://soundcloud.com/finnhackett/sets/no-clicks-at-all-there-it-is",
              img: "/album-covers/lake with green and grey conifers.png",
            },
            {
              name: "brain slice",
              href: "https://soundcloud.com/finnhackett/sets/brain-slice",
              img: "/album-covers/brain slice.png",
            },
            {
              name: "kinda strictly sorta maybe?",
              href: "https://soundcloud.com/finnhackett/sets/kinda-strictly-sorta-maybe",
              img: "/album-covers/kinda strictly sorta maybe cover.png",
            },
            {
              name: "athena's playground",
              href: "https://soundcloud.com/finnhackett/sets/athenas-playground",
              img: "/album-covers/athena's playground cover.jpg",
            },
            {
              name: "the mountain underground",
              href: "https://soundcloud.com/finnhackett/sets/the-mountain-underground",
              img: "/album-covers/the mountain underground cover.png",
            },
            {
              name: "living elements",
              href: "https://soundcloud.com/finnhackett/sets/living-elements",
              img: "/album-covers/living elements cover.jpg",
            },
            {
              name: "water, in bloom",
              href: "https://soundcloud.com/finnhackett/sets/water-in-bloom",
              img: "/album-covers/water in bloom cover.jpg",
            },
            {
              name: "retransmit",
              href: "https://soundcloud.com/finnhackett/sets/retransmit",
              img: "/album-covers/retransmit cover.png",
            },
            {
              name: "I saw skulls",
              href: "https://soundcloud.com/finnhackett/sets/i-saw-skulls",
              img: "/album-covers/I saw skulls cover.jpg",
            },
            {
              name: "pixellated beach",
              href: "https://soundcloud.com/finnhackett/sets/pixellated-beach",
              img: "/album-covers/pixellated beach cover.png",
            },
            {
              name: "plastick",
              href: "https://soundcloud.com/finnhackett/sets/plastick",
              img: "/album-covers/plastick cover.png",
            },
            {
              name: "alien adventure",
              href: "https://soundcloud.com/finnhackett/sets/alien-adventure",
              img: "/album-covers/alien adventure cover.jpg",
            },
            {
              name: "morning greyshadow",
              href: "https://soundcloud.com/finnhackett/sets/morning-greyshadow",
              img: "",
            },
            {
              name: "sky in the fish (version)",
              href: "https://soundcloud.com/finnhackett/sets/sky-in-the-fish-version",
              img: "/album-covers/sky in the fish (version) cover.png",
            },
            {
              name: "numbers",
              href: "https://soundcloud.com/finnhackett/sets/numbers-1",
              img: "/album-covers/retransmit cover.png",
            },
            {
              name: "generator",
              href: "https://soundcloud.com/finnhackett/sets/ocularis-1",
              img: "/album-covers/generator cover.png",
            },
          ];

          return releases.map((release) => (
            <div class="border rounded-lg border-zinc-600 w-fit p-3 shadow-lg hover:bg-zinc-100 bg-white">
              <a
                role="button"
                href={release.href}
                class="grid grid-cols-1 h-full"
              >
                <h2 class="underline font-mono text-lg mb-2 w-64">
                  {release.name}
                </h2>
                <img
                  class="w-64 mx-auto self-end"
                  src={release.img}
                  alt={`${release.name} album cover`}
                />
              </a>
            </div>
          ));
        })()}
      </div>
    </main>
  );
}
