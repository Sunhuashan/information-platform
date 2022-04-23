package com.shs.bysj.controller;

import com.shs.bysj.pojo.User;
import com.shs.bysj.result.Result;
import com.shs.bysj.result.ResultFactory;
import com.shs.bysj.service.IRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: shs
 * @Data: 2022/4/22 11:24
 */
@RestController
@CrossOrigin
public class RegisterController {
    @Autowired
    IRegisterService registerService;
    @ResponseBody
    @PostMapping(value = "/api/home/register")
    public Result register(@RequestBody User user) {
        if (registerService.isExist(user))
            return ResultFactory.buildFailResult("用户名已存在！");
        try {
            registerService.addUser(user);
            return ResultFactory.buildSuccessResult(null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultFactory.buildFailResult("注册失败，请重试！");
        }
    }
}
