package com.belottidigital.monkeymail.controllers;

import com.belottidigital.monkeymail.models.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class GroupController {
    private final GroupRepository groupRepository;

    private final UserRepository userRepository;

    public GroupController(GroupRepository groupRepository, UserRepository userRepository) {
        this.groupRepository = groupRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/groups/{username}")
    List<Group> getGroups(@PathVariable String username) {
        return groupRepository.findByUser(
                userRepository.findByUsername(username).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found."))
        ).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No groups found."));
    }

    @GetMapping("/groups/{username}/{groupId}")
    Group getGroup(@PathVariable String username, @PathVariable String groupId) {
        return groupRepository.findById(groupId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Group not found."));
    }

    @GetMapping("/groups/{username}/{groupId}/contacts")
    List<Contact> getGroupContacts(@PathVariable String username, @PathVariable String groupId) {
        return groupRepository.findById(groupId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Group not found.")).getContacts();
    }

    @PostMapping("/groups/{username}")
    void newGroup(@PathVariable String username, @RequestBody Group newGroup) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found."));

        Group group = new Group(newGroup, user);

        groupRepository.save(group);
    }

    @DeleteMapping("/groups/{username}/{groupId}")
    void deleteGroup(@PathVariable String username, @PathVariable String groupId) {
        groupRepository.delete(groupRepository.findById(groupId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Group not found.")));
    }
}
