package com.app.school.service;

import com.app.school.model.SessionStandardMapping;

import java.util.List;

public interface SessionStandardMappingService {

    List<SessionStandardMapping> getAllSessionStandardMapping();

    SessionStandardMapping getSessionStandardMappingById(Long id);

    List<SessionStandardMapping> getSpecificSessionStandardMapping(Long sessionId, Long standardId);

   SessionStandardMapping addSessionStandardMapping(SessionStandardMapping sessionStandardMapping);
}
