package com.pawan.feedback.system.dto.response;


import java.util.List;

public class CourseResponseDto {

    private Long id;

    private String courseName;

    private List<String> subjects;

    public CourseResponseDto() {
    }

    public CourseResponseDto(
            Long id,
            String courseName,
            List<String> subjects
    ) {
        this.id = id;
        this.courseName = courseName;
        this.subjects = subjects;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }
}