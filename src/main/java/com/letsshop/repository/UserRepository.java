package com.letsshop.repository;


import com.letsshop.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    Optional<User> findByUsername(String username);  // Find user by username
    Optional<User> findByEmail(String email);  // Find user by email
}
