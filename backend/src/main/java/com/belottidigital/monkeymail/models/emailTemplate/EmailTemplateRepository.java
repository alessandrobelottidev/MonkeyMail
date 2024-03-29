package com.belottidigital.monkeymail.models.emailTemplate;

import com.belottidigital.monkeymail.models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmailTemplateRepository extends JpaRepository<EmailTemplate, String> {
    Optional<EmailTemplate> findById(Long id);

    Optional<List<EmailTemplate>> findByUser(User user);
}