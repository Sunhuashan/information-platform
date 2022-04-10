package com.shs.bysj.controller;

import com.shs.bysj.pojo.Role;
import com.shs.bysj.result.Result;
import com.shs.bysj.result.ResultFactory;
import com.shs.bysj.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: shs
 * @Data: 2022/4/4 18:47
 */
@RestController
@CrossOrigin
public class RoleControllor {
    @Autowired
    private IRoleService roleService;

    @ResponseBody
    @GetMapping(value = "/api/admin/roles")
    public Result getAllBasicRoles() {
        try{
            List<Role> roleList = roleService.findAllRole();
            return ResultFactory.buildSuccessResult(roleList);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultFactory.buildFailResult(null);
        }

    }
}
