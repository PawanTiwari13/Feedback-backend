package com.pawan.feedback.system.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pawan.feedback.system.entity.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

    List<Subject> findByCourseId(Long courseId);

    List<Subject> findByTeacherId(Long teacherId);
}