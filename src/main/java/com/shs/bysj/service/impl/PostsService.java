package com.shs.bysj.service.impl;

import com.shs.bysj.pojo.Posts;
import com.shs.bysj.repository.PsotsRepository;
import com.shs.bysj.service.IPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
