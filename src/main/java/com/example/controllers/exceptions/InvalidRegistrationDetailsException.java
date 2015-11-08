package com.example.controllers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Creado por Victor Gil<baskeboler@gmail.com>, 07/11/15.
 */
@ResponseStatus(code = HttpStatus.UNAUTHORIZED, reason = "Invalid key for specified email address")
public class InvalidRegistrationDetailsException extends RuntimeException{
}
