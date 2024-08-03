package com.app.school.controller;

import com.app.school.service.impl.ImportFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/import")
public class ImportFileController {

    @Autowired
    private ImportFileService importFileService;

    @PostMapping()
    public ResponseEntity uploadFile(@RequestParam("file") MultipartFile file) {
        importFileService.readExcelAndSaveData(file);
        return ResponseEntity.ok().build();
    }
}
