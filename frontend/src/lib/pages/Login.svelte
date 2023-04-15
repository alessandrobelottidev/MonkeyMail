<svelte:head>
    <title>Login - MonkeyMail</title> 
</svelte:head>

<script>
  import axios from "axios";
  import { navigateTo } from "yrv"

  import Navbar from "../components/Navbar.svelte";

  import { accessToken, refreshToken } from "../../stores/auth";

  let username;
  let password;

  let error = '';

  const submitForm = async () => {
    const data = {
      username,
      password,
    }

    await axios.post("http://localhost:8080/auth/login", data)
			.then(res => {
				if (res.status === 200) {
					accessToken.set(res.data.access_token);
					refreshToken.set(res.data.refresh_token);
					navigateTo("/dashboard/overview");
				}
			})
			.catch(err => {
				error = err.response.data.message;
			})
  }
</script>

<Navbar />

<div class="bg-sand min-h-screen">
    <div class="h-screen w-full flex flex-col justify-center items-center content-center">
        <form on:submit|preventDefault={submitForm} class="bg-white px-8 pt-6 pb-8 mb-4 shadow-[-8px_8px_0px_0px] shadow-primary md:min-w-[420px]">
          <h1 class="text-2xl font-bold pb-4 text-center">Log In</h1>
          
          <div class="mb-4">
            <label class="block font-bold mb-2" for="username">Username</label>
            <input bind:value={username} class="border w-full py-2 px-3 text-gray-700 focus:outline-none" id="username" type="text" placeholder="Username" required>
          </div>

          <div class="mb-6">
            <label class="block font-bold mb-2" for="password">Password</label>
            <input bind:value={password} class="border w-full py-2 px-3 text-gray-700 mb-3 focus:outline-none" id="password" type="password" placeholder="Password" required>
          </div>

          <div class="flex items-center justify-between">
            <button class="bg-primary hover:bg-primaryDarker text-white font-bold py-2 px-4" type="submit">Log In</button>
            <a class="font-bold text-sm text-gray-800 hover:text-primary" href="#">Forgot Password?</a>
          </div>

          <div class="mt-4 border border-red-400 bg-red-100 p-2 {(error !== '') ? 'show' : 'hidden'}">
            <p>
              <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-6 h-6 text-red-400 pr-1 inline-block">
                <path stroke-linecap="round" stroke-linejoin="round" d="M12 9v3.75m-9.303 3.376c-.866 1.5.217 3.374 1.948 3.374h14.71c1.73 0 2.813-1.874 1.948-3.374L13.949 3.378c-.866-1.5-3.032-1.5-3.898 0L2.697 16.126zM12 15.75h.007v.008H12v-.008z" />
              </svg>Error: {error}
            </p>
          </div>
        </form>
        <p class="text-center text-gray-500 text-xs">© 2023 Copyright MonkeyMail</p>
    </div>
</div>