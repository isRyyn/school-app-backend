package com.app.school.service.impl;

import com.app.school.model.Standard;
import com.app.school.model.Subject;
import com.app.school.repository.StandardRepository;
import com.app.school.repository.SubjectRepository;
import com.app.school.service.StandardService;
import com.app.school.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    StandardRepository standardRepository;

    @Override
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    @Override
    public Optional<Subject> getSubjectById(Long id) {
        return subjectRepository.findById(id);
    }

    @Override
    public Subject addSubject(Subject subject) {

        subject.getStandardIds().forEach(standardId -> {
            Standard standard = standardRepository.findById(standardId).orElse(null);
            if(standard != null) {
                Set<Long> subjectsIds = standard.getSubjectIds();
                subjectsIds.add(subject.getId());
                standard.setSubjectIds(subjectsIds);
                standardRepository.save(standard);
            }
        });

        return subjectRepository.save(subject);
    }

    @Override
    public void deleteSubject(Long id) {
        subjectRepository.deleteById(id);
    }
}