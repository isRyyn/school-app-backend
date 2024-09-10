package com.app.school.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TransferCertificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentId;

    private String number;
    private String district;
    private String name;
    private String aadhar;
    private String dob;
    private String ageYears;
    private String ageMonths;
    private String mother;
    private String father;
    private String religion;
    private String place;
    private String tehsil;
    private String studentDistrict;
    private String livingInStateSince;
    private String dateOfAdmission;
    private String numberOfEntryRegister;
    private String lastDateOfSchool;
    private String dateOfLeaving;

    private String reason;
    private String conduct;
    private String lastClassPassed;
    private String dateOfPassing;
    private String lastClassAttended;
    private String language;

    private String freeOfCost;
    private String freeOfCostClass;
    private String daysSchoolOpened;
    private String daysAttended;
    private String absentDays;
    private String fatherBusiness;

    private String day;
    private String month;
    private String year;
    private String principal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAadhar() {
        return aadhar;
    }

    public void setAadhar(String aadhar) {
        this.aadhar = aadhar;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAgeYears() {
        return ageYears;
    }

    public void setAgeYears(String ageYears) {
        this.ageYears = ageYears;
    }

    public String getAgeMonths() {
        return ageMonths;
    }

    public void setAgeMonths(String ageMonths) {
        this.ageMonths = ageMonths;
    }

    public String getMother() {
        return mother;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getTehsil() {
        return tehsil;
    }

    public void setTehsil(String tehsil) {
        this.tehsil = tehsil;
    }

    public String getStudentDistrict() {
        return studentDistrict;
    }

    public void setStudentDistrict(String studentDistrict) {
        this.studentDistrict = studentDistrict;
    }

    public String getLivingInStateSince() {
        return livingInStateSince;
    }

    public void setLivingInStateSince(String livingInStateSince) {
        this.livingInStateSince = livingInStateSince;
    }

    public String getDateOfAdmission() {
        return dateOfAdmission;
    }

    public void setDateOfAdmission(String dateOfAdmission) {
        this.dateOfAdmission = dateOfAdmission;
    }

    public String getNumberOfEntryRegister() {
        return numberOfEntryRegister;
    }

    public void setNumberOfEntryRegister(String numberOfEntryRegister) {
        this.numberOfEntryRegister = numberOfEntryRegister;
    }

    public String getLastDateOfSchool() {
        return lastDateOfSchool;
    }

    public void setLastDateOfSchool(String lastDateOfSchool) {
        this.lastDateOfSchool = lastDateOfSchool;
    }

    public String getDateOfLeaving() {
        return dateOfLeaving;
    }

    public void setDateOfLeaving(String dateOfLeaving) {
        this.dateOfLeaving = dateOfLeaving;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getConduct() {
        return conduct;
    }

    public void setConduct(String conduct) {
        this.conduct = conduct;
    }

    public String getLastClassPassed() {
        return lastClassPassed;
    }

    public void setLastClassPassed(String lastClassPassed) {
        this.lastClassPassed = lastClassPassed;
    }

    public String getDateOfPassing() {
        return dateOfPassing;
    }

    public void setDateOfPassing(String dateOfPassing) {
        this.dateOfPassing = dateOfPassing;
    }

    public String getLastClassAttended() {
        return lastClassAttended;
    }

    public void setLastClassAttended(String lastClassAttended) {
        this.lastClassAttended = lastClassAttended;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getFreeOfCost() {
        return freeOfCost;
    }

    public void setFreeOfCost(String freeOfCost) {
        this.freeOfCost = freeOfCost;
    }

    public String getFreeOfCostClass() {
        return freeOfCostClass;
    }

    public void setFreeOfCostClass(String freeOfCostClass) {
        this.freeOfCostClass = freeOfCostClass;
    }

    public String getDaysSchoolOpened() {
        return daysSchoolOpened;
    }

    public void setDaysSchoolOpened(String daysSchoolOpened) {
        this.daysSchoolOpened = daysSchoolOpened;
    }

    public String getDaysAttended() {
        return daysAttended;
    }

    public void setDaysAttended(String daysAttended) {
        this.daysAttended = daysAttended;
    }

    public String getAbsentDays() {
        return absentDays;
    }

    public void setAbsentDays(String absentDays) {
        this.absentDays = absentDays;
    }

    public String getFatherBusiness() {
        return fatherBusiness;
    }

    public void setFatherBusiness(String fatherBusiness) {
        this.fatherBusiness = fatherBusiness;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }
}
