<script>
    import bookmark from '../../assets/bookmark.svg';
    import featuresBg from '../../assets/features-bg.png';
</script>

<div class="flex flex-col bg-white container mx-auto py-16 px-6">
    
    <h1 class="mb-8 text-center font-bold text-3xl">Features</h1>

    <div class="grid place-content-center md:grid-cols-3 gap-6">
        <div class="bg-sand pt-8 pb-6 px-6 flex flex-col">
            <div class="pb-4 flex flex-row items-center">
                <div class="ml-2">
                    <div class="bg-primary rotate-45 h-8 w-8 mr-2">
                        <div class="-rotate-45 h-8 w-8 flex items-center content-center">
                            <img class="h-5 mx-auto" src={bookmark} alt="bookmark">
                        </div>
                    </div>
                </div>
                <div class="text-2xl font-bold px-4">Features</div>
            </div>
            <p class="text-lg py-2">Lorem ipsum dolor sit amet. Est corrupti blanditiis eos eligendi fuga aut magnam reiciendis qui minima dicta ut fugit quia sed debitis delectus.</p>
        </div>
        
        <div class="bg-primary pt-8 pb-6 px-6 flex flex-col">
            <div class="pb-4 flex flex-row items-center">
                <div class="ml-2">
                    <div class="bg-sand rotate-45 h-8 w-8 mr-2">
                        <div class="-rotate-45 h-8 w-8 flex items-center content-center">
                            <img class="h-5 mx-auto" src={bookmark} alt="bookmark">
                        </div>
                    </div>
                </div>
                <div class="text-2xl font-bold px-4 text-white">Features</div>
            </div>
            <p class="text-lg py-2 text-white">Lorem ipsum dolor sit amet. Est corrupti blanditiis eos eligendi fuga aut magnam reiciendis qui minima dicta ut fugit quia sed debitis delectus.</p>
        </div>

        <div class="bg-sand pt-8 pb-6 px-6 flex flex-col">
            <div class="pb-4 flex flex-row items-center">
                <div class="ml-2">
                    <div class="bg-primary rotate-45 h-8 w-8 mr-2">
                        <div class="-rotate-45 h-8 w-8 flex items-center content-center">
                            <img class="h-5 mx-auto" src={bookmark} alt="bookmark">
                        </div>
                    </div>
                </div>
                <div class="text-2xl font-bold px-4">Features</div>
            </div>
            <p class="text-lg py-2">Lorem ipsum dolor sit amet. Est corrupti blanditiis eos eligendi fuga aut magnam reiciendis qui minima dicta ut fugit quia sed debitis delectus.</p>
        </div>
	</div>

    <div class="pt-6 pb-4 max-sm:hidden">
        <img class="object-cover w-screen" src={featuresBg} alt="">
    </div>
</div>