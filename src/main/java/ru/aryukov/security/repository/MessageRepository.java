package ru.aryukov.security.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.aryukov.security.model.jpa.Message;
import ru.aryukov.security.model.jpa.User;


public interface MessageRepository extends JpaRepository<Message, Integer> {

//    @Query("SELECT m FROM Message m ORDER BY m.id DESC " + "fetch first  :count where m.user = :user")
    Page<Message> findAllByUser(Pageable pageable, User user);

}
