package com.shs.bysj.pojo;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.persistence.*;
import java.sql.Date;

/**
 * @Author: shs
 * @Data: 2022/4/16 10:11
 */
@Entity
@Table(name = "publicity")
public class Publicity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pubType;
    private String pubDescribe;
    private String pubPath;
    private Date pubDate;
    private Long pubReleaseId;
    private Long pubCheckId;
    @Column(columnDefinition = "boolean default false")
    private boolean pubState;
    @Transient
    private String pubReleaseName;
    @Transient
    private String pubCheckName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPubType() {
        return pubType;
    }

    public void setPubType(String pubType) {
        this.pubType = pubType;
    }

    public String getPubDescribe() {
        return pubDescribe;
    }

    public void setPubDescribe(String pubDescribe) {
        this.pubDescribe = pubDescribe;
    }

    public String getPubPath() {
        return pubPath;
    }

    public void setPubPath(String pubPath) {
        this.pubPath = pubPath;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public Long getPubReleaseId() {
        return pubReleaseId;
    }

    public void setPubReleaseId(Long pubReleaseId) {
        this.pubReleaseId = pubReleaseId;
    }

    public Long getPubCheckId() {
        return pubCheckId;
    }

    public void setPubCheckId(Long pubCheckId) {
        this.pubCheckId = pubCheckId;
    }

    public boolean isPubState() {
        return pubState;
    }

    public void setPubState(boolean pubState) {
        this.pubState = pubState;
    }

    public String getPubReleaseName() {
        return pubReleaseName;
    }

    public void setPubReleaseName(String pubReleaseName) {
        this.pubReleaseName = pubReleaseName;
    }

    public String getPubCheckName() {
        return pubCheckName;
    }

    public void setPubCheckName(String pubCheckName) {
        this.pubCheckName = pubCheckName;
    }
}
