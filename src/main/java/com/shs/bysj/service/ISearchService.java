package com.shs.bysj.service;

import com.shs.bysj.pojo.Announcement;
import com.shs.bysj.pojo.News;
import com.shs.bysj.pojo.Research;
import com.shs.bysj.pojo.Search;

import java.util.List;

/**
 * @Author: shs
 * @Data: 2022/4/26 21:01
 */
public interface ISearchService {
    /**
     * 搜索新闻
     * @param search
     * @return
     */
    public List<News> searchNews(Search search);

    /**
     * 搜索公告
     * @param search
     * @return
     */
    public List<Announcement> searchAnnouncement(Search search);

    /**
     * 搜索科研信息
     * @param search
     * @return
     */
    public List<Research> searchResearch(Search search);
}
