<script>
	import Profile from './pages/Profile.svelte';
	import SendEmail from './pages/SendEmail.svelte';
	import Emails from './pages/Emails.svelte';
	import Forms from './pages/Forms.svelte';
	import Contacts from './pages/Contacts.svelte';
	import Groups from './pages/Groups.svelte';

	import SidebarItem from './SidebarItem.svelte';
    import { Link } from 'svelte-routing';
    import logo from '../assets/logo.png';

    $: active = "dashboard";

    function handleActive(name) {
        active = name;
    }
</script>

<div class="sidebar min-h-screen w-[3.30rem] overflow-hidden border-r hover:w-56 bg-white hover:shadow-lg fixed left-0 top-0 duration-300">
    <div class="flex h-screen flex-col justify-between pt-2 pb-6">
        <div>
            <div class="w-max p-1">
                <img src={logo} class="h-11 w-max" alt="">
            </div>
            <ul class="mt-6 space-y-2 tracking-wide">
                <Link to="/dashboard">
                    <li class="min-w-max" on:click={() => handleActive("dashboard")}>
                        <SidebarItem active={active} name="dashboard">
                            <svg class="-ml-1 h-6 w-6" viewBox="0 0 24 24" fill="none">
                                <path d="M6 8a2 2 0 0 1 2-2h1a2 2 0 0 1 2 2v1a2 2 0 0 1-2 2H8a2 2 0 0 1-2-2V8ZM6 15a2 2 0 0 1 2-2h1a2 2 0 0 1 2 2v1a2 2 0 0 1-2 2H8a2 2 0 0 1-2-2v-1Z" class="fill-current text-cyan-400 dark:fill-slate-600"></path>
                                <path d="M13 8a2 2 0 0 1 2-2h1a2 2 0 0 1 2 2v1a2 2 0 0 1-2 2h-1a2 2 0 0 1-2-2V8Z" class="fill-current text-cyan-200 "></path>
                                <path d="M13 15a2 2 0 0 1 2-2h1a2 2 0 0 1 2 2v1a2 2 0 0 1-2 2h-1a2 2 0 0 1-2-2v-1Z" class="fill-current"></path>
                            </svg>
                            <span>Dashboard</span>
                        </SidebarItem>
                    </li>
                </Link>
                <Link to="/contacts">
                    <li class="min-w-max" on:click={() => handleActive("contacts")}>
                        <SidebarItem active={active} name="contacts">
                            <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5" viewBox="0 0 20 20" fill="currentColor">
                                <path class="fill-current text-gray-300 " fill-rule="evenodd" d="M2 6a2 2 0 012-2h4l2 2h4a2 2 0 012 2v1H8a3 3 0 00-3 3v1.5a1.5 1.5 0 01-3 0V6z" clip-rule="evenodd" />
                                <path class="fill-current text-gray-600 " d="M6 12a2 2 0 012-2h8a2 2 0 012 2v2a2 2 0 01-2 2H2h2a2 2 0 002-2v-2z" />
                            </svg>
                            <span>Contacts</span>
                        </SidebarItem>
                    </li>
                </Link>
                <Link to="/groups">
                    <li class="min-w-max" on:click={() => handleActive("groups")}>
                        <SidebarItem active={active} name="groups">
                            <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5" viewBox="0 0 20 20" fill="currentColor">
                            <path class="fill-current text-gray-600 " fill-rule="evenodd" d="M2 5a2 2 0 012-2h8a2 2 0 012 2v10a2 2 0 002 2H4a2 2 0 01-2-2V5zm3 1h6v4H5V6zm6 6H5v2h6v-2z" clip-rule="evenodd" />
                            <path class="fill-current text-gray-300 " d="M15 7h1a2 2 0 012 2v5.5a1.5 1.5 0 01-3 0V7z" />
                            </svg>
                            <span>Groups</span>
                        </SidebarItem>
                    </li>
                </Link>
                <Link to="/forms">
                    <li class="min-w-max"  on:click={() => handleActive("forms")}>
                        <SidebarItem active={active} name="forms">
                            <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5" viewBox="0 0 20 20" fill="currentColor">
                            <path class="fill-current text-gray-600 " d="M2 10a8 8 0 018-8v8h8a8 8 0 11-16 0z" />
                            <path class="fill-current text-gray-300 " d="M12 2.252A8.014 8.014 0 0117.748 8H12V2.252z" />
                            </svg>
                            <span>Forms</span>
                        </SidebarItem>
                    </li>
                </Link>
                <Link to="/emails">
                    <li class="min-w-max" on:click={() => handleActive("emails")}>
                        <SidebarItem active={active} name="emails">
                            <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5" viewBox="0 0 20 20" fill="currentColor">
                                <path class="fill-current text-gray-300 " d="M4 4a2 2 0 00-2 2v1h16V6a2 2 0 00-2-2H4z" />
                                <path class="fill-current text-gray-600 " fill-rule="evenodd" d="M18 9H2v5a2 2 0 002 2h12a2 2 0 002-2V9zM4 13a1 1 0 011-1h1a1 1 0 110 2H5a1 1 0 01-1-1zm5-1a1 1 0 100 2h1a1 1 0 100-2H9z" clip-rule="evenodd" />
                            </svg>
                            <span>Emails</span>
                        </SidebarItem>
                    </li>
                </Link>
                <Link to="/send-email">
                    <li class="min-w-max" on:click={() => handleActive("send-email")}>
                        <SidebarItem active={active} name="send-email">
                            <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5" viewBox="0 0 20 20" fill="currentColor">
                                <path class="fill-current text-gray-300 " d="M4 4a2 2 0 00-2 2v1h16V6a2 2 0 00-2-2H4z" />
                                <path class="fill-current text-gray-600 " fill-rule="evenodd" d="M18 9H2v5a2 2 0 002 2h12a2 2 0 002-2V9zM4 13a1 1 0 011-1h1a1 1 0 110 2H5a1 1 0 01-1-1zm5-1a1 1 0 100 2h1a1 1 0 100-2H9z" clip-rule="evenodd" />
                            </svg>
                            <span>Send email</span>
                        </SidebarItem>
                    </li>
                </Link>
            </ul>
        </div>
        <div class="min-w-max -mb-3">
            <Link to="/profile">
                <div on:click={() => handleActive("profile")}>
                    <SidebarItem active={active} name="profile">
                        <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-6 h-6">
                            <path  stroke-linecap="round" stroke-linejoin="round" d="M15.75 9V5.25A2.25 2.25 0 0013.5 3h-6a2.25 2.25 0 00-2.25 2.25v13.5A2.25 2.25 0 007.5 21h6a2.25 2.25 0 002.25-2.25V15M12 9l-3 3m0 0l3 3m-3-3h12.75" />
                        </svg>                      
                        <span>Profile</span>
                    </SidebarItem>
                </div>
            </Link>
            <SidebarItem active={active} name="logout">
                <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-6 h-6">
                    <path  stroke-linecap="round" stroke-linejoin="round" d="M15.75 9V5.25A2.25 2.25 0 0013.5 3h-6a2.25 2.25 0 00-2.25 2.25v13.5A2.25 2.25 0 007.5 21h6a2.25 2.25 0 002.25-2.25V15M12 9l-3 3m0 0l3 3m-3-3h12.75" />
                </svg>                      
                <span>Log out</span>
            </SidebarItem>
        </div>
    </div>
</div>