package com.belottidigital.monkeymail.controllers;

import com.belottidigital.monkeymail.models.User;
import com.belottidigital.monkeymail.models.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class UserController {

    private final UserRepository userRepository;

    UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/users")
    User newUser(@RequestBody User newUser) {
        if (userRepository.findByUsername(newUser.getUsername()).isPresent())
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User already exists.");

        return userRepository.save(newUser);
    }

    @GetMapping("/users/{username}")
    User getUser(@PathVariable String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found."));
    }

    @PutMapping("/users/{username}")
    User updateUser(@RequestBody User newUser, @PathVariable String username) {
        return userRepository.findByUsername(username)
                .map(user -> {
                    user.setUsername((newUser.getUsername() != null) ? newUser.getUsername() : user.getUsername());
                    user.setPassword((newUser.getPassword() != null) ? newUser.getPassword() : user.getPassword());
                    user.setEmail((newUser.getEmail() != null) ? newUser.getEmail() : user.getEmail());
                    user.setFirstname((newUser.getFirstname() != null) ? newUser.getFirstname() : user.getFirstname());
                    user.setLastname((newUser.getLastname() != null) ? newUser.getLastname() : user.getLastname());
                    return userRepository.save(user);
                })
                .orElseGet(() -> {
                    newUser.setUsername(username);
                    return userRepository.save(newUser);
                });
    }

    @DeleteMapping("/users/{username}")
    void deleteUser(@PathVariable String username) {
        userRepository.delete(userRepository.findByUsername(username).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found.")));
    }

}
