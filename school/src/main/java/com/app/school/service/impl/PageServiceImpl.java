package com.app.school.service.impl;

import com.app.school.model.Page;
import com.app.school.repository.PageRepository;
import com.app.school.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageServiceImpl implements PageService {

    @Autowired
    PageRepository pageRepository;

    @Override
    public List<Page> getAllPages() {
        return pageRepository.findAll();
    }

    @Override
    public Page getPageById(Long id) {
        return pageRepository.findById(id).orElse(null);
    }

    @Override
    public Page addPage(Page page) {
        return pageRepository.save(page);
    }

    @Override
    public void deletePage(Long id) {
        pageRepository.deleteById(id);
    }
}
