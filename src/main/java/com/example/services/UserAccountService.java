package com.example.services;

import com.example.models.UserAccount;

import java.util.List;
import java.util.Optional;

/**
 * Creado por Victor Gil<baskeboler@gmail.com>, 07/11/15.
 */
public interface UserAccountService {
    UserAccount createUser(UserAccount userAccount);
    Optional<UserAccount> findUserByEmail(String email);
    Optional<UserAccount> findUserById(String id);
    List<UserAccount> getAllAccounts();

    void deleteUserAccount(String id);
}
