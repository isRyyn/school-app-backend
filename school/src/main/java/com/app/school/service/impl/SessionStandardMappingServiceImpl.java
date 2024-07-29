package com.app.school.service.impl;

import com.app.school.model.SessionStandardMapping;
import com.app.school.repository.SessionStandardMappingRepository;
import com.app.school.service.SessionStandardMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionStandardMappingServiceImpl implements SessionStandardMappingService {

    @Autowired
    SessionStandardMappingRepository sessionStandardMappingRepository;

    @Override
    public List<SessionStandardMapping> getAllSessionStandardMapping() {
        return sessionStandardMappingRepository.findAll();
    }

    @Override
    public SessionStandardMapping getSessionStandardMappingById(Long id) {
        return sessionStandardMappingRepository.findById(id).orElse(null);
    }

    @Override
    public List<SessionStandardMapping> getSpecificSessionStandardMapping(Long sessionId, Long standardId) {
        return sessionStandardMappingRepository.findAllBySessionIdAndStandardId(sessionId, standardId);
    };

   @Override
    public SessionStandardMapping addSessionStandardMapping(SessionStandardMapping sessionStandardMapping) {
       return sessionStandardMappingRepository.save(sessionStandardMapping);
   }
}
