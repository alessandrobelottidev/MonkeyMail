<script>
	import Dashboard from './lib/pages/Dashboard.svelte';
    import Profile from './lib/pages/Profile.svelte';
	import SendEmail from './lib/pages/SendEmail.svelte';
	import Emails from './lib/pages/Emails.svelte';
	import Forms from './lib/pages/Forms.svelte';
	import Contacts from './lib/pages/Contacts.svelte';
	import Groups from './lib/pages/Groups.svelte';

    import { Router, Route } from "svelte-routing";
    import Sidebar from './lib/Sidebar.svelte';

    export let url = "";
</script>

<Router url="{url}">
    <div class="min-h-screen bg-gray-100 pl-20 pt-6">
        <Sidebar />
        <div class="content">
            <Route path="/groups" component="{Groups}" />
            <Route path="/forms" component="{Forms}" />
            <Route path="/contacts" component="{Contacts}" />
            <Route path="/emails" component="{Emails}" />
            <Route path="/send-email" component="{SendEmail}" />
            <Route path="/profile" component="{Profile}" />
            <Route path="/dashboard" component="{Dashboard}" />
            <Route path="/"><Dashboard /></Route>
        </div>
    </div>
</Router>