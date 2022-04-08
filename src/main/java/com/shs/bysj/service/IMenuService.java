package com.shs.bysj.service;

import com.shs.bysj.pojo.Menu;

import java.util.List;

/**
 * @Author: shs
 * @Data: 2022/3/29 20:16
 */
public interface IMenuService {
    /**
     * 增加菜单信息
     */
    public void addMenu(Menu menu);
    /**
     * 删除菜单信息
     */
    public void deleteMenuById(Long id);
    public void deleteMenuByRoleName(String menuName);
    /**
     * 更新角色信息
     */
    public void updateMenu(Menu menu);
    /**
     * 查找角色信息
     */
    public Menu findMenuById(Long id);
    public Menu findRoleByMenuName(String roleName);
    public List<Menu> findAllMenu();
    public List<Menu> fingAllMenuByIds(List<Long> mids);
    public List<Menu> findAllMenuByParentId(Long pid);
}
