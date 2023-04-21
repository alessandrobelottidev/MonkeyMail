<script>
    import { Table, TableBody, TableBodyCell, TableBodyRow, TableHead, TableHeadCell } from 'flowbite-svelte';

    export let headers = [];

    export let content = [];

    $: console.log('Content ', content);
  </script>


{#if content.length === 0}
    <div class="text-center text-gray-500 h-48 w-full bg-white border flex items-center justify-center text-lg">No data yet...</div>
{:else}
    <div class="overflow-x-auto overflow-y-auto max-h-screen" style="height: calc(100vh - 96px)">
        <Table divClass="border" striped hoverable>
            <TableHead theadClass="bg-primary text-white uppercase">
                {#each headers as header}
                    <TableHeadCell >{header}</TableHeadCell>
                {/each}
                <TableHeadCell>Actions</TableHeadCell>
            </TableHead>
            <TableBody>
                {#each content as data}
                    <TableBodyRow>
                        {#each Object.entries(data) as [field, fieldValue]}
                            {#if field !== 'customFields'}
                                <TableBodyCell>{fieldValue}</TableBodyCell>
                            {:else}
                                <TableBodyCell>
                                    {#if field.length === 0}
                                        -
                                    {:else}
                                        <div class="gap-2">
                                            {#each Object.entries(fieldValue) as [key, value]}
                                                <span class="font-bold pr-2 w-max inline-block">{key}:</span>
                                                <span class="w-max inline-block">{value}</span>
                                                <hr class="mb-2 mt-2">
                                            {/each}
                                        </div>
                                    {/if}
                                </TableBodyCell>
                            {/if}
                        {/each}
                        <TableBodyCell tdClass="w-[44px] px-6 py-4">
                            <div class="flex gap-2 justify-center">
                                <p color="text-primary">
                                    <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-5 h-5">
                                        <path stroke-linecap="round" stroke-linejoin="round" d="M16.862 4.487l1.687-1.688a1.875 1.875 0 112.652 2.652L6.832 19.82a4.5 4.5 0 01-1.897 1.13l-2.685.8.8-2.685a4.5 4.5 0 011.13-1.897L16.863 4.487zm0 0L19.5 7.125" />
                                    </svg>                              
                                </p>
                                <p color="text-red-600">
                                    <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-5 h-5">
                                        <path stroke-linecap="round" stroke-linejoin="round" d="M14.74 9l-.346 9m-4.788 0L9.26 9m9.968-3.21c.342.052.682.107 1.022.166m-1.022-.165L18.16 19.673a2.25 2.25 0 01-2.244 2.077H8.084a2.25 2.25 0 01-2.244-2.077L4.772 5.79m14.456 0a48.108 48.108 0 00-3.478-.397m-12 .562c.34-.059.68-.114 1.022-.165m0 0a48.11 48.11 0 013.478-.397m7.5 0v-.916c0-1.18-.91-2.164-2.09-2.201a51.964 51.964 0 00-3.32 0c-1.18.037-2.09 1.022-2.09 2.201v.916m7.5 0a48.667 48.667 0 00-7.5 0" />
                                    </svg>                              
                                </p>
                            </div>
                        </TableBodyCell>
                    </TableBodyRow>
                {/each}
            </TableBody>
        </Table>
    </div>
{/if}