package ru.aryukov.security.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.aryukov.security.exception.BaseException;
import ru.aryukov.security.exception.Response;
import ru.aryukov.security.exception.ResponseDescription;
import ru.aryukov.security.exception.support.AuthResponse;

import javax.servlet.http.HttpServletRequest;
import java.nio.file.AccessDeniedException;

@Slf4j
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE + 1)
public class AuthExceptionHandler {


//    @ExceptionHandler(BadCredentialsException.class)
//    public ResponseEntity<Response> handleBadCredentialsException(BadCredentialsException e) {
//        log.error("Введены некорректные логин или пароль для аутентификации {}", e.getMessage());
//        Response response = new Response(ResponseDescription.INVALID_CREDENTIALS.getErrorCode());
//        return new ResponseEntity<>(response, HttpStatus.valueOf(ResponseDescription.INVALID_CREDENTIALS.getResponseCode()));
//    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<Response> handleAccessDeniedException(AccessDeniedException e) {
        log.error(e.getMessage(), e);
        Response response = new Response(ResponseDescription.UNAUTHORIZED.getErrorCode());
        return new ResponseEntity<>(response, HttpStatus.valueOf(ResponseDescription.UNAUTHORIZED.getResponseCode()));
    }

//    @ExceptionHandler(ExpiredJwtException.class)
//    public ResponseEntity<Response> handleExpiredJwtException(ExpiredJwtException e) {
//        log.error("У токена истекло время жизни {}", e.getMessage());
//        log.trace(e.getMessage(), e);
//        Response response = new Response(ResponseDescription.UNAUTHORIZED.getErrorCode());
//        return new ResponseEntity<>(response, HttpStatus.valueOf(ResponseDescription.UNAUTHORIZED.getResponseCode()));
//    }
//
//    @ExceptionHandler(AuthenticationException.class)
//    public ResponseEntity<Response> handleAuthenticationException(AuthenticationException e) {
//        log.error(e.getMessage());
//        Response response = new Response(ResponseDescription.UNAUTHORIZED.getErrorCode());
//        return new ResponseEntity<>(response, HttpStatus.valueOf(ResponseDescription.UNAUTHORIZED.getResponseCode()));
//    }
//
//    @ExceptionHandler(AuthUserNotFoundException.class)
//    public ResponseEntity<Response> handleSignatureException(AuthUserNotFoundException e) {
//        log.error(e.getMessage());
//        Response response = new Response(e.getMessage());
//        return new ResponseEntity<>(response, HttpStatus.valueOf(e.getCode()));
//    }


//    @ExceptionHandler(TokenInvalidatedException.class)
//    public ResponseEntity<Response> handleSignatureException(TokenInvalidatedException e) {
//        log.error(e.getMessage());
//        Response response = new Response(ResponseDescription.UNAUTHORIZED.getErrorCode());
//        return new ResponseEntity<>(response, HttpStatus.valueOf(ResponseDescription.UNAUTHORIZED.getResponseCode()));
//    }
//
//
//
    @ExceptionHandler(BaseException.class)
    public ResponseEntity<Response> handleBaseException(BaseException e, HttpServletRequest request) {
        String description = e.getDescription() == null ? "Нет описания" : e.getDescription();
        log.error(
                "Запрос к {}. Ошибка {} | {} | {}",
                request.getRequestURI(), e.getClass().getSimpleName(), e.getMessage(), description
        );
        log.debug(e.getMessage(), e);
        AuthResponse response = new AuthResponse(e.getMessage(), e.getDescription());
        return new ResponseEntity<>(response, HttpStatus.valueOf(e.getCode()));
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response> handleException(Exception e, HttpServletRequest request) {
        log.error(
                "Непредвиденная ошибка: {} {} uri: {}",
                e.getClass().getSimpleName(), e.getMessage(), request.getRequestURI()
        );
        log.error(e.getMessage(), e);
        Response response = new Response(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
