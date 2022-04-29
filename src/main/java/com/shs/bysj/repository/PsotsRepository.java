package com.shs.bysj.repository;

import com.shs.bysj.pojo.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @Author: shs
 * @Data: 2022/4/29 15:16
 */
public interface PsotsRepository extends JpaRepository<Posts,Long>, JpaSpecificationExecutor<Posts> {
    public List<Posts> findAllByState(boolean state);
}
