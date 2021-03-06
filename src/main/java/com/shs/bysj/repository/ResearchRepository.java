package com.shs.bysj.repository;

import com.shs.bysj.pojo.News;
import com.shs.bysj.pojo.Research;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Author: shs
 * @Data: 2022/4/18 16:18
 */
public interface ResearchRepository extends JpaRepository<Research,Long>, JpaSpecificationExecutor<Research> {
    public List<Research> findAllByReleaseId(Long rid);
    public Research findResearchById(Long id);
    public List<Research> findAllByState(boolean state);

    public List<Research> findAllByIdIn(List<Long> ids);

    @Query(name = "findResearchByContentKeyword", nativeQuery = true, value = "select * from research where content like %:content%")
    public List<Research> findResearchByContentKeyword(@Param("content") String content);
}
