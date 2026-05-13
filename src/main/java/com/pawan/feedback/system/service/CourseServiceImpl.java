package com.pawan.feedback.system.service;

import com.pawan.feedback.system.dto.request.CreateCourseRequestDto;
import com.pawan.feedback.system.dto.response.CourseResponseDto;

import com.pawan.feedback.system.entity.Course;
import com.pawan.feedback.system.entity.Subject;

import com.pawan.feedback.system.repository.CourseRepository;
import com.pawan.feedback.system.repository.SubjectRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public CourseResponseDto createCourse(
            CreateCourseRequestDto request
    ) {

        Course course = new Course();

        course.setCourseName(request.getCourseName());

        Course savedCourse =
                courseRepository.save(course);

        List<Subject> subjectList = request.getSubjects()

                .stream()

                .map(subjectName -> {

                    Subject subject = new Subject();

                    subject.setSubjectName(subjectName);

                    subject.setCourse(savedCourse);

                    return subjectRepository.save(subject);
                })

                .toList();

        List<String> subjectNames = subjectList

                .stream()

                .map(Subject::getSubjectName)

                .toList();

        return new CourseResponseDto(
                savedCourse.getId(),
                savedCourse.getCourseName(),
                subjectNames
        );
    }

    @Override
    public List<CourseResponseDto> getAllCourses() {

        return courseRepository.findAll()

                .stream()

                .map(course -> new CourseResponseDto(

                        course.getId(),

                        course.getCourseName(),

                        course.getSubjects()

                                .stream()

                                .map(Subject::getSubjectName)

                                .collect(Collectors.toList())
                ))

                .toList();
    }

    @Override
    public CourseResponseDto getCourseById(Long courseId) {

        Course course = courseRepository.findById(courseId)

                .orElseThrow(() ->
                        new RuntimeException("Course not found")
                );

        List<String> subjects = course.getSubjects()

                .stream()

                .map(Subject::getSubjectName)

                .toList();

        return new CourseResponseDto(
                course.getId(),
                course.getCourseName(),
                subjects
        );
    }

    @Override
    public void deleteCourse(Long courseId) {

        courseRepository.deleteById(courseId);
    }
}