package com.pawan.feedback.system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pawan.feedback.system.entity.BatchStudent;

public interface BatchStudentRepository extends JpaRepository<BatchStudent, Long> {

	boolean existsByBatchIdAndStudentId(Long batchId, Long studentId);

	List<BatchStudent> findByBatchId(Long batchId);
}