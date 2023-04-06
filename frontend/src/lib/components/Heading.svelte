<script>
  import MonkeyWorking from "../../assets/monkey-working.png"
  import MonkeyBoss from "../../assets/monkey-boss.png"
</script>

<div class="bg-sand py-16 xl:flex-row xl:space-x-4 xl:space-y-0">
  <h2 class="text-3xl font-bold text-center mb-8">Heading</h2>

  <div class="container mx-auto">
    
    <div class="flex">
      <div class="flex-1 bg-primary text-white">
        <div class="p-6 flex flex-col justify-center items-start h-full">
          <h3 class="text-2xl font-bold pb-4">Lorem ipsum</h3>
          <p class="pb-4 mb-4">
            Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. 
            Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
          </p>
          <button
            type="button"
            class=" border px-4 py-2 border-white font-bold"
            data-te-ripple-init
            data-te-ripple-color="light">
            Sign up!
          </button>
        </div>
      </div>
      <div class="flex-1">
        <img src={MonkeyWorking} alt="MonkeyWorking" class="w-full h-full object-fill">
      </div>
    </div>
  
    <div class="flex">
      <div class="flex-1">
        <img src={MonkeyBoss} alt="MonkeyBoss" class="w-full h-full object-fill">
      </div>
      <div class="flex-1 bg-white text-black">
        <div class="p-6 flex flex-col justify-center items-start h-full">
          <h3 class="text-2xl font-bold pb-4">Lorem ipsum</h3>
          <p class="pb-4 mb-4">
            Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. 
            Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
          </p>
          <button
            type="button"
            class=" border px-4 py-2 border-black font-bold"
            data-te-ripple-init
            data-te-ripple-color="light">
            Sign up!
          </button>
        </div>
      </div>
    </div>
  </div>
</div>