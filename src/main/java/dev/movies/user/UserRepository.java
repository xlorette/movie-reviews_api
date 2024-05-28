package dev.movies.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByEmailAddress(String emailAddress);

    Optional<User> findUserByUsername(String username);
}
