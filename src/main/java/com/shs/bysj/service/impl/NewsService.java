package com.shs.bysj.service.impl;

import com.shs.bysj.pojo.News;
import com.shs.bysj.repository.NewsRepository;
import com.shs.bysj.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: shs
 * @Data: 2022/4/7 14:09
 */
@Service
public class NewsService implements INewsService {
    @Autowired
    NewsRepository newsRepository;
    @Override
    public List<News> findAllByReleaseId(Long id) {
        return newsRepository.findAllByNewsReleaseId(id);
    }

    @Override
    public void deleteById(Long id) {
        newsRepository.deleteById(id);
    }
}
