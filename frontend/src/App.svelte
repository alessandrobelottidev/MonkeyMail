<svelte:head>
    <title>MonkeyMail</title> 
</svelte:head>

<script>
	import Overview from './lib/pages/Overview.svelte';
    import Profile from './lib/pages/Profile.svelte';
	import SendEmail from './lib/pages/SendEmail.svelte';
	import Emails from './lib/pages/Emails.svelte';
	import Forms from './lib/pages/Forms.svelte';
	import Contacts from './lib/pages/Contacts.svelte';
	import Groups from './lib/pages/Groups.svelte';

    import Sidebar from './lib/Sidebar.svelte';

    import { Router, Route } from 'yrv';
</script>

<Router>
    <Route exact path="/">Landing page</Route>

    <Router path="/dashboard" nofallback>
        <Route>
            <div class="min-h-screen bg-gray-100">
                <Sidebar />
                <div class="content pl-20 pt-6">
                    <Route exact path="/" redirect="/dashboard/overview" />
                    <Route exact path="/overview" component={Overview} />
                    <Route exact path="/profile" component={Profile} />
                    <Route exact path="/send-email" component={SendEmail} />
                    <Route exact path="/emails" component={Emails} />
                    <Route exact path="/forms" component={Forms} />
                    <Route exact path="/contacts" component={Contacts} />
                    <Route exact path="/groups" component={Groups} />                
                </div>
            </div>
        </Route>
    </Router>
</Router>