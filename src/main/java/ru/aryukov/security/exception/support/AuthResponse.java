package ru.aryukov.security.exception.support;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.aryukov.security.exception.Response;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class AuthResponse extends Response {

    private String errorDescription;

    public AuthResponse(String error, String errorDescription) {
        super(error);
        this.errorDescription = errorDescription;
    }

}