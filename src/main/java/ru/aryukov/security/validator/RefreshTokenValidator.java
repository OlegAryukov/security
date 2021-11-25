package ru.aryukov.security.validator;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.aryukov.security.exception.UnauthorizedException;

import java.util.Map;

import static io.jsonwebtoken.Claims.ID;
import static io.jsonwebtoken.Claims.SUBJECT;

@Component
@Slf4j
@RequiredArgsConstructor
public class RefreshTokenValidator implements AuthValidator<Map<String, Object>> {

    @Override
    public void validate(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            throw new UnauthorizedException();
        }
        if (!map.containsKey(SUBJECT) || !map.containsKey(ID)) {
            throw new UnauthorizedException();
        }
    }

}
