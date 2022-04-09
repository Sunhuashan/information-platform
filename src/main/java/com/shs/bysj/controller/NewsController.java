package com.shs.bysj.controller;

import com.shs.bysj.pojo.Manager;
import com.shs.bysj.pojo.News;
import com.shs.bysj.result.Result;
import com.shs.bysj.result.ResultFactory;
import com.shs.bysj.service.IManagerService;
import com.shs.bysj.service.INewsService;
import com.shs.bysj.utils.StringUtil;
import org.apache.tomcat.util.http.fileupload.impl.FileSizeLimitExceededException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
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


    /**
     * 保存图片到某目录下，并返回URL
     * @param file
     * @return
     */
    @CrossOrigin
    @ResponseBody
    @PostMapping(value = "/api/admin/save_image")
    public Result saveImage(MultipartFile file) {

        try {
            String typeName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.'));
            File imgFolder = new File("E:/image");
            String fileName = StringUtil.getRandomString(8) + typeName;
            File f = new File(imgFolder, fileName);
            if (!f.getParentFile().exists()) {
                f.getParentFile().mkdirs();
            }
            file.transferTo(f);
            String url = "http://localhost:8443/api/file/" + f.getName();
            return ResultFactory.buildSuccessResult(url);

        } catch (FileSizeLimitExceededException e) {
            e.printStackTrace();
            return ResultFactory.buildFailResult("图片大小超过1MB");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultFactory.buildFailResult("图片上传失败,请尝试重新上传！");
        }
    }

    /**
     * 添加新闻
     * @param news
     * @return
     */
    @CrossOrigin
    @ResponseBody
    @PostMapping(value = "/api/admin/addNews")
    public Result addNews(@RequestBody News news) {
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        news.setNewsDate(sqlDate);
        Long releaseId = managerService.findManagerByManagerName(news.getNewsReleaseName()).getId();
        news.setNewsReleaseId(releaseId);
        news.setNewsState(false);
        try {
            newsService.addNews(news);
            return ResultFactory.buildSuccessResult(null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultFactory.buildFailResult("新闻发布失败");
        }
    }

    /**
     * 根据图片URL，删除文件
     * @param url
     * @return
     */
    @CrossOrigin
    @ResponseBody
    @PostMapping(value = "/api/admin/removeImage")
    public Result deleteImageByUrl(@RequestBody String url) {
        String fileName = url.substring(url.lastIndexOf('/') + 1,url.length() - 2);
        try {
            File file = new File("E:/image/" + fileName);
            file.delete();
            return ResultFactory.buildSuccessResult(null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultFactory.buildFailResult("文件删除失败");
        }
    }

    /**
     * 查找全部新闻
     * @return
     */
    @CrossOrigin
    @ResponseBody
    @GetMapping(value = "/api/admin/findNews")
    public Result findAllNews(){
        try {
            List<News> newsList = newsService.findAll();
            for (News news : newsList) {
                String name = managerService.findManagerById(news.getNewsReleaseId()).getManagerUsername();
                news.setNewsReleaseName(name);
            }
            return ResultFactory.buildSuccessResult(newsList);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultFactory.buildFailResult("查找全部新闻失败");
        }
    }
}
