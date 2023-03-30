package com.belottidigital.monkeymail.models;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, String> {
    List<User> findAll();

    User findByUsername(String username);
}
