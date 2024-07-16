package com.app.school.service.impl;

import com.app.school.model.Parent;
import com.app.school.repository.ParentRepository;
import com.app.school.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParentServiceImpl implements ParentService {

    @Autowired
    ParentRepository parentRepository;


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
        return parentRepository.save(parent);
    }

    @Override
    public void deleteParent(Long id) {
        parentRepository.deleteById(id);
    }
}
