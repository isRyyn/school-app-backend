package com.app.school.controller;

import com.app.school.model.Marks;
import com.app.school.service.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marks")
public class MarksController {

    @Autowired
    private MarksService marksService;

    @GetMapping()
    public List<Marks> getAllMarks() {
        return marksService.getAllMarks();
    }

    @PostMapping()
    public Marks addMarks(@RequestBody Marks marks) {
        return marksService.addMarks(marks);
    }
}
