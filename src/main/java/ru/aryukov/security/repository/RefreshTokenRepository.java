package ru.aryukov.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.aryukov.security.model.jpa.RefreshToken;
import ru.aryukov.security.model.jpa.User;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

    @Modifying
    @Query(value = "update RefreshToken rt set rt.invalidated = true where rt.user = :user and invalidated = false")
    int invalidate(User user);

    RefreshToken findByUserNameAndToken(String userName, String token);

}
