package com.shs.bysj.service.impl;

import com.shs.bysj.pojo.Posts;
import com.shs.bysj.repository.CommentRepository;
import com.shs.bysj.repository.PsotsRepository;
import com.shs.bysj.service.IPostsService;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @Author: shs
 * @Data: 2022/4/29 15:28
 */
@Service
public class PostsService implements IPostsService {
    @Autowired
    PsotsRepository psotsRepository;
    @Autowired
    CommentRepository commentRepository;
    @Override
    public void savePosts(Posts posts) {
        Date date = new Date();
        java.sql.Date dateSql = new java.sql.Date(date.getTime());
        posts.setDate(dateSql);

        posts.setState(true);

        psotsRepository.save(posts);
    }

    @Override
    public List<Posts> findAllPostsByState() {
        return psotsRepository.findAllByState(true);
    }

    @Override
    public List<Posts> findAllPostsByReleaseName(String name) {
        List<Posts> list = psotsRepository.findAllByStateAndAndReleaseName(true, name);
        Collections.reverse(list);
        return list;
    }

    @Override
    public void updatePosts(Posts posts) {
        Posts postsDB = psotsRepository.findPostsById(posts.getId());

        Date date = new Date();
        java.sql.Date dateSql = new java.sql.Date(date.getTime());
        postsDB.setDate(dateSql);

        postsDB.setState(true);

        postsDB.setTitle(posts.getTitle());
        postsDB.setContentHtml(posts.getContentHtml());
        postsDB.setContentHtml(posts.getContentHtml());

        psotsRepository.save(postsDB);
    }

    @Override
    public void deletePosts(Posts posts) {
        psotsRepository.deletePostsById(posts.getId());
        commentRepository.deleteAllByPostsId(posts.getId());
    }
}
