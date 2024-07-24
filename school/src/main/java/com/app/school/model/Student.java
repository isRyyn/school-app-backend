package com.app.school.model;

import com.app.school.enums.Gender;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    private String middleName;
    private String lastName;
    private LocalDate dob;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String previousSchool;
    private String session;
    private Double totalFees;


    private Integer rollNo;

    @Lob
    private byte[] picture;
    private String uDiasCode;


    // Contact details
    private String email;
    private Integer mobile;
    private String address;
    private String city;
    private String state;
    private Integer pincode;


    // Transportation details
    private String vehicleName;
    private String vehicleNumber;
    private String vehicleRoute;

    // Utility Details
    private Boolean uniform;
    private Boolean course;

    private Long standardId;

    @ElementCollection
    private Set<Long> subjectIds = new HashSet<>();

    @ElementCollection
    private Set<Long> marksIds = new HashSet<>();

    @ElementCollection
    private Set<Long> parentsIds = new HashSet<>();

    @ElementCollection
    private Set<Long> feeIds = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPreviousSchool() {
        return previousSchool;
    }

    public void setPreviousSchool(String previousSchool) {
        this.previousSchool = previousSchool;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public Double getTotalFees() {
        return totalFees;
    }

    public void setTotalFees(Double totalFees) {
        this.totalFees = totalFees;
    }

    public Integer getRollNo() {
        return rollNo;
    }

    public void setRollNo(Integer rollNo) {
        this.rollNo = rollNo;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public String getuDiasCode() {
        return uDiasCode;
    }

    public void setuDiasCode(String uDiasCode) {
        this.uDiasCode = uDiasCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getMobile() {
        return mobile;
    }

    public void setMobile(Integer mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getPincode() {
        return pincode;
    }

    public void setPincode(Integer pincode) {
        this.pincode = pincode;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleRoute() {
        return vehicleRoute;
    }

    public void setVehicleRoute(String vehicleRoute) {
        this.vehicleRoute = vehicleRoute;
    }

    public Boolean getUniform() {
        return uniform;
    }

    public void setUniform(Boolean uniform) {
        this.uniform = uniform;
    }

    public Boolean getCourse() {
        return course;
    }

    public void setCourse(Boolean course) {
        this.course = course;
    }

    public Long getStandardId() {
        return standardId;
    }

    public void setStandardId(Long standardId) {
        this.standardId = standardId;
    }

    public Set<Long> getSubjectIds() {
        return subjectIds;
    }

    public void setSubjectIds(Set<Long> subjectIds) {
        this.subjectIds = subjectIds;
    }

    public Set<Long> getMarksIds() {
        return marksIds;
    }

    public void setMarksIds(Set<Long> marksIds) {
        this.marksIds = marksIds;
    }

    public Set<Long> getParentsIds() {
        return parentsIds;
    }

    public void setParentsIds(Set<Long> parentsIds) {
        this.parentsIds = parentsIds;
    }

    public Set<Long> getFeeIds() {
        return feeIds;
    }

    public void setFeeIds(Set<Long> feeIds) {
        this.feeIds = feeIds;
    }
}
