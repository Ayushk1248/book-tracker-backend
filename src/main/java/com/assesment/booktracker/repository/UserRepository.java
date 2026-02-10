package com.assesment.booktracker.repository;

import com.assesment.booktracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // This automagically creates a SQL query to find a user by their username
    Optional<User> findByUsername(String username);
}