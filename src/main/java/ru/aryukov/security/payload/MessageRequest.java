package ru.aryukov.security.payload;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class MessageRequest {
    @NotBlank
    private String name;

    @NotBlank
    private String message;
}
