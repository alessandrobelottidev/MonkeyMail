package com.belottidigital.monkeymail.controllers;


import com.belottidigital.monkeymail.models.EmailTemplate;
import com.belottidigital.monkeymail.models.EmailTemplateRepository;
import com.belottidigital.monkeymail.models.User;
import com.belottidigital.monkeymail.models.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class EmailTemplateController {
    private final EmailTemplateRepository emailTemplateRepository;
    private final UserRepository userRepository;

    public EmailTemplateController(EmailTemplateRepository emailTemplateRepository, UserRepository userRepository) {
        this.emailTemplateRepository = emailTemplateRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/emailTemplates/{username}")
    List<EmailTemplate> getEmailTemplates(@PathVariable String username) {
        return emailTemplateRepository.findByUser(
                userRepository.findByUsername(username).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found."))
        ).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No EmailTemplates found."));
    }

    @GetMapping("/emailTemplates/{username}/{emailTemplateId}")
    EmailTemplate getEmailTemplate(@PathVariable String username, @PathVariable Long emailTemplateId) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found."));
        EmailTemplate emailTemplate = emailTemplateRepository.findById(emailTemplateId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "EmailTemplate not found."));

        if(emailTemplate.getUser() != user)
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "You are not authorized to access this resource.");

        return emailTemplate;
    }

    @PostMapping("/emailTemplates/{username}")
    void newEmailTemplate(@PathVariable String username, @RequestBody EmailTemplate newEmailTemplate) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found."));

        EmailTemplate emailTemplate = new EmailTemplate(newEmailTemplate, user);

        emailTemplateRepository.save(emailTemplate);
    }

    @DeleteMapping("/emailTemplates/{id}")
    void deleteEmailTemplate(@PathVariable Long id) {
        emailTemplateRepository.delete(emailTemplateRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "EmailTemplate not found.")));
    }

    @PutMapping("/emailTemplates/{id}")
    void updateEmailTemplate(@PathVariable Long id, @RequestBody EmailTemplate updatedEmailTemplate) {
        if (emailTemplateRepository.findById(id).isPresent()) {
            updatedEmailTemplate.setUser(emailTemplateRepository.findById(id).get().getUser());
            emailTemplateRepository.save(updatedEmailTemplate);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "EmailTemplate not found.");
        }
    }
}
