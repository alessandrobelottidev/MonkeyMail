/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ['./src/**/*.{html,js,svelte,ts}'],
  theme: {
    extend: {
      colors: {
        primary: '#32AFEC',
        primaryDarker: '#1597D7',
      },
    }
  },
  plugins: []
};