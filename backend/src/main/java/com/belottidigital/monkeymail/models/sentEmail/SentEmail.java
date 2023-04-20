package com.belottidigital.monkeymail.models.sentEmail;


import com.belottidigital.monkeymail.models.emailTemplate.EmailTemplate;
import com.belottidigital.monkeymail.models.group.Group;
import jakarta.persistence.*;

@Entity
@Table(name = "sent_emails")
public class SentEmail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group group;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "email_template_id")
    private EmailTemplate emailTemplate;

    @Column(name = "sender", nullable = false)
    private String sender;

    public SentEmail() {}

    public SentEmail(EmailTemplate emailTemplate, Group group, String sender) {
        this.group = group;
        this.emailTemplate = emailTemplate;
        this.sender = sender;
    }

    public SentEmail(SentEmail newSentEmail) {
        this.group = newSentEmail.getGroup();
        this.emailTemplate = newSentEmail.getEmailTemplate();
        this.sender = newSentEmail.getSender();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EmailTemplate getEmailTemplate() {
        return emailTemplate;
    }

    public void setEmailTemplate(EmailTemplate emailTemplateId) {
        this.emailTemplate = emailTemplateId;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group groupId) {
        this.group = groupId;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    @Override
    public String toString() {
        return "SentEmail{" +
                "id=" + id +
                ", emailTemplate=" + emailTemplate +
                ", group=" + group +
                ", sender='" + sender + '\'' +
                '}';
    }
}
