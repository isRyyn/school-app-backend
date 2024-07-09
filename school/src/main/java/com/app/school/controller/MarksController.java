package com.app.school.controller;

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

    @GetMapping()
    public ResponseEntity<List<Marks>> getAllMarks() {
        return ResponseEntity.ok(marksService.getAllMarks());
    }

    @PostMapping()
    public ResponseEntity<Marks> addMarks(@RequestBody Marks marks) {
        return ResponseEntity.ok(marksService.addMarks(marks));
    }
}
