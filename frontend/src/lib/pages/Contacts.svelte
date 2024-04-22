<svelte:head>
    <title>Contacts - MonkeyMail</title> 
</svelte:head>

<script>
    import { onMount } from "svelte";
    import { accessToken, username } from "../../stores/auth";
    import { contacts } from "../../stores/data";
    
    import axios from "axios";
    
    import Table from "../components/Table.svelte";
    import { Modal, Button, Label, Input, Textarea } from "flowbite-svelte";

    const headers = [
        'id',
        'name',
        'email',
        'phone',
        // 'custom fields',
    ]
    
    // Fetch contacts on mount and store them in the contacts store using axios
    onMount(async () => {
        // if contacts is not an empty object, return
        if (Object.keys($contacts).length !== 0) {
            console.log('There are contacts in the store')
            return;
        }
        
        const { data } = await axios.get(`http://localhost:8080/contacts/${$username}`, {
            headers: {
                Authorization: `Bearer ${$accessToken}`,
                'Access-Control-Allow-Origin': '*',
            },
        });

        if (data.length === 0)
            return; // TODO: handle error in UI

        contacts.set(data);
        console.log('Contacts: ', $contacts);
    });

    // Form logic
    let formModal = false;

    let name = '';
    let email = '';
    let phone = '';
    // let custom_fields = '';

    const addContact = async () => {
        let custom_fields_json = {};

        try {
            // custom_fields_json = await JSON.parse(custom_fields);
            // console.log(custom_fields_json);

            const { data } = await axios.post(`http://localhost:8080/contacts/${$username}`, {
                name,
                email,
                phone,
                // custom_fields: custom_fields_json,
            }, {
                headers: {
                    Authorization: `Bearer ${$accessToken}`,
                    'Access-Control-Allow-Origin': '*',
                },
            });

            if (data.length === 0)
                return; // TODO: handle error in UI

            console.log('Contact added: ', data);
        } catch (error) {
            console.log('Error parsing custom fields JSON: ', error);
            // TODO: handle error in UI
        }
    }
</script>

<div class="flex flex-row justify-between mb-4 items-center">
    <h1 class="text-2xl font-bold">Contacts</h1>
    <button on:click={() => formModal = true} class="p-1 border-2 text-sm border-primary text-primary bg-white font-bold hover:bg-primaryDarker hover:text-white hover:border-primaryDarker px-2 p-0 text-center hover:duration-300">Add New</button>
</div>

<Table headers={headers} content={$contacts} />

<Modal bind:open={formModal} size="xs" autoclose={false} class="w-full rounded-none">
    <form class="flex flex-col" on:submit|preventDefault={addContact}>
        <h3 class="mb-4 text-xl font-medium text-gray-900 dark:text-white">Add new contact</h3>
        
        <Label>
            <p class="mb-1">Name</p>
            <Input bind:value={name} type="text" defaultClass="rounded-none w-full" name="email" placeholder="John Doe" required />
        </Label>
        
        <Label class="mt-4">
            <p class="mb-1">Email</p>
            <Input bind:value={email} type="email" defaultClass="rounded-none w-full" name="email" placeholder="name@company.com" />
        </Label>

        <Label class="my-4">
            <p class="mb-1">Phone</p>
            <Input bind:value={phone} type="tel" defaultClass="rounded-none w-full" name="phone" placeholder="+39 1234567890" />
        </Label>

        <!-- <Label class="my-4">
            <p class="mb-1">Custom fields (JSON format)</p>
            <Textarea bind:value={custom_fields} class="rounded-none w-full bg-gray-200" name="custom_fields" placeholder={'{ "fieldName" : "fieldValue", }'} />
        </Label> -->

        <Button type="submit" class="w-full" btnClass="bg-primary py-2 text-white hover:bg-primaryDarker duration-300 font-semibold">Add new contact</Button>
    </form>
</Modal>