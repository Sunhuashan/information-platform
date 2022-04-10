package com.shs.bysj.controller;

import com.shs.bysj.pojo.User;
import com.shs.bysj.result.Result;
import com.shs.bysj.result.ResultFactory;
import com.shs.bysj.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @Author: shs
 * @Data: 2022/4/6 12:55
 */
@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private IUserService userService;

    /**
     * 返回所有用户信息
     * @return
     */
    @ResponseBody
    @CrossOrigin
    @GetMapping(value = "/api/user/findAllUsers")
    public Result findAllUser() {
        try {
            List<User> userList = userService.findAllUser();
            return ResultFactory.buildSuccessResult(userList);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultFactory.buildFailResult(null);
        }
    }

    @ResponseBody
    @CrossOrigin
    @PostMapping(value = "/api/user/deleteUser")
    public Result deleteUser(@RequestBody User user) {
        String username = user.getUsername();
        try {
            userService.deleteByUsername(username);
            return ResultFactory.buildSuccessResult(null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultFactory.buildFailResult(null);
        }
    }
}
