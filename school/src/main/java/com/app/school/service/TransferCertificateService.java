package com.app.school.service;

import com.app.school.model.TransferCertificate;
import com.app.school.model.TransferCertificateRegister;

import java.util.List;

public interface TransferCertificateService {

    List<TransferCertificate> getAllTransferCertificates();

    List<TransferCertificateRegister> getAllTransferCertificateRegister();

    TransferCertificate getTransferCertificateById(Long id);

    void addTransferCertificate(TransferCertificate transferCertificate);

    void saveTransferCertificateRegister(TransferCertificateRegister transferCertificateRegister);
}
