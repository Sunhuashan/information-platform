package com.shs.bysj.service.impl;

import com.shs.bysj.pojo.*;
import com.shs.bysj.repository.*;
import com.shs.bysj.service.IManagerMenuService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: shs
 * @Data: 2022/3/29 19:17
 */
@Service
public class ManagerMenuService implements IManagerMenuService {
    @Autowired
    private ManagerService managerService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private ManagerRoleService managerRoleService;
    @Autowired
    private RoleMenuService roleMenuService;
    @Autowired
    private MenuService menuService;
    @Override
    public List<Menu> getMenuByManager(Manager manager) {
        //获取当前管理员
        //String managerName = SecurityUtils.getSubject().getPrincipal().toString();
        String managerName = manager.getManagerUsername();
        //String managerName = "bob";
        System.out.println(managerName);

        Manager currentManager = managerService.findManagerByManagerName(managerName);
        //获取角色列表
        List<Long> rids = managerRoleService.findAllByManagerId(currentManager.getId())
                .stream().map(ManagerRole::getRoleId).distinct().collect(Collectors.toList());

        List<Long> mids = roleMenuService.findAllByRoleIdList(rids).stream().map(RoleMenu::getMenuId)
                .collect(Collectors.toList());

        List<Menu> menuList = menuService.fingAllMenuByIds(mids);
/*
        //构造树形结构
        for (Menu menu : menuList) {
            menu.setChildren(menuService.findAllMenuByParentId(menu.getId()));
        }
        Iterator<Menu> iterator = menuList.iterator();
        while (iterator.hasNext()) {
            Menu menu = iterator.next();
            if (menu.getMenuParentId() != null) {
                iterator.remove();
            }
        }
 */
        for(int i = 0; i < menuList.size(); i++) {
            List<Menu> mList = new ArrayList<>();
            Menu menu = menuList.get(i);
            for(int j = 0; j < menuList.size(); j++) {
                Menu menu1 = menuList.get(j);
                if(menu1.getMenuParentId() == menu.getId())
                    mList.add(menuList.get(j));
            }
            System.out.println(mList);
            menuList.get(i).setChildren(mList);
        }
        Iterator<Menu> iterator = menuList.iterator();
        while (iterator.hasNext()) {
            Menu menu = iterator.next();
            if (menu.getMenuParentId() != null) {
                iterator.remove();
            }
        }
        return menuList;
    }
}
