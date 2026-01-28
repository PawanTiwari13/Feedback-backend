package com.pawan.feedback.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pawan.feedback.system.entity.BatchStudent;

public interface BatchStudentRepository
extends JpaRepository<BatchStudent, Long> {

boolean existsByBatchIdAndStudentId(Long batchId, Long studentId);

long countByBatchId(Long batchId);
}