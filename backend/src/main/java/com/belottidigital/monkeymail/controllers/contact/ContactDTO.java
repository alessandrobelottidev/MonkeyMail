package com.belottidigital.monkeymail.controllers.contact;

import com.belottidigital.monkeymail.models.contact.Contact;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactDTO {
    private Long id;
    private String name;
    private String email;
    private String phone;
//    private Object customFields;

    public ContactDTO(Contact contact) {
        this.id = contact.getId();
        this.name = contact.getName();
        this.email = contact.getEmail();
        this.phone = contact.getPhone();
//        this.customFields = contact.getCustomFields();
    }

    public static List<ContactDTO> fromContactList(List<Contact> contacts) {
        List<ContactDTO> contactDTOList = new ArrayList<>();

        contacts.forEach(contact -> {
            contactDTOList.add(new ContactDTO(contact));
        });

        return contactDTOList;
    }

    @Override
    public String toString() {
        return "ContactDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
