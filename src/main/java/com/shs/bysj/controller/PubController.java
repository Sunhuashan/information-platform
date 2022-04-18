package com.shs.bysj.controller;

import com.shs.bysj.pojo.Publicity;
import com.shs.bysj.result.Result;
import com.shs.bysj.result.ResultFactory;
import com.shs.bysj.service.impl.PublicityService;
import com.shs.bysj.utils.StringUtil;
import org.apache.tomcat.util.http.fileupload.impl.FileSizeLimitExceededException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

/**
 * @Author: shs
 * @Data: 2022/4/16 14:02
 */
@CrossOrigin
@RestController
public class PubController {

    @Autowired
    PublicityService publicityService;

    /**
     * 添加宣传视频
     * @param publicity
     * @return
     */
    @ResponseBody
    @PostMapping(value = "/api/admin/addVideoPublicity")
    public Result addPublicity(@RequestBody Publicity publicity) {
        publicityService.addPublicity(publicity);
        return ResultFactory.buildSuccessResult(null);
    }


    /**
     * 根据发布人查找发布内容
     * @param publicity
     * @return
     */
    @ResponseBody
    @PostMapping(value = "/api/admin/findAllPubByName")
    public Result findAllByReleaseName(@RequestBody Publicity publicity) {
        List<Publicity> publicityList = publicityService.findAllByReleaseName(publicity);
        return ResultFactory.buildSuccessResult(publicityList);
    }

    @ResponseBody
    @GetMapping(value = "/api/admin/findAllPublicty")
    public Result findAll() {
        List<Publicity> publicityList = publicityService.findAll();
        return ResultFactory.buildSuccessResult(publicityList);
    }

    @ResponseBody
    @PostMapping(value = "/api/admin/updatePublicityState")
    public Result updatePublicityState(@RequestBody Publicity publicity) {
        publicityService.updatePublicityState(publicity);
        return ResultFactory.buildSuccessResult(null);
    }

}
