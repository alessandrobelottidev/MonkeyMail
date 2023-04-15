<svelte:head>
    <title>MonkeyMail</title> 
</svelte:head>

<script>
    import Landing from './lib/pages/Landing.svelte';
	import Overview from './lib/pages/Overview.svelte';
    import Profile from './lib/pages/Profile.svelte';
	import SendEmail from './lib/pages/SendEmail.svelte';
	import Emails from './lib/pages/Emails.svelte';
	import Forms from './lib/pages/Forms.svelte';
	import Contacts from './lib/pages/Contacts.svelte';
	import Groups from './lib/pages/Groups.svelte';

    import Login from './lib/pages/Login.svelte';
    import Register from './lib/pages/Register.svelte';

    import Sidebar from './lib/Sidebar.svelte';

    import { loggedIn, accessToken, refreshToken } from './stores/auth';

    import { Router, Route } from 'yrv';

    $: console.log($loggedIn, $accessToken, $refreshToken);
</script>

<Router>
    <Route exact path="/">
        <Landing />
    </Route>

    <Route condition={() => !$loggedIn} redirect="/dashboard/overview" path="/login">
        <Login />
    </Route>

    <Route condition={() => !$loggedIn} redirect="/dashboard/overview" path="/register">
        <Register />
    </Route>

    <Router>
        <Route condition={() => $loggedIn} redirect="/login" path="/dashboard">
            <div class="min-h-screen bg-gray-100">
                <Sidebar />
                <div class="content pl-20 pt-6">
                    <Route path="/" exact redirect="/dashboard/overview" />
                    <Route path="/overview">
                        <Overview />
                    </Route>
                    <Route path="/profile">
                        <Profile />
                    </Route>
                    <Route path="/send-email">
                        <SendEmail />
                    </Route>
                    <Route path="/emails">
                        <Emails />
                    </Route>
                    <Route path="/forms">
                        <Forms />
                    </Route>
                    <Route path="/contacts">
                        <Contacts />
                    </Route>
                    <Route path="/groups">
                        <Groups />     
                    </Route>           
                </div>
            </div>
        </Route>
    </Router>

    <Route fallback>
        TODO: create a 404 page
    </Route>
</Router>