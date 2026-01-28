package com.pawan.feedback.system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pawan.feedback.system.entity.FeedbackForm;

public interface FeedbackFormRepository
extends JpaRepository<FeedbackForm, Long> {

List<FeedbackForm> findByBatchIdAndStatus(Long batchId, String status);
}
