package com.app.school.controller;

import com.app.school.enums.ExamType;
import com.app.school.model.Marks;
import com.app.school.service.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marks")
public class MarksController {

    @Autowired
    private MarksService marksService;

    @GetMapping
    public ResponseEntity<List<Marks>> getAllMarks() {
        return ResponseEntity.ok(marksService.getAllMarks());
    }

    @GetMapping("/get/{standardId}/{examName}")
    public ResponseEntity<List<Marks>> getAllMarksByStandardId(@PathVariable Long standardId, @PathVariable ExamType examName) {
        return ResponseEntity.ok(marksService.getAllMarksByStandardIdAndExamName(standardId, examName));
    }

    @PostMapping("/save")
    public void saveMarks(@RequestBody List<Marks> marks) {
        marksService.saveMarks(marks);
    }
}
