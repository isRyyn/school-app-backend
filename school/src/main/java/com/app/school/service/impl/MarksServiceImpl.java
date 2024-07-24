package com.app.school.service.impl;

import com.app.school.enums.ExamType;
import com.app.school.model.Marks;
import com.app.school.repository.MarksRepository;
import com.app.school.service.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarksServiceImpl implements MarksService {

    @Autowired
    private MarksRepository marksRepository;

    @Override
    public List<Marks> getAllMarks() {
        return marksRepository.findAll();
    }

    @Override
    public List<Marks> getAllMarksByStandardIdAndExamName(Long standardId, ExamType examName) {
        return marksRepository.findAllByStandardIdAndExamName(standardId, examName);
    }

    @Override
    public void saveMarks(List<Marks> marks) {
        marksRepository.saveAll(marks);
    }
}
