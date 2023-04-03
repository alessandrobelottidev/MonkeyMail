package com.belottidigital.monkeymail.models;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ContactRepository extends JpaRepository<Contact, String> {
    public Optional<List<Contact>> findByUserId(User user);
}
