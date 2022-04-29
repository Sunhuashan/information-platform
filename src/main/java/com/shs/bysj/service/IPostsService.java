package com.shs.bysj.service;

import com.shs.bysj.pojo.Posts;

import java.util.List;

/**
 * @Author: shs
 * @Data: 2022/4/29 15:26
 */
public interface IPostsService {
    /**
     * 保存帖子
     * @param posts
     */
    public void savePosts(Posts posts);

    /**
     * 返回所有审核通过的帖子
     * @return
     */
    public List<Posts> findAllPostsByState();
}
