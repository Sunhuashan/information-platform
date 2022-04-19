package com.shs.bysj.controller;

import com.shs.bysj.pojo.Publicity;
import com.shs.bysj.result.Result;
import com.shs.bysj.result.ResultFactory;
import com.shs.bysj.service.impl.PublicityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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
    public Result addVideoPublicity(@RequestBody Publicity publicity) {
        publicityService.addPublicity(publicity);
        return ResultFactory.buildSuccessResult(null);
    }


    /**
     * 添加图片宣传内容
     * @param publicity
     * @return
     */
    @ResponseBody
    @PostMapping(value = "/api/admin/addImagePublicity")
    public Result addImagePublicity(@RequestBody Publicity publicity) {
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

    /**
     * 查找所有宣传内容以供审核
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/api/admin/findAllPublicty")
    public Result findAll() {
        List<Publicity> publicityList = publicityService.findAll();
        return ResultFactory.buildSuccessResult(publicityList);
    }

    /**
     * 更新审核状态
     * @param publicity
     * @return
     */
    @ResponseBody
    @PostMapping(value = "/api/admin/updatePublicityState")
    public Result updatePublicityState(@RequestBody Publicity publicity) {
        publicityService.updatePublicityState(publicity);
        return ResultFactory.buildSuccessResult(null);
    }

    /**
     * 删除宣传内容
     * @param publicity
     * @return
     */
    @ResponseBody
    @PostMapping(value = "/api/admin/deletePublicity")
    public Result deletePublicity(@RequestBody Publicity publicity) {
        publicityService.deletePublicity(publicity);
        return ResultFactory.buildSuccessResult(null);
    }


    /**
     * 查找所有通过审核的宣传内容，以供前台显示
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/api/home/findAllPub")
    public Result findAllByPubState() {
        List<Publicity> list = publicityService.findAllPublicityByState();
        return ResultFactory.buildSuccessResult(list);
    }
}
