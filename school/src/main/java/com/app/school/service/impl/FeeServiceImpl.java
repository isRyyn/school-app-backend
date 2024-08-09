package com.app.school.service.impl;

import com.app.school.model.Fee;
import com.app.school.model.Student;
import com.app.school.repository.FeeRepository;
import com.app.school.service.FeeService;
import com.app.school.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeeServiceImpl implements FeeService {

    @Autowired
    FeeRepository feeRepository;

    @Autowired
    SharedService sharedService;

    @Autowired
    StudentService studentService;

    @Override
    public List<Fee> getAllFees() {
        return feeRepository.findAllBySessionId(sharedService.getSelectedSession());
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
        Student s = studentService.getStudentById(fee.getStudentId());
        fee.setStandardId(s.getStandardId());

        return feeRepository.save(fee);
    }

    @Override
    public void deleteFees(Long id) {
        feeRepository.deleteById(id);
    }
}
