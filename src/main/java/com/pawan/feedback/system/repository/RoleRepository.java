package com.pawan.feedback.system.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pawan.feedback.system.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(String name);
}