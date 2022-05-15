package com.shs.bysj.pojo;

import javax.persistence.*;
import java.sql.Date;

/**
 * @Author: shs
 * @Data: 2022/4/10 18:34
 */
@Entity
@Table(name = "announcement")
public class Announcement {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String annoContent;
    private Date annoDate;
    private Long annoReleaseId;
    private Long annoCheckId;
    private String checkInfo;

    @Column(columnDefinition = "boolean default false")
    private boolean annoState;

    @Transient
    private String annoReleaseName;
    @Transient
    private String annoCheckName;

    @Override
    public String toString() {
        return "Announcement{" +
                "id=" + id +
                ", annoContent='" + annoContent + '\'' +
                ", annoDate=" + annoDate +
                ", annoReleaseId=" + annoReleaseId +
                ", annoCheckId=" + annoCheckId +
                ", annoState=" + annoState +
                ", annoReleaseName='" + annoReleaseName + '\'' +
                ", annoCheckName='" + annoCheckName + '\'' +
                '}';
    }

    public String getCheckInfo() {
        return checkInfo;
    }

    public void setCheckInfo(String checkInfo) {
        this.checkInfo = checkInfo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnnoContent() {
        return annoContent;
    }

    public void setAnnoContent(String annoContent) {
        this.annoContent = annoContent;
    }

    public Date getAnnoDate() {
        return annoDate;
    }

    public void setAnnoDate(Date annoDate) {
        this.annoDate = annoDate;
    }

    public Long getAnnoReleaseId() {
        return annoReleaseId;
    }

    public void setAnnoReleaseId(Long annoReleaseId) {
        this.annoReleaseId = annoReleaseId;
    }

    public Long getAnnoCheckId() {
        return annoCheckId;
    }

    public void setAnnoCheckId(Long annoCheckId) {
        this.annoCheckId = annoCheckId;
    }

    public boolean isAnnoState() {
        return annoState;
    }

    public void setAnnoState(boolean annoState) {
        this.annoState = annoState;
    }

    public String getAnnoReleaseName() {
        return annoReleaseName;
    }

    public void setAnnoReleaseName(String annoReleaseName) {
        this.annoReleaseName = annoReleaseName;
    }

    public String getAnnoCheckName() {
        return annoCheckName;
    }

    public void setAnnoCheckName(String annoCheckName) {
        this.annoCheckName = annoCheckName;
    }
}
