package com.shs.bysj.service.impl;

import com.shs.bysj.pojo.Manager;
import com.shs.bysj.pojo.News;
import com.shs.bysj.repository.ManagerRepository;
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
    @Autowired
    ManagerRepository managerRepository;
    @Override
    public List<News> findAllByReleaseId(Long id) {
        return newsRepository.findAllByNewsReleaseId(id);
    }

    @Override
    public List<News> findAll() {
        return newsRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        newsRepository.deleteById(id);
    }

    @Override
    public void addNews(News news) {
        newsRepository.save(news);
    }

    @Override
    public void updateNewsState(News news) {
        Long id = news.getId();
        String name = news.getNewsCheckName();
        Manager manager = managerRepository.findManagerByManagerUsername(name);

        News newsDB = newsRepository.getById(id);

        newsDB.setNewsState(news.isNewsState());
        newsDB.setNewsCheckId(manager.getId());
        newsRepository.save(newsDB);
    }

}
