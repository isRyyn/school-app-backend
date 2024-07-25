package com.app.school.service.impl;

import com.app.school.model.Standard;
import com.app.school.model.Student;
import com.app.school.repository.StudentRepository;
import com.app.school.service.StandardService;
import com.app.school.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StandardService standardService;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Student> getAllStudentdsByStandardId(Long standardId) {
        return studentRepository.findAllByStandardId(standardId);
    }

    @Override
    public Student addStudent(Student student) {

        Standard standard = standardService.getStandardById(student.getStandardId()).orElse(null);
        if(standard != null) {
            Set<Long>  standardIds = standard.getStudentIds();
            standardIds.add(student.getId());
            standard.setStudentIds(standardIds);
            standardService.addStandard(standard);
        }

        return studentRepository.save(student);
    }

    @Override
    public void removeStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
