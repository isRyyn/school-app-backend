package com.app.school.model;

import jakarta.persistence.*;

import java.util.Map;

@Entity
public class TransferCertificateRegister {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentId;
    private String admissionFileNo;
    private String withdrawlFileNo;
    private String transferCertificateNo;
    private String scholarNameAndAadhaar;
    private String occupationAndAddress;
    private String dob;
    private String lastInstitution;
    private String religion;
    private String mother;
    private String father;
    private String lengthOfResidence;
    private String bankName;
    private String bankAccount;
    private String dated;
    private String headOfInstitution;

    @ElementCollection
    @MapKeyColumn(name = "class_level")
    @Column(name = "class_details")
    @CollectionTable(name = "class_details", joinColumns = @JoinColumn(name = "register_id"))
    private Map<String, TransferCertificateRegisterClass> classDetails;

    // Getters and Setters
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

    public String getAdmissionFileNo() {
        return admissionFileNo;
    }

    public void setAdmissionFileNo(String admissionFileNo) {
        this.admissionFileNo = admissionFileNo;
    }

    public String getWithdrawlFileNo() {
        return withdrawlFileNo;
    }

    public void setWithdrawlFileNo(String withdrawlFileNo) {
        this.withdrawlFileNo = withdrawlFileNo;
    }

    public String getTransferCertificateNo() {
        return transferCertificateNo;
    }

    public void setTransferCertificateNo(String transferCertificateNo) {
        this.transferCertificateNo = transferCertificateNo;
    }

    public String getScholarNameAndAadhaar() {
        return scholarNameAndAadhaar;
    }

    public void setScholarNameAndAadhaar(String scholarNameAndAadhaar) {
        this.scholarNameAndAadhaar = scholarNameAndAadhaar;
    }

    public String getOccupationAndAddress() {
        return occupationAndAddress;
    }

    public void setOccupationAndAddress(String occupationAndAddress) {
        this.occupationAndAddress = occupationAndAddress;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getLastInstitution() {
        return lastInstitution;
    }

    public void setLastInstitution(String lastInstitution) {
        this.lastInstitution = lastInstitution;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
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

    public String getLengthOfResidence() {
        return lengthOfResidence;
    }

    public void setLengthOfResidence(String lengthOfResidence) {
        this.lengthOfResidence = lengthOfResidence;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public Map<String, TransferCertificateRegisterClass> getClassDetails() {
        return classDetails;
    }

    public void setClassDetails(Map<String, TransferCertificateRegisterClass> classDetails) {
        this.classDetails = classDetails;
    }

    public String getDated() {
        return dated;
    }

    public void setDated(String dated) {
        this.dated = dated;
    }

    public String getHeadOfInstitution() {
        return headOfInstitution;
    }

    public void setHeadOfInstitution(String headOfInstitution) {
        this.headOfInstitution = headOfInstitution;
    }
}
