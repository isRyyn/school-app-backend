package com.app.school.service;

import com.app.school.model.Marks;

import java.util.List;

public interface MarksService {
    List<Marks> getAllMarks();

    Marks getMarksById(Long id);

    Marks addMarks(Marks marks);

    void deleteMarks(Long id);
}
