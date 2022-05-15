package com.shs.bysj.controller;

import com.shs.bysj.pojo.Publicity;
import com.shs.bysj.pojo.Research;
import com.shs.bysj.result.Result;
import com.shs.bysj.result.ResultFactory;
import com.shs.bysj.service.IResearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: shs
 * @Data: 2022/4/18 16:25
 */
@RestController
@CrossOrigin
public class ResearchController {
    @Autowired
    IResearchService researchService;

    @ResponseBody
    @PostMapping(value = "/api/admin/addResearch")
    public Result addResearch(@RequestBody Research research) {
        researchService.addResearch(research);
        return ResultFactory.buildSuccessResult(null);
    }

    @ResponseBody
    @PostMapping("/api/admin/findAllResearchById")
    public Result findAllByReleaseId(@RequestBody Research research) {
        List<Research> list = researchService.findResearchByReleaseId(research);
        return ResultFactory.buildSuccessResult(list);
    }

    @ResponseBody
    @PostMapping(value = "/api/admin/deleteResearch")
    public Result deleteResearch(@RequestBody Research research) {
        researchService.deleteResearch(research);
        return ResultFactory.buildSuccessResult(null);
    }

    @ResponseBody
    @PostMapping(value = "/api/admin/updateResearch")
    public Result updateResearch(@RequestBody Research research) {
        researchService.updateResearch(research);
        return ResultFactory.buildSuccessResult(null);
    }

    @ResponseBody
    @GetMapping(value = "/api/admin/findAllResearch")
    public Result findAllResearch() {
        List<Research> list = researchService.findAllResearch();
        return ResultFactory.buildSuccessResult(list);
    }
    @ResponseBody
    @PostMapping(value = "/api/admin/updateResearchState")
    public Result updateResearchState(@RequestBody Research research) {
        researchService.updateResearchState(research);
        return ResultFactory.buildSuccessResult(null);
    }

    @ResponseBody
    @GetMapping(value = "/api/home/findAllResearch")
    public Result findAllResearchByState() {
        List<Research> list = researchService.findAllResearchByState();
        return ResultFactory.buildSuccessResult(list);
    }

    @ResponseBody
    @PutMapping(value = "/api/admin/research-check-info")
    public Result addCheckInfo(@RequestBody Research research) {
        researchService.addCheckInfo(research);
        return ResultFactory.buildSuccessResult(null);
    }
}
