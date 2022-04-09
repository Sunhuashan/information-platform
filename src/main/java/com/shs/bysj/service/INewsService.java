package com.shs.bysj.service;

import com.shs.bysj.pojo.News;

import java.util.List;

/**
 * @Author: shs
 * @Data: 2022/4/7 14:07
 */
public interface INewsService {
    /**
     * 根据发布人id查找所有新闻
     * @param id
     * @return
     */
    public List<News> findAllByReleaseId(Long id);
    public List<News> findAll();
    /**
     * 根据id删除新闻
     * @param id
     */
    public void deleteById(Long id);

    /**
     * 添加新闻
     * @param news
     */
    public void addNews(News news);
}
