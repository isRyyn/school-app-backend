package com.app.school.service;

import com.app.school.model.Fee;

import java.util.List;

public interface FeeService {

    List<Fee> getAllFees();

    Fee getFeesById(Long id);

    List<Fee> getAllFeesByStudentIdAndSessionId(Long studentId, Long sessionId);

    Fee addFees(Fee fee);

    void deleteFees(Long id);
}
