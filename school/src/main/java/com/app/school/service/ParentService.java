package com.app.school.service;

import com.app.school.model.Parent;

import java.util.List;

public interface ParentService {

    List<Parent> getAllParents();

    Parent getParentById(Long id);

    Parent saveParent(Parent parent);

    void deleteParent(Long id);
}
