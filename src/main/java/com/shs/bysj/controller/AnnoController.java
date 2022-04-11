package com.shs.bysj.controller;

import com.shs.bysj.pojo.Announcement;
import com.shs.bysj.pojo.Manager;
import com.shs.bysj.result.Result;
import com.shs.bysj.result.ResultFactory;
import com.shs.bysj.service.IAnnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: shs
 * @Data: 2022/4/11 14:22
 */
@RestController
public class AnnoController {
    @Autowired
    private IAnnoService annoService;

    @CrossOrigin
    @ResponseBody
    @PostMapping(value = "/api/admin/findAllAnno")
    public Result findAllAnnoById(@RequestBody Manager manager) {
        return ResultFactory.buildSuccessResult(annoService.findAllAnnoById(manager));
    }


    @CrossOrigin
    @ResponseBody
    @PostMapping(value = "/api/admin/deleteAnno")
    public Result deleteAnnoById(@RequestBody Announcement announcement) {
        annoService.deleteAnnoById(announcement);
        return ResultFactory.buildSuccessResult(null);
    }


    @CrossOrigin
    @ResponseBody
    @PostMapping(value = "/api/admin/addAnno")
    public Result addAnno(@RequestBody Announcement announcement) {
        annoService.addAnno(announcement);
        return ResultFactory.buildSuccessResult(null);
    }

    @CrossOrigin
    @ResponseBody
    @PostMapping(value = "/api/admin/updateAnno")
    public Result updateAnno(@RequestBody Announcement announcement) {
        annoService.updateAnno(announcement);
        return ResultFactory.buildSuccessResult(null);
    }

    @CrossOrigin
    @ResponseBody
    @GetMapping(value = "/api/admin/findAll")
    public Result findAll() {
        List<Announcement> annoList = annoService.findAll();
        return ResultFactory.buildSuccessResult(annoList);
    }

    @CrossOrigin
    @ResponseBody
    @PostMapping(value = "/api/admin/updateAnnoState")
    public Result updateState(@RequestBody Announcement announcement) {
        annoService.updateState(announcement);
        return ResultFactory.buildSuccessResult(null);
    }
}
