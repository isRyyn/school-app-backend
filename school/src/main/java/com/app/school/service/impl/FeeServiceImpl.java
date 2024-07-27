package com.app.school.service.impl;

import com.app.school.model.Fee;
import com.app.school.repository.FeeRepository;
import com.app.school.service.FeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeeServiceImpl implements FeeService {

    @Autowired
    FeeRepository feeRepository;

    @Override
    public List<Fee> getAllFees() {
        return feeRepository.findAll();
    }

    @Override
    public Fee getFeesById(Long id) {
        return feeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Fee> getAllFeesByStudentIdAndSessionId(Long studentId, Long sessionId) {
        return feeRepository.findAllByStudentIdAndSessionId(studentId, sessionId);
    }

    @Override
    public Fee addFees(Fee fee) {
        return feeRepository.save(fee);
    }

    @Override
    public void deleteFees(Long id) {
        feeRepository.deleteById(id);
    }
}
