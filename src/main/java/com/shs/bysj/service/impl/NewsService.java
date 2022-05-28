package com.shs.bysj.service.impl;

import com.shs.bysj.pojo.Manager;
import com.shs.bysj.pojo.News;
import com.shs.bysj.repository.ManagerRepository;
import com.shs.bysj.repository.NewsRepository;
import com.shs.bysj.service.INewsService;
import com.shs.bysj.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
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
        List<News> list = newsRepository.findAllByNewsReleaseId(id);
        Collections.reverse(list);
        return list;
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

    @Override
    public List<News> findAllNewsByState() {
        List<News> list = newsRepository.findAllByNewsState(true);
        Collections.sort(list, new Comparator<News>() {
            @Override
            public int compare(News o1, News o2) {
                Long diff = o1.getId() - o2.getId();
                if (diff > 0) {
                    return -1;
                } else if (diff < 0) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        return list;
    }

    @Override
    public News findNewsById(News news) {
        News newsDB = newsRepository.findNewsById(news.getId());
        String releaseName = managerRepository.findManagerById(newsDB.getNewsReleaseId()).getManagerUsername();
        String checkName = managerRepository.findManagerById(newsDB.getNewsCheckId()).getManagerUsername();
        newsDB.setNewsReleaseName(releaseName);
        newsDB.setNewsCheckName(checkName);
        return newsDB;
    }

    @Override
    public void addCheckInfo(News news) {
        News newsDB = newsRepository.findNewsById(news.getId());

        newsDB.setNewsDate(DateUtil.getSqlDate());
        newsDB.setNewsCheckId(managerRepository.findManagerByManagerUsername(news.getNewsCheckName()).getId());
        newsDB.setCheckInfo(news.getCheckInfo());

        newsRepository.save(newsDB);
    }
}
