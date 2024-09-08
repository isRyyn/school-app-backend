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

    @PostMapping("/student")
    public ResponseEntity uploadStudentFile(@RequestParam("file") MultipartFile file) {
        importFileService.readExcelAndSaveStudentData(file);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/fees")
    public ResponseEntity uploadFeesFile(@RequestParam("file") MultipartFile file) {
        importFileService.readExcelAndSaveFeesData(file);
        return ResponseEntity.ok().build();
    }

//    @PostMapping("/marks")
//    public ResponseEntity uploadMarksFile(@RequestParam("file") MultipartFile file) {
//        importFileService.readExcelAndSaveMarksData(file);
//        return ResponseEntity.ok().build();
//    }
}
