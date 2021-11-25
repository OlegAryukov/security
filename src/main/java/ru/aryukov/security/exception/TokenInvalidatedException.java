package ru.aryukov.security.exception;

import org.springframework.security.core.AuthenticationException;

public class TokenInvalidatedException extends AuthenticationException {

    public TokenInvalidatedException(String msg) {
        super(msg);
    }

}
