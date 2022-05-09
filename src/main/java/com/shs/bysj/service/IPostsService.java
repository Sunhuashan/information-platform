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

    /**
     * 根据发布人返回帖子
     * @param name
     * @return
     */
    public List<Posts> findAllPostsByReleaseName(String name);

    /**
     * 更新帖子内容
     * @param posts
     */
    public void updatePosts(Posts posts);

    /**
     * 删除帖子及其回帖
     * @param posts
     */
    public void deletePosts(Posts posts);

    /**
     * 后台
     * 获取所有帖子
     * @return
     */
    public List<Posts> findAllPosts();

    /**
     * 后台
     * 更新帖子状态
     */
    public void updatePostsState(Posts posts);


    /**
     * 后台
     * 更新审核意见
     * @param posts
     */
    public void updateCheckInfo(Posts posts);

}
