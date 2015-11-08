package com.example.repos;

import com.example.models.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Creado por Victor Gil<baskeboler@gmail.com>, 07/11/15.
 */
public interface RegistrationRepo extends JpaRepository<Registration, String> {
    Optional<Registration> findById(String id);
    List<Registration> findByUserAccountId(String userAccountId);
    List<Registration> findByUserAccountEmail(String email);
}
