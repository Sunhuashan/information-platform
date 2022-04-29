package com.shs.bysj.controller;

import com.shs.bysj.pojo.Announcement;
import com.shs.bysj.pojo.News;
import com.shs.bysj.pojo.Research;
import com.shs.bysj.pojo.Search;
import com.shs.bysj.result.Result;
import com.shs.bysj.result.ResultFactory;
import com.shs.bysj.service.ISearchService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author: shs
 * @Data: 2022/4/27 9:20
 */
@CrossOrigin
@RestController
public class SearchController {
    @Autowired
    private ISearchService searchService;

    @ResponseBody
    @PostMapping(value = "/api/home/searchNews")
    public Result searchNews(@RequestBody Search search) {
        List<News> newsList = searchService.searchNews(search);
        if (newsList.size() == 0) {
            return ResultFactory.buildFailResult("内容为空");
        }
        return ResultFactory.buildSuccessResult(newsList);
    }


    @ResponseBody
    @PostMapping(value = "/api/home/searchAnno")
    public Result searchAnno(@RequestBody Search search) {
        List<Announcement> list = searchService.searchAnnouncement(search);
        if (list.size() == 0) {
            return ResultFactory.buildFailResult("内容为空");
        }
        return ResultFactory.buildSuccessResult(list);
    }

    @ResponseBody
    @PostMapping(value = "/api/home/searchResearch")
    public Result searchResearch(@RequestBody Search search) {
        List<Research> list = searchService.searchResearch(search);
        if (list.size() == 0) {
            return ResultFactory.buildFailResult("内容为空");
        }
        return ResultFactory.buildSuccessResult(list);
    }
}

