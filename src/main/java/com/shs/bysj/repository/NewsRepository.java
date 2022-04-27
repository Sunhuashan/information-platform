package com.shs.bysj.repository;

import com.shs.bysj.pojo.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Author: shs
 * @Data: 2022/4/7 14:04
 */
public interface NewsRepository extends JpaRepository<News,Long>, JpaSpecificationExecutor<News> {
    public List<News> findAllByNewsReleaseId(Long id);
    public List<News> findAllByNewsState(boolean state);
    public News findNewsById(Long id);

    public List<News> findAllByIdIn(List<Long> ids);

    @Query(name = "findNewsByTitleKeyword", nativeQuery = true, value = "select * from news where news_title like %:title%")
    public List<News> findNewsByTitleKeyword(@Param("title") String title);
}
