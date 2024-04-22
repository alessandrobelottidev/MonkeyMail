package com.belottidigital.monkeymail.models.contact;

import com.belottidigital.monkeymail.models.user.User;
import jakarta.persistence.*;

@Entity
@Table(name = "contacts")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String name;

    private String phone;

//    @Column(columnDefinition = "jsonb")
//    private String customFields;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Contact() {}

    // TODO: Implement custom_fields
    public Contact(String email, String name, String phone, User user) {
        this.email = email;
        this.name = name;
        this.phone = phone;
//        this.customFields = null;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

//    public String getCustomFields() {
//        return customFields;
//    }
//
//    public void setCustomFields(String customFields) {
//        this.customFields = customFields;
//    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
