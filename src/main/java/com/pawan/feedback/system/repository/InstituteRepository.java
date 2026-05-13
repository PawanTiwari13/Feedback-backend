package com.pawan.feedback.system.repository;


import com.pawan.feedback.system.entity.Institute;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InstituteRepository
        extends JpaRepository<Institute, Long> {

    boolean existsByInstituteCode(
            String instituteCode
    );

    Optional<Institute> findByInstituteCode(
            String instituteCode
    );
}