import { defineConfig } from 'astro/config';
import solid from "@astrojs/solid-js";
import tailwind from "@astrojs/tailwind";

// https://astro.build/config
import mdx from "@astrojs/mdx";

// https://astro.build/config
export default defineConfig({
  integrations: [solid(), tailwind(), mdx()],
  outDir: './docs',
  site: 'https://fhackett.github.io'
});