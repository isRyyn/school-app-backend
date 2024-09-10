package com.app.school.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class TransferCertificateRegisterClass {

    private String className;
    private String dateOfAdmission;
    private String dateOfPromotion;
    private String dateOfRemoval;
    private String causeOfRemoval;
    private String conduct;
    private String year;
    private String work;
    private String sign;

    // Getters and Setters
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getDateOfAdmission() {
        return dateOfAdmission;
    }

    public void setDateOfAdmission(String dateOfAdmission) {
        this.dateOfAdmission = dateOfAdmission;
    }

    public String getDateOfPromotion() {
        return dateOfPromotion;
    }

    public void setDateOfPromotion(String dateOfPromotion) {
        this.dateOfPromotion = dateOfPromotion;
    }

    public String getDateOfRemoval() {
        return dateOfRemoval;
    }

    public void setDateOfRemoval(String dateOfRemoval) {
        this.dateOfRemoval = dateOfRemoval;
    }

    public String getCauseOfRemoval() {
        return causeOfRemoval;
    }

    public void setCauseOfRemoval(String causeOfRemoval) {
        this.causeOfRemoval = causeOfRemoval;
    }

    public String getConduct() {
        return conduct;
    }

    public void setConduct(String conduct) {
        this.conduct = conduct;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
