package com.shs.bysj.service;

import com.shs.bysj.pojo.User;

import java.util.List;

/**
 * @Author: shs
 * @Data: 2022/4/6 12:49
 */
public interface IUserService {

    /**
     * 查询用户信息
     */
    public List<User> findAllUser();


    /**
     * 删除用户信息
     */
    public void deleteByUsername(String name);
}
