package com.shs.bysj.controller;

import com.shs.bysj.pojo.Comment;
import com.shs.bysj.result.Result;
import com.shs.bysj.result.ResultFactory;
import com.shs.bysj.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: shs
 * @Data: 2022/4/30 13:50
 */
@RestController
@CrossOrigin
public class CommentController {
    @Autowired
    ICommentService commentService;
    @ResponseBody
    @PostMapping(value = "/api/home/addComment")
    public Result addComment(@RequestBody Comment comment) {
        commentService.addComment(comment);
        return ResultFactory.buildSuccessResult(null);
    }

    @ResponseBody
    @PostMapping(value = "/api/home/findAllComment")
    public Result findAllByPostsIdAndState(@RequestBody Comment comment) {
        List<Comment> list = commentService.findAllByPostIdAndState(comment.getPostsId());
        return ResultFactory.buildSuccessResult(list);
    }

    @ResponseBody
    @PostMapping(value = "/api/home/addReply")
    public Result addReply(@RequestBody Comment comment) {
        commentService.addComment(comment);
        return ResultFactory.buildSuccessResult(null);
    }

    @ResponseBody
    @GetMapping(value = "/api/admin/comments")
    public Result findAllComment() {
        List<Comment> list = commentService.findAll();
        return ResultFactory.buildSuccessResult(list);
    }

    @ResponseBody
    @PutMapping("/api/admin/comment")
    public Result updateState(@RequestBody Comment comment) {
        commentService.updateState(comment);
        return ResultFactory.buildSuccessResult(null);

    }

    @ResponseBody
    @PostMapping("/api/admin/delete-comment")
    public Result deleteComment(@RequestBody Comment comment) {
        commentService.deleteComment(comment);
        return ResultFactory.buildSuccessResult(null);
    }
}
