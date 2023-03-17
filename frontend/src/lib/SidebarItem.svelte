<script>
    export let name = '';
    export let active = false;
</script>

<a href="#"class={'group flex items-center space-x-4 px-4 py-3 duration-300'.concat(" ", (active == name) ? 'text-white bg-primary' : 'text-gray-600 hover:text-gray-800 hover:bg-gray-200')}>
    <slot></slot>
</a>