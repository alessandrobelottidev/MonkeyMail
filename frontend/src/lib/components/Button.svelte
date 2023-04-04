<script>
    import { Link } from "yrv";

    export let url = "#";
    export let type = "primary";
</script>

<Link class="text-{(type === 'primary') ? 'white' : 'black'} bg-{(type === 'primary') ? type : 'secondary'} font-bold hover:bg-{(type === 'primary') ? type : 'secondary'}Darker px-6 py-2 text-center hover:duration-300" href={url}><slot></slot></Link>