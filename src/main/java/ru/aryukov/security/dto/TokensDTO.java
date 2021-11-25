package ru.aryukov.security.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class TokensDTO {

    private final String access;
    private final String refresh;

}
