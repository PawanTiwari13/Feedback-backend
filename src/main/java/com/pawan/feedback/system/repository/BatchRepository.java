package com.pawan.feedback.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pawan.feedback.system.entity.Batch;

public interface BatchRepository extends JpaRepository<Batch, Long> {
}