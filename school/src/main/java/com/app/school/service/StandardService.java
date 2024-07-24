package com.app.school.service;

import com.app.school.model.Standard;

import java.util.List;
import java.util.Optional;

public interface StandardService {

    List<Standard> getAllStandards();

    Optional<Standard> getStandardById(Long id);
    Standard addStandard(Standard standard);

    void deleteStandard(Long id);
}
