package com.app.school.service.impl;

import com.app.school.model.Marks;
import com.app.school.model.Student;
import com.app.school.model.Subject;
import com.app.school.repository.MarksRepository;
import com.app.school.repository.StudentRepository;
import com.app.school.repository.SubjectRepository;
import com.app.school.service.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarksServiceImpl implements MarksService {

    @Autowired
    private MarksRepository marksRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public List<Student> getStudentsByStandard(Long standardId) {
        return studentRepository.findByStandardId(standardId);
    }

    @Override
    public List<Subject> getSubjectsByStandard(Long standardId) {
        return subjectRepository.findByStandardId(standardId);
    }

    @Override
    public void saveMarks(List<Marks> marks) {
        marksRepository.saveAll(marks);
    }
}
