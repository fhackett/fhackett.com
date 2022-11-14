module.exports = {
	content: ['./src/**/*.{astro,html,js,jsx,svelte,ts,tsx,vue,mdx}'],
	theme: {
		extend: {},
	},
	plugins: [
		require('@tailwindcss/typography'),
	],
}
