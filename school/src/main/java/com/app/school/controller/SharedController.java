package com.app.school.controller;

import com.app.school.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/shared")
public class SharedController {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    StandardRepository standardRepository;

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    PageRepository pageRepository;

    @GetMapping("/count")
    public Map<String, Long> getEntityCount() {
        Map<String, Long> counts = new HashMap<>();
        counts.put("students", studentRepository.count());
        counts.put("teachers", teacherRepository.count());
        counts.put("classes", standardRepository.count());
        counts.put("subjects", subjectRepository.count());
        counts.put("vehicles", vehicleRepository.count());
        counts.put("pages", pageRepository.count());
        return counts;
    }
}
