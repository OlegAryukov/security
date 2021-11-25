package ru.aryukov.security.payload;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageResponse {
    private String name;
    private String message;
}
