package com.app.school.model;

import com.app.school.enums.Month;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Fee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Double total;
    private Double deposited;

    private Double monthly;
    private Double registration;
    private Double course;
    private Double copies;
    private Double dress;
    private Double shoes;
    private Double tieBelt;
    private Double socks;
    private Double van;
    private Double diary;

    @Enumerated(EnumType.STRING)
    private Month month;

    private LocalDateTime date;

    private Long studentId;
    private Long standardId;
    private Long sessionId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getDeposited() {
        return deposited;
    }

    public void setDeposited(Double deposited) {
        this.deposited = deposited;
    }

    public Double getMonthly() {
        return monthly;
    }

    public void setMonthly(Double monthly) {
        this.monthly = monthly;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getRegistration() {
        return registration;
    }

    public void setRegistration(Double registration) {
        this.registration = registration;
    }

    public Double getCourse() {
        return course;
    }

    public void setCourse(Double course) {
        this.course = course;
    }

    public Double getCopies() {
        return copies;
    }

    public void setCopies(Double copies) {
        this.copies = copies;
    }

    public Double getDress() {
        return dress;
    }

    public void setDress(Double dress) {
        this.dress = dress;
    }

    public Double getShoes() {
        return shoes;
    }

    public void setShoes(Double shoes) {
        this.shoes = shoes;
    }

    public Double getTieBelt() {
        return tieBelt;
    }

    public void setTieBelt(Double tieBelt) {
        this.tieBelt = tieBelt;
    }

    public Double getSocks() {
        return socks;
    }

    public void setSocks(Double socks) {
        this.socks = socks;
    }

    public Double getVan() {
        return van;
    }

    public void setVan(Double van) {
        this.van = van;
    }

    public Double getDiary() {
        return diary;
    }

    public void setDiary(Double diary) {
        this.diary = diary;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getStandardId() {
        return standardId;
    }

    public void setStandardId(Long standardId) {
        this.standardId = standardId;
    }

    public Long getSessionId() {
        return sessionId;
    }

    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }
}
