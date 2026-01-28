package com.pawan.feedback.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pawan.feedback.system.entity.FeedbackAnswer;

public interface FeedbackAnswerRepository
extends JpaRepository<FeedbackAnswer, Long> {
}