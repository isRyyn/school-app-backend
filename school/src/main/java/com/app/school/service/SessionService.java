package com.app.school.service;

import com.app.school.model.Session;
import com.app.school.model.Student;

import java.util.List;

public interface SessionService {

    List<Session> getAllSessions();

    Session getSessionById(Long id);

    Session addSession(Session session);

    void deleteSession(Long id);
}
