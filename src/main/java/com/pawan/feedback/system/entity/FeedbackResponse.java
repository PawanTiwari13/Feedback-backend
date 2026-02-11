package com.pawan.feedback.system.entity;


import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(
        name = "feedback_responses",
        uniqueConstraints = @UniqueConstraint(columnNames = {"form_id", "student_id"})
)
public class FeedbackResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "form_id", nullable = false)
    private FeedbackForm form;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private User student;

    private Instant submittedAt;

    public FeedbackResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FeedbackForm getForm() {
        return form;
    }

    public void setForm(FeedbackForm form) {
        this.form = form;
    }

    public User getStudent() {
        return student;
    }

    public void setStudent(User student) {
        this.student = student;
    }

    public Instant getSubmittedAt() {
        return submittedAt;
    }

    public void setSubmittedAt(Instant submittedAt) {
        this.submittedAt = submittedAt;
    }
}
