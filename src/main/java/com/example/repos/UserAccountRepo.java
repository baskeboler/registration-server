package com.example.repos;

import com.example.models.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Creado por Victor Gil<baskeboler@gmail.com>, 07/11/15.
 */
public interface UserAccountRepo extends JpaRepository<UserAccount, String> {

    Optional<UserAccount> findByEmail(String email);
    Optional<UserAccount> findById(String id);
}
