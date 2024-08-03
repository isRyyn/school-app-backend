package com.app.school.service.impl;

import com.app.school.model.Parent;
import com.app.school.model.Student;
import com.app.school.repository.ParentRepository;
import com.app.school.service.ParentService;
import com.app.school.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ParentServiceImpl implements ParentService {

    @Autowired
    ParentRepository parentRepository;

    @Autowired
    StudentService studentService;


    @Override
    public List<Parent> getAllParents() {
        return parentRepository.findAll();
    }

    @Override
    public Parent getParentById(Long id) {
        return parentRepository.findById(id).orElse(null);
    }

    @Override
    public Parent saveParent(Parent parent) {
        Parent savedParent = parentRepository.save(parent);
        addParentToChild(savedParent);
        return savedParent;
    }

    @Override
    public void saveMultipleParents(List<Parent> parentList) {
        List<Parent> savedParents = parentRepository.saveAll(parentList);
        addParentToChild(savedParents);
    }

    @Override
    public void deleteParent(Long id) {
        parentRepository.deleteById(id);
    }

    private void addParentToChild(List<Parent> savedParents) {
        // get parents
        Set<Long> savedParentsIds = new HashSet<>();
        savedParents.forEach(savedParent -> {
            savedParentsIds.add(savedParent.getId());
        });

        // get student
        Set<Long> studentIds = savedParents.get(0).getChildIds();
        Long studentAdded = null;
        for (Long element : studentIds) {
            studentAdded = element;
        }

        // save parents in student
        Student student = studentService.getStudentById(studentAdded);
        if(student != null) {
            Set<Long> parentIds = student.getParentsIds();
            parentIds.addAll(savedParentsIds);
            student.setParentsIds(parentIds);
            studentService.addStudent(student, false);
        }
    }

    private void addParentToChild(Parent savedParent) {
        Set<Long> studentIds = savedParent.getChildIds();
        studentIds.forEach(studentId -> {
            Student student = studentService.getStudentById(studentId);
            if(student != null) {
                Set<Long> parentIds = student.getParentsIds();
                parentIds.add(savedParent.getId());
                student.setParentsIds(parentIds);
                studentService.addStudent(student, false);
            }
        });
    }
}
