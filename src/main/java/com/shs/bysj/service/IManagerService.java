package com.shs.bysj.service;

import com.shs.bysj.pojo.Manager;

import java.util.List;

public interface IManagerService {

    /**
     * 查找所有管理员
     * @return
     */
    public List<Manager> findAllManager();

    /**
     * 查找某管理员，通过id
     * @param id
     * @return
     */
    public Manager findManagerById(Long id);

    /**
     * 查找某个管理员，通过用户名
     */
    public Manager findManagerByManagerName(String name);
    /**
     * 添加某管理员
     * @param manager
     */
    public void addManager(Manager manager);

    /**
     * 删除某管理员
     * @param id
     */
    public void deleteManagerById(Long id);
    public void deleteManagerByManagerUsername(String name);
    /**
     * 判断是否存在某管理员，通过用户名
     * @param managerUsername
     * @return
     */
    public boolean isExist(String managerUsername);

}
