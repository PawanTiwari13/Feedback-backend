package com.pawan.feedback.system.dto.request;

import java.util.List;

public class CreateCourseRequestDto {

    private String courseName;

    private List<String> subjects;

    public CreateCourseRequestDto() {
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
