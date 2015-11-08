package com.example.controllers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Creado por Victor Gil<baskeboler@gmail.com>, 07/11/15.
 */
@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Email already registered")
public class EmailAlreadyExistsException extends RuntimeException {
}
