<svelte:head>
    <title>MonkeyMail</title> 
</svelte:head>

<script>
	import Hero from './../components/Hero.svelte';
    import Navbar from "../components/Navbar.svelte";
    import CtaContainer from "../components/CtaContainer.svelte";
    import Footer from "../components/Footer.svelte";
    import Features from '../components/Features.svelte';
</script>

<Navbar />
<div class="pt-[56px]">
    <Hero />
    <Features />
    <CtaContainer />
</div>
<Footer />