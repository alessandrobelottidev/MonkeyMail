<script>
  import { Link } from "yrv";
  import Logo from "../../assets/logo.png"

  let showMenu = false;

  function toggleNavbar() {
    showMenu = !showMenu;
  }
</script>

<div class="bg-white fixed top-0 left-0 w-full z-50">
  <div class="shadow-sm">
    <nav class="container px-6 py-2 mx-auto md:flex md:justify-between md:items-center">
      <div class="flex items-center justify-between">
        <Link class="text-xl font-bold text-gray-800 md:text-2xl hover:text-primary" href="/">
          <img src={Logo} alt="Logo" class="h-10">
        </Link>
        <!-- Mobile menu button -->
        <button
          on:click={toggleNavbar}
          class="flex md:hidden text-gray-800 hover:text-gray-400 focus:outline-none focus:text-gray-400"
        >
            <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-6 h-6">
            <path stroke-linecap="round" stroke-linejoin="round" d="M3.75 6.75h16.5M3.75 12h16.5m-16.5 5.25h16.5" />
          </svg>
        </button>
      </div>

      <!-- Mobile Menu open: "block", Menu closed: "hidden" -->
      <div class="flex-col mt-8 space-y-4 md:flex md:space-y-0 md:flex-row md:items-center md:space-x-10 md:mt-0 {showMenu ? 'flex': 'hidden'}">
        <Link class="text-gray-800 hover:text-primary text-center" href="/">Home</Link>
        <Link class="text-gray-800 hover:text-primary text-center" href="/">Features</Link>
        <Link class="text-gray-800 hover:text-primary text-center" href="/login">Login</Link>
        <Link class="text-white bg-primary font-bold hover:bg-primaryDarker px-6 py-2 text-center" href="/register">Sign Up</Link>
      </div>
    </nav>
  </div>
</div>
