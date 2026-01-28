package com.pawan.feedback.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pawan.feedback.system.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}