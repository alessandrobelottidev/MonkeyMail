import { writable } from 'svelte/store'

// This is wher the user's JWT token is stored
export const loggedIn = writable(false)

export const accessToken = writable('')
accessToken.subscribe((value) => {
	if (value) {
		loggedIn.set(true)
	} else {
		loggedIn.set(false)
	}
})

export const refreshToken = writable('')
