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

    @ResponseBody
    @PostMapping(value = "/api/home/findUserByName")
    public Result findUserByName(@RequestBody User user) {
        User userDB = userService.findUserByName(user);
        return ResultFactory.buildSuccessResult(userDB);
    }

    @ResponseBody
    @PostMapping(value = "/api/home/updatePassword")
    public Result updatePassword(@RequestBody User user) {
        if (userService.checkPassword(user)) {
            userService.setNewPassword(user);
            return ResultFactory.buildSuccessResult(null);
        }
        else {
            return ResultFactory.buildFailResult("旧密码错误！请重新输入");
        }
    }

    @ResponseBody
    @PostMapping(value = "/api/home/updateUser")
    public Result updateUser(@RequestBody User user) {
        System.out.println(user);
        userService.updateUser(user);
        return ResultFactory.buildSuccessResult(null);
    }

}
