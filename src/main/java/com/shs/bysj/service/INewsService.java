package com.shs.bysj.service;

import com.shs.bysj.pojo.MyFile;
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

    /**
     * 更新新闻状态
     * @param news
     */
    public void updateNewsState(News news);

    /**
     * 查找所有通过审核的新闻
     * @return
     */
    public List<News> findAllNewsByState();

    /**
     * 根据id返回新闻
     */
    public News findNewsById(News news);

    /**
     * 添加审核意见
     */
    public void addCheckInfo(News news);

    /**
     * 更新新闻
     * @param news
     */
    public void updateNews(News news);
}
