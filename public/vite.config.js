import tailwindcss from '@tailwindcss/vite'

export default {
  plugins: [
    tailwindcss(),
  ],
  publicDir: "files",
  build: {
    rollupOptions: {
      input: {
        index: 'index.html',
        music_releases: 'music_releases.html',
        404: '404.html',
      },
    },
  },
}
