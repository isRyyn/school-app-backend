package com.app.school.controller;

import com.app.school.model.Fee;
import com.app.school.service.FeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/fee")
public class FeeController {

    @Autowired
    private FeeService feeService;

    @PostMapping()
    public ResponseEntity<Fee> addFees(@RequestBody Fee fee) {
        return ResponseEntity.ok(feeService.addFees(fee));
    }
}
