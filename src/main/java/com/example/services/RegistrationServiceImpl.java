package com.example.services;

import com.example.controllers.exceptions.InvalidRegistrationDetailsException;
import com.example.models.Product;
import com.example.models.Registration;
import com.example.models.UserAccount;
import com.example.repos.RegistrationRepo;
import com.example.services.dto.KeyValidationRequest;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Creado por Victor Gil<baskeboler@gmail.com>, 07/11/15.
 */
@Service
public class RegistrationServiceImpl implements RegistrationService {
    @Inject
    private RegistrationRepo registrationRepo;

    @Override
    public Optional<Registration> getRegistration(String id) {
        return registrationRepo.findById(id);
    }

    @Override
    public Registration createRegistration(Registration registration) {
        registration.setId(UUID.randomUUID().toString());
        registration.setKey(UUID.randomUUID().toString());
        registration.setTimestamp(Instant.now().toEpochMilli());

        return registrationRepo.save(registration);
    }

    @Override
    public Registration createRegistration(UserAccount userAccount, List<Product> products) {
        Registration r = new Registration();
        r.setAuthorizations(products);
        r.setUserAccount(userAccount);
        return createRegistration(r);
    }

    @Override
    public List<Registration> getRegistrationsForUserAccount(String userAccountId) {
        return registrationRepo.findByUserAccountId(userAccountId);
    }

    @Override
    public void deleteRegistration(String id) {
        registrationRepo.delete(id);
    }

    @Override
    public Registration validateKey(KeyValidationRequest k) {
        return registrationRepo
                .findByUserAccountEmail(k.getEmail())
                .stream()
                .filter(registration -> registration.getKey().equals(k.getKey()))
                .findAny().orElseThrow(InvalidRegistrationDetailsException::new);
    }

    public RegistrationRepo getRegistrationRepo() {
        return registrationRepo;
    }

    public void setRegistrationRepo(RegistrationRepo registrationRepo) {
        this.registrationRepo = registrationRepo;
    }
}
