package ru.aryukov.security.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.aryukov.security.payload.MessageRequest;
import ru.aryukov.security.repository.UserRepository;
import ru.aryukov.security.serviceimpl.CustomUserDetailsService;
import ru.aryukov.security.serviceimpl.JwtTokenProvider;
import ru.aryukov.security.serviceimpl.MessageManager;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/message")
@Slf4j
@RequiredArgsConstructor
public class MessageController {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final CustomUserDetailsService customUserDetailsService;
    private final JwtTokenProvider tokenProvider;
    private final MessageManager messageService;

    private final static String HISTORY_FLAG = "history";

    @PostMapping("/save")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody MessageRequest messageRequest) {
        if (messageRequest.getMessage().contains(HISTORY_FLAG)) {
            final String[] strings = messageRequest.getMessage().split("\\s+");
            if (strings.length == 2) {
                return ResponseEntity.ok(messageService.getLastMessages(Integer.parseInt(strings[1]), messageRequest.getName()));
            }
        }
        messageService.saveMessage(messageRequest);
        return null;
    }
}
