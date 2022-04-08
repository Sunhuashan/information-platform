package com.shs.bysj.controller;

import com.shs.bysj.pojo.Manager;
import com.shs.bysj.pojo.News;
import com.shs.bysj.result.Result;
import com.shs.bysj.result.ResultFactory;
import com.shs.bysj.service.IManagerService;
import com.shs.bysj.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Author: shs
 * @Data: 2022/4/7 14:02
 */
@Controller
public class NewsController {
    @Autowired
    INewsService newsService;
    @Autowired
    IManagerService managerService;

    /**
     * 根据发布人的用户名查找新闻
     * @param manager
     * @return
     */
    @CrossOrigin
    @ResponseBody
    @PostMapping(value = "/api/admin/findNewsByName")
    public Result findAllNewsByName(@RequestBody Manager manager) {
        String name = manager.getManagerUsername();
        try {
            Long newsReleaseId =  managerService.findManagerByManagerName(name).getId();
            List<News> newsList = newsService.findAllByReleaseId(newsReleaseId);


            //此处日后可添加对新闻的排序


            return ResultFactory.buildSuccessResult(newsList);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultFactory.buildFailResult("查找失败");
        }
    }


    /**
     * 根据新闻的id删除新闻
     * @param news
     * @return
     */
    @CrossOrigin
    @ResponseBody
    @PostMapping(value = "/api/admin/deleteNews")
    public Result deleteNewsById(@RequestBody News news) {
        Long id = news.getId();
        try {
            newsService.deleteById(id);
            return ResultFactory.buildSuccessResult(null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultFactory.buildFailResult("删除失败");
        }
    }

    public Result saveImage(MultipartFile file) {
            String folder = "";
            return null;
    }
}
