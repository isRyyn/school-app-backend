package com.app.school.model;

import com.app.school.enums.Gender;
import jakarta.persistence.*;

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
    private String dob;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String previousSchool;
    private Double totalFees;

    private Integer rollNo;

    private String picture;
    private String uDiasCode;


    // Contact details
    private String email;
    private String mobile;
    private String landline;
    private String address;
    private String city;
    private String state;
    private Integer pincode;

    // Login details
    private Long userId;


    // Transportation details
    private Long vehicleId;

    // Utility Details
    private Boolean uniform;
    private Boolean course;

    private Long standardId;

    // Documents submission
    private Boolean docTC;
    private Boolean docMarksheet;
    private Boolean docAadhar;
    private Boolean docParentAadhar;
    private Boolean docPhotograph;
    private Boolean docDobCertificate;

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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getuDiasCode() {
        return uDiasCode;
    }

    public void setuDiasCode(String uDiasCode) {
        this.uDiasCode = uDiasCode == null ? "" : uDiasCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getLandline() {
        return landline;
    }

    public void setLandline(String landline) {
        this.landline = landline;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
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

    public Boolean getDocTC() {
        return docTC;
    }

    public void setDocTC(Boolean docTC) {
        this.docTC = docTC;
    }

    public Boolean getDocMarksheet() {
        return docMarksheet;
    }

    public void setDocMarksheet(Boolean docMarksheet) {
        this.docMarksheet = docMarksheet;
    }

    public Boolean getDocAadhar() {
        return docAadhar;
    }

    public void setDocAadhar(Boolean docAadhar) {
        this.docAadhar = docAadhar;
    }

    public Boolean getDocParentAadhar() {
        return docParentAadhar;
    }

    public void setDocParentAadhar(Boolean docParentAadhar) {
        this.docParentAadhar = docParentAadhar;
    }

    public Boolean getDocPhotograph() {
        return docPhotograph;
    }

    public void setDocPhotograph(Boolean docPhotograph) {
        this.docPhotograph = docPhotograph;
    }

    public Boolean getDocDobCertificate() {
        return docDobCertificate;
    }

    public void setDocDobCertificate(Boolean docDobCertificate) {
        this.docDobCertificate = docDobCertificate;
    }
}
