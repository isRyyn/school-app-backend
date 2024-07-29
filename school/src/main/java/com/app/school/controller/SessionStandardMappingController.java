package com.app.school.controller;

import com.app.school.model.SessionStandardMapping;
import com.app.school.service.SessionStandardMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/session-standard-mapping")
public class SessionStandardMappingController {

    @Autowired
    SessionStandardMappingService sessionStandardMappingService;

    @GetMapping
    public ResponseEntity<List<SessionStandardMapping>> getAll() {
        return ResponseEntity.ok(sessionStandardMappingService.getAllSessionStandardMapping());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SessionStandardMapping> getById(@PathVariable Long id) {
        return ResponseEntity.ok(sessionStandardMappingService.getSessionStandardMappingById(id));
    }

    @GetMapping("/{sessionId}/{standardId}")
    public ResponseEntity<List<SessionStandardMapping>> getSpecific(@PathVariable Long sessionId, @PathVariable Long standardId) {
        return ResponseEntity.ok(sessionStandardMappingService.getSpecificSessionStandardMapping(sessionId, standardId));
    }

    @PostMapping
    public ResponseEntity<SessionStandardMapping> save(@RequestBody SessionStandardMapping sessionStandardMapping) {
        return ResponseEntity.ok(sessionStandardMappingService.addSessionStandardMapping(sessionStandardMapping));
    }
}
