package ru.aryukov.security.exception;

import lombok.Data;

@Data
public class AuthException extends RuntimeException {

    private Integer code;

    public AuthException(String message, Integer code) {
        super(message);
        this.code = code;
    }
}
