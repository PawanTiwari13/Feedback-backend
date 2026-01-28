package com.pawan.feedback.system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pawan.feedback.system.entity.FeedbackQuestion;

public interface FeedbackQuestionRepository extends JpaRepository<FeedbackQuestion, Long> {

	List<FeedbackQuestion> findByFormId(Long formId);
}