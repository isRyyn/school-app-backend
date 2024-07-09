package com.app.school.controller;

import com.app.school.model.Fee;
import com.app.school.service.FeeService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Fee addFees(@RequestBody Fee fee) {
        return feeService.addFees(fee);
    }
}
