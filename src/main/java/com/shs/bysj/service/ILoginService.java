package com.shs.bysj.service;

import com.shs.bysj.pojo.User;

/**
 * @Author: shs
 * @Data: 2022/4/21 10:55
 */
public interface ILoginService {
    /**
     * 普通用户登录
     */
    public boolean login(User user);
}
