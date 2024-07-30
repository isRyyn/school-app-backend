package com.app.school.controller;

import com.app.school.model.Fee;
import com.app.school.service.FeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fee")
public class FeeController {

    @Autowired
    private FeeService feeService;

    @GetMapping
    public ResponseEntity<List<Fee>> getAllFee() {
        return ResponseEntity.ok(feeService.getAllFees());
    }

    @GetMapping("/{studentId}/{sessionId}")
    public ResponseEntity<List<Fee>> getAllFeeByStudentId(@PathVariable Long studentId, @PathVariable Long sessionId) {
        return ResponseEntity.ok(feeService.getAllFeesByStudentIdAndSessionId(studentId, sessionId));
    }

    @PostMapping()
    public ResponseEntity<Fee> addFees(@RequestBody Fee fee) {
        return ResponseEntity.ok(feeService.addFees(fee));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFee(@PathVariable Long id) {
        feeService.deleteFees(id);
        return ResponseEntity.noContent().build();
    }
}
