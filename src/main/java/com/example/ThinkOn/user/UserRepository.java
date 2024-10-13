package com.example.ThinkOn.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository //data access
// the jpaRepo contains all the methods
public interface UserRepository extends JpaRepository<User, Long> {
    // we do not want to register a user if their email had already been registered
    Optional<User> findUserByEmail(String email);
}
