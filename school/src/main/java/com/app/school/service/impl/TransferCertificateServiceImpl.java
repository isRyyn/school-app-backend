package com.app.school.service.impl;

import com.app.school.model.Student;
import com.app.school.model.TransferCertificate;
import com.app.school.model.TransferCertificateRegister;
import com.app.school.repository.TransferCertificateRegisterRepository;
import com.app.school.repository.TransferCertificateRepository;
import com.app.school.service.StudentService;
import com.app.school.service.TransferCertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferCertificateServiceImpl implements TransferCertificateService {

    @Autowired
    TransferCertificateRepository transferCertificateRepository;

    @Autowired
    TransferCertificateRegisterRepository transferCertificateRegisterRepository;

    @Autowired
    StudentService studentService;

    @Override
    public List<TransferCertificate> getAllTransferCertificates() {
        return transferCertificateRepository.findAll();
    }


    @Override
    public List<TransferCertificateRegister> getAllTransferCertificateRegister() {
        return transferCertificateRegisterRepository.findAll();
    }

    @Override
    public TransferCertificate getTransferCertificateById(Long id) {
        return transferCertificateRepository.findById(id).orElse(null);
    }

    @Override
    public void addTransferCertificate(TransferCertificate transferCertificate) {
        Student student = studentService.getStudentById(transferCertificate.getStudentId());
        student.setDocTC(true);
        studentService.addStudent(student, false, -1L);
        transferCertificateRepository.save(transferCertificate);
    }

    @Override
    public void saveTransferCertificateRegister(TransferCertificateRegister transferCertificateRegister) {
        transferCertificateRegisterRepository.save(transferCertificateRegister);
    }
}
