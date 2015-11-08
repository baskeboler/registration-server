package com.example.services;

import com.example.models.Product;
import com.example.models.Registration;
import com.example.models.UserAccount;
import com.example.services.dto.KeyValidationRequest;

import java.util.List;
import java.util.Optional;

/**
 * Creado por Victor Gil<baskeboler@gmail.com>, 07/11/15.
 */
public interface RegistrationService {
    Optional<Registration> getRegistration(String id);
    Registration createRegistration(Registration registration);
    Registration createRegistration(UserAccount userAccount, List<Product> products);
    List<Registration> getRegistrationsForUserAccount(String userAccountId);
    void deleteRegistration(String id);
    Registration validateKey(KeyValidationRequest keyValidationRequest);
}
