package ru.aryukov.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SigninDTO {

    private String username;
    @ToString.Exclude
    private String password;
}
