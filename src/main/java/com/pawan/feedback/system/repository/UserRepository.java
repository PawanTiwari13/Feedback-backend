package com.pawan.feedback.system.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pawan.feedback.system.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional <User> findByEmail(String email);

    boolean existsByEmail(String email);

    List<User> findByActiveTrue();
}