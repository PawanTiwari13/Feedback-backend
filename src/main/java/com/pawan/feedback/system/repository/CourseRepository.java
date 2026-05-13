package com.pawan.feedback.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pawan.feedback.system.entity.Course;
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}