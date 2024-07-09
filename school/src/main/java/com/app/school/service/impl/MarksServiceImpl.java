package com.app.school.service.impl;

import com.app.school.model.Marks;
import com.app.school.repository.MarksRepository;
import com.app.school.service.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarksServiceImpl implements MarksService {

    @Autowired
    MarksRepository marksRepository;

    @Override
    public List<Marks> getAllMarks() {
        return marksRepository.findAll();
    }

    @Override
    public Marks getMarksById(Long id) {
        return marksRepository.findById(id).orElse(null);
    }

    @Override
    public Marks addMarks(Marks marks) {
        return marksRepository.save(marks);
    }

    @Override
    public void deleteMarks(Long id) {
        marksRepository.deleteById(id);
    }
}
