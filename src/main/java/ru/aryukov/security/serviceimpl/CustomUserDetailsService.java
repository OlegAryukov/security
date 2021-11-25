package ru.aryukov.security.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aryukov.security.model.jpa.User;
import ru.aryukov.security.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String nameOrPassword)
            throws UsernameNotFoundException {
        // Let people login with either username or email
        User user = userRepository.findByNameOrPassword(nameOrPassword, nameOrPassword)
                .orElseThrow(() -> 
                        new UsernameNotFoundException("Пользователь с таким " + nameOrPassword + " логином или паролем не найден")
        );

        return UserPrincipal.builder()
                .id(user.getId())
                .username(user.getName())
                .password(user.getPassword())
                .build();
    }

    @Transactional
    public UserDetails loadUserById(Integer id) {
        User user = userRepository.findById(id).orElseThrow(
            () -> new UsernameNotFoundException("User not found with id : " + id)
        );

        return UserPrincipal.builder()
                .id(user.getId())
                .username(user.getName())
                .password(user.getPassword())
                .build();
    }
}