package com.app.school.service.impl;

import com.app.school.controller.StandardController;
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
public class StandardServiceImpl implements StandardService {
    @Autowired
    StandardRepository standardRepository;

    @Autowired
    SubjectRepository subjectRepository;

    @Override
    public List<Standard> getAllStandards() {
        return standardRepository.findAll();
    }

    @Override
    public Optional<Standard> getStandardById(Long id) { return standardRepository.findById(id); }

    @Override
    public Standard addStandard(Standard standard) {
        Standard s = standardRepository.save(standard);

        standard.getSubjectIds().forEach(subjectId -> {
            Subject subject = subjectRepository.findById(subjectId).orElse(null);
            if(subject != null) {
                Set<Long> standardIds = subject.getStandardIds();
                standardIds.add(s.getId());
                subject.setStandardIds(standardIds);
                subjectRepository.save(subject);
            }
        });
        return s;
    }

    @Override
    public void deleteStandard(Long id) {
        standardRepository.deleteById(id);
    }
}
