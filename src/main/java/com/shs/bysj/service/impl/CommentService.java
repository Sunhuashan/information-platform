package com.shs.bysj.service.impl;

import com.shs.bysj.pojo.Comment;
import com.shs.bysj.repository.CommentRepository;
import com.shs.bysj.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @Author: shs
 * @Data: 2022/4/30 13:41
 */
@Service
public class CommentService implements ICommentService {
    @Autowired
    CommentRepository commentRepository;
    @Override
    public void addComment(Comment comment) {
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        comment.setDate(sqlDate);

        comment.setState(true);
        if (comment.getParent() == null)
            comment.setParent(new Long(0));

        commentRepository.save(comment);
    }

    @Override
    public List<Comment> findAllByPostIdAndState(Long pid) {
        List<Comment> list = commentRepository.findAllByPostsIdAndState(pid,true);
        for (Comment comment : list) {
            if (comment.getParent().longValue() != 0) {
                comment.setParentComment(commentRepository.findCommentById(comment.getParent()));
            } else {
                comment.setParentComment(null);
            }
        }
        Collections.reverse(list);
        return list;
    }
}
