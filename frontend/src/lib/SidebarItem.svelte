<script>
    export let name = '';
    export let active = '';
</script>

<div class={'min-w-max group flex items-center space-x-4 px-4 py-3 duration-300'.concat(" ", (active == name) ? 'text-white bg-primary fill-gray-600' : 'fill-white text-gray-600 hover:text-gray-800 hover:bg-gray-200')}>
    <slot></slot>
</div>