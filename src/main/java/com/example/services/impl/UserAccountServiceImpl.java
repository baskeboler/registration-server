package com.example.services.impl;

import com.example.controllers.exceptions.EmailAlreadyExistsException;
import com.example.controllers.exceptions.UserNotFoundException;
import com.example.models.UserAccount;
import com.example.repos.UserAccountRepo;
import com.example.services.UserAccountService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Creado por Victor Gil<baskeboler@gmail.com>, 07/11/15.
 */
@Service
public class UserAccountServiceImpl implements UserAccountService {
    @Inject
    private UserAccountRepo userAccountRepo;

    @Override
    public UserAccount createUser(UserAccount userAccount) {
        if (userAccountRepo.findByEmail(userAccount.getEmail()).isPresent())
            throw new EmailAlreadyExistsException();
        UUID uuid = UUID.randomUUID();
        userAccount.setId(uuid.toString());
        return userAccountRepo.save(userAccount);
    }

    @Override
    public Optional<UserAccount> findUserByEmail(String email) {
        return userAccountRepo.findByEmail(email);
    }

    @Override
    public Optional<UserAccount> findUserById(String id) {
        return userAccountRepo.findById(id);
    }

    @Override
    public List<UserAccount> getAllAccounts() {
        return userAccountRepo.findAll();
    }

    @Override
    public void deleteUserAccount(String id) {
        if (!userAccountRepo.exists(id))
            throw new UserNotFoundException();
        userAccountRepo.delete(id);
    }

    public UserAccountRepo getUserAccountRepo() {
        return userAccountRepo;
    }

    public void setUserAccountRepo(UserAccountRepo userAccountRepo) {
        this.userAccountRepo = userAccountRepo;
    }
}
