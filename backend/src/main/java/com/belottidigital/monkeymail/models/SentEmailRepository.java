package com.belottidigital.monkeymail.models;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SentEmailRepository extends JpaRepository<SentEmail, String> {
    public Optional<SentEmail> findById(Long id);
    public Optional<List<SentEmail>> findByEmailTemplate(EmailTemplate emailTemplate);
    public Optional<List<SentEmail>> findByGroup(Group group);
}
