package ru.aryukov.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.aryukov.security.model.jpa.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByName(String name);
    Optional<User> findByNameOrPassword(String name, String password);

    List<User> findByIdIn(List<Integer> userIds);

    Boolean existsByName(String username);

}
