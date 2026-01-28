package com.pawan.feedback.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pawan.feedback.system.entity.CourseBatch;

public interface CourseBatchRepository
extends JpaRepository<CourseBatch, Long> {

boolean existsByCourseIdAndBatchId(Long courseId, Long batchId);
}