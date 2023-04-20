package com.belottidigital.monkeymail.models.group;

import com.belottidigital.monkeymail.models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GroupRepository extends JpaRepository<Group, String> {
    public Optional<Group> findById(Long id);
    public Optional<List<Group>> findByUser(User user);
}
