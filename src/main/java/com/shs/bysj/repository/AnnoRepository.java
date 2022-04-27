package com.shs.bysj.repository;

import com.shs.bysj.pojo.Announcement;
import com.shs.bysj.pojo.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Author: shs
 * @Data: 2022/4/10 21:26
 */
public interface AnnoRepository extends JpaRepository<Announcement,Long>, JpaSpecificationExecutor<Announcement> {
    List<Announcement> findAllByAnnoReleaseId(Long id);
    Announcement findAnnouncementById(Long aid);
    List<Announcement> findAllByAnnoState(boolean state);

    List<Announcement> findAllByIdIn(List<Long> ids);

    @Query(name = "findAnnosByContentKeyword", nativeQuery = true, value = "select * from announcement where anno_content like %:content%")
    public List<Announcement> findAnnoByContentKeyword(@Param("content") String content);
}
