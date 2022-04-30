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

    /**
     * 根据用户名获取用户
     * @param user
     * @return
     */
    public User findUserByName(User user);

    /**
     * 检查密码是否正确
     * @param user
     * @return
     */
    public boolean checkPassword(User user);

    /**
     * 更新密码
     * @param user
     */
    public void setNewPassword(User user);

    /**
     * 更新用户信息
     * @param user
     */
    public void updateUser(User user);
}
