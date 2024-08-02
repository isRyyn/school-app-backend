package com.app.school.service.impl;

import com.app.school.model.SessionStandardMapping;
import com.app.school.model.Standard;
import com.app.school.model.Student;
import com.app.school.repository.StudentRepository;
import com.app.school.service.SessionStandardMappingService;
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

    @Autowired
    private SessionStandardMappingService sessionStandardMappingService;

    @Autowired
    private SharedService sharedService;

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
    public Student addStudent(Student student, boolean addMapping) {

        // add student to selected class
        Standard standard = standardService.getStandardById(student.getStandardId()).orElse(null);
        if(standard != null) {
            Set<Long>  standardIds = standard.getStudentIds();
            standardIds.add(student.getId());
            standard.setStudentIds(standardIds);
            standardService.addStandard(standard);
        }

        Student s = studentRepository.save(student);

        if(addMapping) {
            // add student to session-standard mapping
            this.addSessionStandardMapping(s.getId(), s.getStandardId(), sharedService.getSelectedSession());
        }
        return s;
    }

    @Override
    public void saveStudentStandards(List<Long> studentIds, List<Long> standardIds, Long sessionId) {

        List<Student> students = studentRepository.findAllById(studentIds);
        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            s.setStandardId(standardIds.get(i));
            this.addStudent(s, false);
            this.addSessionStandardMapping(s.getId(), standardIds.get(i), sessionId);
        }
    }

    @Override
    public void removeStudent(Long id) {
        studentRepository.deleteById(id);
    }

    private void addSessionStandardMapping(Long studentId, Long standardId, Long sessionId) {
        SessionStandardMapping newMapping = new SessionStandardMapping(sessionId, standardId, studentId);
        this.sessionStandardMappingService.addSessionStandardMapping(newMapping);
    }
}
