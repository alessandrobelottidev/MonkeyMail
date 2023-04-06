package com.belottidigital.monkeymail.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "email_templates")
public class EmailTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "subject")
    private String subject = "";

    @Column(name = "body")
    private String body = "";

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public EmailTemplate() {}

    public EmailTemplate(String name, String subject, String body) {
        this.name = name;
        this.subject = subject;
        this.body = body;
    }

    public EmailTemplate(EmailTemplate emailTemplate) {
        this.name = emailTemplate.getName();
        this.subject = emailTemplate.getSubject();
        this.body = emailTemplate.getBody();
    }

    public EmailTemplate(String name, String body) {
        this.name = name;
        this.body = body;
    }

    public EmailTemplate(Long id, String body) {
        this.id = id;
        this.body = body;
    }

    public EmailTemplate(EmailTemplate newEmailTemplate, User user) {
        this.name = newEmailTemplate.getName();
        this.subject = newEmailTemplate.getSubject();
        this.body = newEmailTemplate.getBody();
        this.user = user;
    }

    //Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "EmailTemplate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}