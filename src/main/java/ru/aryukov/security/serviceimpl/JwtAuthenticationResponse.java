package ru.aryukov.security.serviceimpl;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JwtAuthenticationResponse {
    private String accessToken;
}
