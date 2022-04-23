package com.shs.bysj.controller;

import com.shs.bysj.pojo.User;
import com.shs.bysj.result.Result;
import com.shs.bysj.result.ResultFactory;
import com.shs.bysj.service.ILoginService;
import com.shs.bysj.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Column;

/**
 * @Author: shs
 * @Data: 2022/4/21 10:53
 */
@CrossOrigin
@RestController
public class LoginController {
    @Autowired
    ILoginService loginService;
    @ResponseBody
    @PostMapping(value = "/api/home/login")
    public Result login(@RequestBody User user) {
        if (loginService.login(user))
            return ResultFactory.buildSuccessResult(null);
        else
            return ResultFactory.buildFailResult("用户名或密码错误");
    }

}
