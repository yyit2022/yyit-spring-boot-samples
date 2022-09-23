package com.yyit.errorhandlingsample.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.yyit.errorhandlingsample.appliation.user.UserId;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(UserId userId) {
        super("Could not find user with id " + userId);
    }
}
