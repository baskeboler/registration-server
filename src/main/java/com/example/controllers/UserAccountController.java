package com.example.controllers;

import com.example.controllers.exceptions.ProductNotFoundException;
import com.example.controllers.exceptions.UserNotFoundException;
import com.example.models.Product;
import com.example.models.Registration;
import com.example.models.UserAccount;
import com.example.services.ProductService;
import com.example.services.RegistrationService;
import com.example.services.UserAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Creado por Victor Gil<baskeboler@gmail.com>, 07/11/15.
 */
@RestController
@RequestMapping(
        consumes = "application/json",
        produces = "application/json",
        path = "/api/user-accounts")
public class UserAccountController {

    private static final Logger LOG = LoggerFactory.getLogger(UserAccountController.class);

    @Inject
    private UserAccountService userAccountService;

    @Inject
    private RegistrationService registrationService;

    @Inject
    private ProductService productService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    UserAccount createUserAccount(@RequestBody UserAccount userAccount) {
        LOG.info("Creating user account {}", userAccount);
        return userAccountService.createUser(userAccount);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    UserAccount getUser(@PathVariable("id") String id) {
        LOG.info("Getting user id {}", id);
        return userAccountService.findUserById(id).orElseThrow(UserNotFoundException::new);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE, consumes = {})
    void delete(@PathVariable("id") String id) {
        userAccountService.deleteUserAccount(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    List<UserAccount> getAll() {
        LOG.info("Getting all user accounts");
        return userAccountService.getAllAccounts();
    }

    @RequestMapping(path = "/{accountId}/registration", method = RequestMethod.POST)
    Registration createRegistration(
            @RequestBody Long[] productIds,
            @PathVariable("accountId") String accountId) {
        LOG.info("Creating registration for account {} and products {}", accountId, productIds);
        List<Long> productIdList = Arrays.asList(productIds);
        UserAccount userAccount = userAccountService.findUserById(accountId).orElseThrow(UserNotFoundException::new);
        List<Product> prodList;
        Stream<Product> prodStream = productIdList.stream()
                .map(id -> productService.getProduct(id)
                        .<ProductNotFoundException>orElseThrow(ProductNotFoundException::new));
        prodList = prodStream.collect(Collectors.toList());
        return registrationService.createRegistration(userAccount, prodList);
    }

    public UserAccountService getUserAccountService() {
        return userAccountService;
    }

    public void setUserAccountService(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    public RegistrationService getRegistrationService() {
        return registrationService;
    }

    public void setRegistrationService(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    public ProductService getProductService() {
        return productService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
}
