package com.app.school.controller;

import com.app.school.model.Marks;
import com.app.school.model.Student;
import com.app.school.model.Subject;
import com.app.school.service.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marks")
public class MarksController {

    @Autowired
    private MarksService marksService;

    @GetMapping("/students/{standardId}")
    public List<Student> getStudentsByStandard(@PathVariable Long standardId) {
        return marksService.getStudentsByStandard(standardId);
    }

    @GetMapping("/subjects/{standardId}")
    public List<Subject> getSubjectsByStandard(@PathVariable Long standardId) {
        return marksService.getSubjectsByStandard(standardId);
    }

    @PostMapping("/save")
    public void saveMarks(@RequestBody List<Marks> marks) {
        marksService.saveMarks(marks);
    }
}
