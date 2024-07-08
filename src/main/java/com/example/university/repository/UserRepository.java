package com.example.university.repository;

import com.example.university.entity.User;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.util.Optional;

public interface UserRepository extends JpaRepositoryImplementation<User, Long> {
    Optional<User> findByEmail(String email);
}
