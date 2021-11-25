package ru.aryukov.security.payload;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JwtAuthenticationResponse {
    private String accessToken;
    private String tokenType = "Bearer";
}