import tailwindcss from '@tailwindcss/vite'
import { globSync } from 'glob'

export default {
  plugins: [
    tailwindcss(),
  ],
  publicDir: "files",
  build: {
    rollupOptions: {
      input: Object.fromEntries(
        globSync('**/*.html').map(file => {
          return [
            file,
            file.slice(0, file.length - 5),
          ]
        }))
    },
  },
}
