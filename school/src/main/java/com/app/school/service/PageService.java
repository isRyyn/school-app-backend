package com.app.school.service;

import com.app.school.model.Page;

import java.util.List;

public interface PageService {

    List<Page> getAllPages();

    Page getPageById(Long id);

    Page addPage(Page page);

    void deletePage(Long id);
}
