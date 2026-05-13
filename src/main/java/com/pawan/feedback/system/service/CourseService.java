package com.pawan.feedback.system.service;

import com.pawan.feedback.system.dto.request.CreateCourseRequestDto;
import com.pawan.feedback.system.dto.response.CourseResponseDto;

import java.util.List;

public interface CourseService {

    CourseResponseDto createCourse(
            CreateCourseRequestDto request
    );

    List<CourseResponseDto> getAllCourses();

    CourseResponseDto getCourseById(Long courseId);

    void deleteCourse(Long courseId);
}