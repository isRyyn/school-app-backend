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
import java.util.stream.Collectors;

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
        return studentRepository.findAll().stream().filter(s -> s.getDocTC() == null || s.getDocTC() == false).collect(Collectors.toList());
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student getStudentByCode(String code) {
        return studentRepository.findByUDiasCode(code).orElse(null);
    }

    @Override
    public List<Student> getAllStudentdsByStandardId(Long standardId) {
        return studentRepository.findAllByStandardId(standardId).stream().filter(s -> s.getDocTC() == null || s.getDocTC() == false).collect(Collectors.toList());
    }

    @Override
    public Student addStudent(Student student, boolean addMapping, Long sessionId) {

        boolean isEdit = false;
        if(student.getId() != null) {
            isEdit = true;
        }

        Student s = studentRepository.save(student);

        if(!isEdit) {
            // add student to selected class
            Standard standard = standardService.getStandardById(student.getStandardId()).orElse(null);
            if(standard != null) {
                Set<Long>  standardIds = standard.getStudentIds();
                standardIds.add(s.getId());
                standard.setStudentIds(standardIds);
                standardService.addStandard(standard);
            }

            if(addMapping && sessionId >= 0) {
                // add student to session-standard mapping
                this.addSessionStandardMapping(s.getId(), s.getStandardId(), sessionId);
            }
        }

        return s;
    }

    @Override
    public void saveStudentStandards(List<Long> studentIds, List<Long> standardIds, Long sessionId) {

        List<Student> students = studentRepository.findAllById(studentIds);
        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            s.setStandardId(standardIds.get(i));
            this.addStudent(s, false, -1L);
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
