package com.shs.bysj.repository;

import com.shs.bysj.pojo.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Author: shs
 * @Data: 2022/4/30 13:33
 */
public interface CommentRepository extends JpaRepository<Comment,Long>, JpaSpecificationExecutor<Comment> {
    public List<Comment> findAllByState(boolean state);
    public Comment findCommentById(Long id);
    @Query(nativeQuery = true,value = "select * from comment where posts_id = :pid and state = :state")
    public List<Comment> findAllByPostsIdAndState(Long pid, boolean state);
}
