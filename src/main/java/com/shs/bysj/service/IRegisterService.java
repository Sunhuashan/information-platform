package com.shs.bysj.service;

import com.shs.bysj.pojo.User;

/**
 * @Author: shs
 * @Data: 2022/4/22 11:28
 */
public interface IRegisterService {
    /**
     * 用户名是否存在
     * @param user
     * @return
     */
    public boolean isExist(User user);

    /**
     * 添加新的用户
     * @param user
     */
    public void addUser(User user);
}
