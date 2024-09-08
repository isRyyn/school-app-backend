package com.app.school.service.impl;

import org.springframework.stereotype.Service;

@Service
public class SharedService {

    private Long selectedSession;

    public void setSelectedSession(Long sessionId) {
        this.selectedSession = sessionId;
    }

    // Invalid case, since sessions will conflict if 2 users are using simultaneously
//    public Long getSelectedSession() {
//        return selectedSession;
//    }
}
