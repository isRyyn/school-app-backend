package com.app.school.controller;

import com.app.school.model.TransferCertificate;
import com.app.school.service.TransferCertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tc")
public class TransferCertificateController {

    @Autowired
    TransferCertificateService transferCertificateService;

    @GetMapping
    public ResponseEntity<List<TransferCertificate>> getAllTransferCertificates() {
        return ResponseEntity.ok(transferCertificateService.getAllTransferCertificates());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransferCertificate> getTransferCertificateById(@PathVariable Long id) {
        return ResponseEntity.ok(transferCertificateService.getTransferCertificateById(id));
    }

    @PostMapping
    public ResponseEntity<Void> saveTransferCertificate(@RequestBody TransferCertificate transferCertificate) {
        transferCertificateService.addTransferCertificate(transferCertificate);
        return ResponseEntity.ok().build();
    }
}
