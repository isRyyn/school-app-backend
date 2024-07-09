package com.app.school.model;

import com.app.school.enums.ExamType;
import jakarta.persistence.*;

@Entity
public class Marks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "studentId", nullable = false)
    private Student student;

    private String subject;
    private Double marks;
    private Double totalMarks;
    private int session;

    @Enumerated(EnumType.STRING)
    private ExamType examName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Double getMarks() {
        return marks;
    }

    public void setMarks(Double marks) {
        this.marks = marks;
    }

    public Double getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(Double totalMarks) {
        this.totalMarks = totalMarks;
    }

    public int getSession() {
        return session;
    }

    public void setSession(int year) {
        this.session = year;
    }

    public ExamType getExamName() {
        return examName;
    }

    public void setExamName(ExamType examName) {
        this.examName = examName;
    }
}
