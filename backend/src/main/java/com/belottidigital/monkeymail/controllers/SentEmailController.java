package com.belottidigital.monkeymail.controllers;

import com.belottidigital.monkeymail.models.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

 class SentEmailGabibbo {
    private long groupId;
    private long emailTemplateId;
    private String sender;

    public SentEmailGabibbo(long gropuId, long emailTemplateId, String sender) {
        this.groupId = gropuId;
        this.emailTemplateId = emailTemplateId;
        this.sender = sender;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public long getEmailTemplateId() {
        return emailTemplateId;
    }

    public void setEmailTemplateId(long emailTemplateId) {
        this.emailTemplateId = emailTemplateId;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}

@RestController
public class SentEmailController {
    private final SentEmailRepository sentEmailRepository;
    private final GroupRepository groupRepository;

    private final EmailTemplateRepository emailTemplateRepository;

    public SentEmailController(SentEmailRepository sent_emailRepository, GroupRepository groupRepository, EmailTemplateRepository emailTemplateRepository) {
        this.sentEmailRepository = sent_emailRepository;
        this.groupRepository = groupRepository;
        this.emailTemplateRepository = emailTemplateRepository;
    }

    @GetMapping("/sentEmails/{groupId}")
    public List<SentEmail> getSentEmailsByGropuId(@PathVariable Long groupId) {
        return sentEmailRepository.findByGroup(
            groupRepository.findById(groupId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Group not found."))
        ).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No sent emails found."));
    }

    @GetMapping("/sentEmails/{emailTemplateId}")
    public List<SentEmail> getSentEmailsByEmailTemplateId(@PathVariable Long emailTemplateId) {
        return sentEmailRepository.findByEmailTemplate(
            emailTemplateRepository.findById(emailTemplateId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Email template not found."))
        ).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No sent emails found."));
    }

    @PostMapping("/sentEmails")
    public void newSentEmail(@RequestBody SentEmailGabibbo newSentEmail) {
        Group g = groupRepository.findById(newSentEmail.getGroupId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Group not found."));
        EmailTemplate e = emailTemplateRepository.findById(newSentEmail.getEmailTemplateId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Email template not found."));
        sentEmailRepository.save(new SentEmail(e, g, newSentEmail.getSender()));
    }
}
