package com.shs.bysj.controller;

import com.shs.bysj.pojo.Posts;
import com.shs.bysj.result.Result;
import com.shs.bysj.result.ResultFactory;
import com.shs.bysj.service.IPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

/**
 * @Author: shs
 * @Data: 2022/4/29 15:17
 */
@CrossOrigin
@RestController
public class PostsController {
    @Autowired
    IPostsService postsService;
    @ResponseBody
    @PostMapping(value = "/api/home/releasePosts")
    public Result releasePost(@RequestBody Posts posts) {
        postsService.savePosts(posts);
        return ResultFactory.buildSuccessResult(null);
    }

    @ResponseBody
    @GetMapping(value = "/api/home/findAllPostsByState")
    public Result findAllPostsByState() {
        List<Posts> list = postsService.findAllPostsByState();
        Collections.reverse(list);
        return ResultFactory.buildSuccessResult(list);
    }

    @ResponseBody
    @PostMapping(value = "/api/home/findAllPostsByReleaseName")
    public Result findAllByReleaseName(@RequestBody Posts posts) {
        List<Posts> list = postsService.findAllPostsByReleaseName(posts.getReleaseName());
        return ResultFactory.buildSuccessResult(list);
    }

    @ResponseBody
    @PostMapping(value = "/api/home/updatePosts")
    public Result updatePosts(@RequestBody Posts posts) {
        postsService.updatePosts(posts);
        return ResultFactory.buildSuccessResult(null);
    }

    @ResponseBody
    @PostMapping(value = "/api/home/deletePosts")
    public Result deletePosts(@RequestBody Posts posts) {
        postsService.deletePosts(posts);
        return ResultFactory.buildSuccessResult(null);
    }
}
