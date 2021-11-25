package ru.aryukov.security.serviceimpl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aryukov.security.exception.UnauthorizedException;
import ru.aryukov.security.model.jpa.Message;
import ru.aryukov.security.model.jpa.User;
import ru.aryukov.security.payload.MessageRequest;
import ru.aryukov.security.repository.MessageRepository;
import ru.aryukov.security.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class MessageManager {

    private final MessageRepository messageRepository;
    private final UserRepository userRepository;

    @Transactional
    public void saveMessage(MessageRequest messageRequest) {
        final User user = userRepository.findByName(messageRequest.getName()).orElseThrow(UnauthorizedException::new);
        messageRepository.save(new Message(user, messageRequest.getMessage()));
    }

    public Page<Message> getLastMessages(int count, String name) {
        final User user = userRepository.findByName(name).orElseThrow(UnauthorizedException::new);
        return messageRepository.findAllByUser(PageRequest.of(0, count, Sort.by("id").descending()), user);
    }
}
