package com.app.school.service.impl;

import com.app.school.model.Standard;
import com.app.school.repository.StandardRepository;
import com.app.school.service.StandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StandardServiceImpl implements StandardService {
    @Autowired
    StandardRepository standardRepository;

    @Override
    public List<Standard> getAllStandards() {
        return standardRepository.findAll();
    }

    @Override
    public Optional<Standard> getStandardById(Long id) { return standardRepository.findById(id); }

    @Override
    public Standard addStandard(Standard standard) {
        return standardRepository.save(standard);
    }

    @Override
    public void deleteStandard(Long id) {
        standardRepository.deleteById(id);
    }
}
