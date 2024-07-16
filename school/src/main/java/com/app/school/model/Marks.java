package com.app.school.model;

import com.app.school.enums.ExamType;
import com.app.school.enums.Subject;
import jakarta.persistence.*;

@Entity
public class Marks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "studentId", nullable = false)
    private Student student;

    @Enumerated(EnumType.STRING)
    private Subject subject;
    private Double marks;
    private Double totalMarks;

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

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
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

    public ExamType getExamName() {
        return examName;
    }

    public void setExamName(ExamType examName) {
        this.examName = examName;
    }
}
