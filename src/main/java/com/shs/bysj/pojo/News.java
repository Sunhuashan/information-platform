package com.shs.bysj.pojo;

import javax.persistence.*;
import java.sql.Date;

/**
 * @Author: shs
 * @Data: 2022/4/7 11:30
 */
@Entity
@Table(name = "news")
public class News {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String newsTitle;
    private String newsAbstract;
    private String newsContentHtml;
    private String newsContentMd;
    private Date newsDate;
    private Long newsReleaseId;
    private Long newsCheckId;
    private String newsImagePath;
    @Column(columnDefinition = "boolean default false")
    private boolean newsState;

    @Transient
    private String newsReleaseName;
    @Transient
    private String newsCheckName;

    public String getNewsReleaseName() {
        return newsReleaseName;
    }

    public void setNewsReleaseName(String newsReleaseName) {
        this.newsReleaseName = newsReleaseName;
    }

    public String getNewsCheckName() {
        return newsCheckName;
    }

    public void setNewsCheckName(String newsCheckName) {
        this.newsCheckName = newsCheckName;
    }

    public boolean isNewsState() {
        return newsState;
    }

    public void setNewsState(boolean newsState) {
        this.newsState = newsState;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", newsTitle='" + newsTitle + '\'' +
                ", newsAbstract='" + newsAbstract + '\'' +
                ", newsContentHtml='" + newsContentHtml + '\'' +
                ", newsContentMd='" + newsContentMd + '\'' +
                ", newsDate=" + newsDate +
                ", newsReleaseId=" + newsReleaseId +
                ", newsCheckId=" + newsCheckId +
                ", newsImagePath='" + newsImagePath + '\'' +
                ", newsState=" + newsState +
                ", newsReleaseName='" + newsReleaseName + '\'' +
                ", newsCheckName='" + newsCheckName + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsAbstract() {
        return newsAbstract;
    }

    public void setNewsAbstract(String newsAbstract) {
        this.newsAbstract = newsAbstract;
    }

    public String getNewsContentHtml() {
        return newsContentHtml;
    }

    public void setNewsContentHtml(String newsContentHtml) {
        this.newsContentHtml = newsContentHtml;
    }

    public String getNewsContentMd() {
        return newsContentMd;
    }

    public void setNewsContentMd(String newsContentMd) {
        this.newsContentMd = newsContentMd;
    }

    public Date getNewsDate() {
        return newsDate;
    }

    public void setNewsDate(Date newsDate) {
        this.newsDate = newsDate;
    }

    public Long getNewsReleaseId() {
        return newsReleaseId;
    }

    public void setNewsReleaseId(Long newsReleaseId) {
        this.newsReleaseId = newsReleaseId;
    }

    public Long getNewsCheckId() {
        return newsCheckId;
    }

    public void setNewsCheckId(Long newsCheckId) {
        this.newsCheckId = newsCheckId;
    }

    public String getNewsImagePath() {
        return newsImagePath;
    }

    public void setNewsImagePath(String newsImagePath) {
        this.newsImagePath = newsImagePath;
    }
}
