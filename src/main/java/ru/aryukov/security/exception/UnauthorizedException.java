package ru.aryukov.security.exception;

public class UnauthorizedException extends BaseException {
    public UnauthorizedException() {
        super(ResponseDescription.UNAUTHORIZED.getErrorCode(), ResponseDescription.UNAUTHORIZED.getResponseCode());
    }

    public UnauthorizedException(String description, Throwable cause) {
        super(
                ResponseDescription.UNAUTHORIZED.getErrorCode(),
                ResponseDescription.UNAUTHORIZED.getResponseCode(),
                description,
                cause
        );
    }
}
