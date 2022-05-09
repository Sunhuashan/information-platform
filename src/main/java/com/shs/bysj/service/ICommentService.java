package com.shs.bysj.service;

import com.shs.bysj.pojo.Comment;

import java.util.List;

/**
 * @Author: shs
 * @Data: 2022/4/30 13:36
 */
public interface ICommentService {

    /**
     * 添加新的评论
     * @param comment
     */
    public void addComment(Comment comment);

    /**
     * 根据帖子查找评论
     * @param pid
     * @return
     */
    public List<Comment> findAllByPostIdAndState(Long pid);

    /**
     * 后台
     * 查找所有评论
     * @return
     */
    public List<Comment> findAll();

    /**
     * 后台
     * 更新状态
     * @param comment
     */
    public void updateState(Comment comment);

    /**
     * 后台
     * 删除
     * @param comment
     */
    public void deleteComment(Comment comment);
}
