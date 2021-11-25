package ru.aryukov.security.exception;

import lombok.Data;

@Data
public class BaseException extends RuntimeException {

    private Integer code;
    private String description;

    public BaseException() {
    }

    public BaseException(Integer code) {
        this.code = code;
    }

    public BaseException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public BaseException(String message, String description) {
        super(message);
        this.description = description;
    }

    public BaseException(String message, Integer code, String description) {
        super(message);
        this.code = code;
        this.description = description;
    }


    public BaseException(String message, String description, Throwable cause) {
        super(message, cause);
        this.description = description;
    }

    public BaseException(String message, Integer code, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public BaseException(String message, Integer code, String description, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.description = description;
    }

}
