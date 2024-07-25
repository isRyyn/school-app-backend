package com.app.school.service;

import com.app.school.model.Parent;

import java.util.List;

public interface ParentService {

    List<Parent> getAllParents();

    Parent getParentById(Long id);

    Parent saveParent(Parent parent);

    void saveMultipleParents(List<Parent> parentList);

    void deleteParent(Long id);
}
