package com.pawan.feedback.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pawan.feedback.system.entity.FeedbackResponse;

public interface FeedbackResponseRepository
        extends JpaRepository<FeedbackResponse, Long> {

    boolean existsByFormIdAndStudentId(Long formId, Long studentId);

    long countByFormId(Long formId);
}