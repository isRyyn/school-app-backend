package com.app.school.controller;

import com.app.school.model.Standard;
import com.app.school.service.StandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/standard")
public class StandardController {

    @Autowired
    StandardService standardService;

    @GetMapping
    public ResponseEntity<List<Standard>> getAllStandards() {
        return ResponseEntity.ok(standardService.getAllStandards());
    }

    @PostMapping
    public ResponseEntity<Standard> addStandard(@RequestBody Standard standard) {
        return ResponseEntity.ok(standardService.addStandard(standard));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStandard(@PathVariable Long id) {
        standardService.deleteStandard(id);
        return ResponseEntity.noContent().build();
    }
}
