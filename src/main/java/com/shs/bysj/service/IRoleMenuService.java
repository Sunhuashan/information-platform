package com.shs.bysj.service;

import com.shs.bysj.pojo.ManagerRole;
import com.shs.bysj.pojo.Menu;
import com.shs.bysj.pojo.RoleMenu;

import java.util.List;

/**
 * @Author: shs
 * @Data: 2022/3/29 20:42
 */
public interface IRoleMenuService {
    /**
     * 通过角色查找所有菜单
     */
    public List<RoleMenu> findAllMenuByRoleId(Long rid);

    /**
     * 添加
     */
    public void addRoleMenu(RoleMenu roleMenu);
    /**
     * 通过多个角色查找所有菜单
     */
    public List<RoleMenu> findAllByRoleIdList(List<Long> rids);
}
