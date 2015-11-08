package com.example.controllers;

import com.example.controllers.exceptions.InvalidRegistrationDetailsException;
import com.example.models.Registration;
import com.example.services.RegistrationService;
import com.example.services.UserAccountService;
import com.example.services.dto.KeyValidationRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

/**
 * Creado por Victor Gil<baskeboler@gmail.com>, 07/11/15.
 */
@RestController
@RequestMapping("/api/registration")
public class RegistrationController {
    private static final Logger LOG = LoggerFactory.getLogger(RegistrationController.class);

    @Inject
    private RegistrationService registrationService;

    @Inject
    private UserAccountService userAccountService;


    @RequestMapping(path = "/validateKey", method = RequestMethod.POST)
    Registration validateKey(@RequestBody KeyValidationRequest req) {
        LOG.info("Validating registration info {}", req);
        return registrationService.validateKey(req);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    Registration getRegistrationInfo(@PathVariable("id") String id) {
        return registrationService.getRegistration(id)
                .orElseThrow(InvalidRegistrationDetailsException::new);
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
}
