package ru.aryukov.security.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResponseDescription {

    UNAUTHORIZED("UNAUTHORIZED", 403);

    private String errorCode;
    private Integer responseCode;

}
