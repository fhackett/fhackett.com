import UnoCSS from 'unocss/vite'

export default {
  plugins: [
    UnoCSS(),
  ],
  build: {
    rollupOptions: {
      input: {
        index: 'index.html',
        research_projects: 'research_projects.html',
        music_releases: 'music_releases.html',
        404: '404.html',
      },
    },
  },
}
