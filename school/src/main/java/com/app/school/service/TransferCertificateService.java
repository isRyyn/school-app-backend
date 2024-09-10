package com.app.school.service;

import com.app.school.model.TransferCertificate;

import java.util.List;

public interface TransferCertificateService {

    List<TransferCertificate> getAllTransferCertificates();

    TransferCertificate getTransferCertificateById(Long id);

    void addTransferCertificate(TransferCertificate transferCertificate);
}
