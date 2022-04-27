package com.shs.bysj.pojo;

/**
 * @Author: shs
 * @Data: 2022/4/26 20:58
 */
public class Search {
    private String content;
    private Research research;
    private Announcement announcement;
    private News news;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Research getResearch() {
        return research;
    }

    public void setResearch(Research research) {
        this.research = research;
    }

    public Announcement getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(Announcement announcement) {
        this.announcement = announcement;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }
}
