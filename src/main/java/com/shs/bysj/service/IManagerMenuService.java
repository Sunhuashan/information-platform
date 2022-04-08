package com.shs.bysj.service;

import com.shs.bysj.pojo.Manager;
import com.shs.bysj.pojo.Menu;

import java.util.List;

/**
 * @Author: shs
 * @Data: 2022/3/29 19:12
 */
public interface IManagerMenuService {
    /**
     * 查找当前用户有权访问的菜单
     * @return
     */
    public List<Menu> getMenuByManager(Manager manager);
}
