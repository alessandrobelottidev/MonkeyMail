package com.belottidigital.monkeymail.controllers.contact;

import com.belottidigital.monkeymail.models.contact.Contact;
import com.belottidigital.monkeymail.models.contact.ContactRepository;
import com.belottidigital.monkeymail.models.user.User;
import com.belottidigital.monkeymail.models.user.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class ContactController {
    private final ContactRepository contactRepository;
    private final UserRepository userRepository;

    public ContactController(ContactRepository contactRepository, UserRepository userRepository) {
        this.contactRepository = contactRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/contacts/{username}")
    List<ContactDTO> getContacts(@PathVariable String username) {
        return ContactDTO.fromContactList(contactRepository.findByUser(
                userRepository.findByUsername(username).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found."))
        ).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No contacts found.")));
    }

    @GetMapping("/contacts/{username}/{contactId}")
    Contact getContact(@PathVariable String username, @PathVariable String contactId) {
        return contactRepository.findById(contactId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact not found."));
    }

    @PostMapping("/contacts/{username}")
    Contact newContact(@PathVariable String username, @RequestBody ContactDTO newContact) {
        if (userRepository.findByUsername(username).isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found.");

        System.out.println("CONTACT BEING PASSED: " + newContact.toString());

        // Convert custom fields to JSON
//        String customFieldsJson = null;
//        try {
//            customFieldsJson = objectMapper.writeValueAsString(null);
//        } catch (JsonProcessingException e) {
//            // Handle JSON serialization exception
//            throw new RuntimeException("Error converting custom fields to JSON", e);
//        }

        User user = userRepository.findByUsername(username).get();
        Contact contact = new Contact(newContact.getName(), newContact.getEmail(), newContact.getPhone(), user);

        return contactRepository.save(contact);
    }

    @PutMapping("/contacts/{username}/{contactId}")
    Contact updateContact(@PathVariable String username, @PathVariable String contactId, @RequestBody Contact newContact) {
        if (userRepository.findByUsername(username).isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found.");

        return contactRepository.findById(contactId)
                .map(contact -> {
//                    contact.setCustomFields((newContact.getCustomFields() != null) ? newContact.getCustomFields() : contact.getCustomFields());
                    contact.setName((newContact.getName() != null) ? newContact.getName() : contact.getName());
                    contact.setEmail((newContact.getEmail() != null) ? newContact.getEmail() : contact.getEmail());
                    contact.setPhone((newContact.getPhone() != null) ? newContact.getPhone() : contact.getPhone());
                    return contactRepository.save(contact);
                })
                .orElseGet(() -> {
                    newContact.setId(Long.valueOf(contactId));
                    return contactRepository.save(newContact);
                });
    }

    @DeleteMapping("/contacts/{username}/{contactId}")
    void deleteContact(@PathVariable String username, @PathVariable String contactId) {
        contactRepository.delete(contactRepository.findById(contactId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact not found.")));
    }
}
