package com.shs.bysj.repository;

import com.shs.bysj.pojo.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @Author: shs
 * @Data: 2022/4/10 21:26
 */
public interface AnnoRepository extends JpaRepository<Announcement,Long>, JpaSpecificationExecutor<Announcement> {
    List<Announcement> findAllById(Long id);
}
