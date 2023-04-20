package com.belottidigital.monkeymail.models.token;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Integer> {

    @Query(value = """
      select t from Token t inner join User u\s
      on t.user.username = u.id\s
      where u.username = :username and (t.expired = false or t.revoked = false)\s
      """)
    List<Token> findAllValidTokenByUsername(String username);

    Optional<Token> findByToken(String token);
}