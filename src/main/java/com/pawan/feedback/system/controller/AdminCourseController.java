package com.pawan.feedback.system.controller;


import com.pawan.feedback.system.dto.request.CreateCourseRequestDto;
import com.pawan.feedback.system.dto.response.CourseResponseDto;

import com.pawan.feedback.system.service.CourseService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/courses")
public class AdminCourseController {

    @Autowired
    private CourseService courseService;

    // CREATE COURSE
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<CourseResponseDto> createCourse(
            @RequestBody CreateCourseRequestDto request
    ) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        courseService.createCourse(request)
                );
    }

    // GET ALL COURSES
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<CourseResponseDto>>
    getAllCourses() {

        return ResponseEntity.ok(
                courseService.getAllCourses()
        );
    }

    // GET COURSE BY ID
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{courseId}")
    public ResponseEntity<CourseResponseDto>
    getCourseById(
            @PathVariable Long courseId
    ) {

        return ResponseEntity.ok(
                courseService.getCourseById(courseId)
        );
    }

    // DELETE COURSE
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{courseId}")
    public ResponseEntity<String> deleteCourse(
            @PathVariable Long courseId
    ) {

        courseService.deleteCourse(courseId);

        return ResponseEntity.ok(
                "Course Deleted Successfully"
        );
    }
}