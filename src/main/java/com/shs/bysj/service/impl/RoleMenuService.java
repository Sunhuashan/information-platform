package com.shs.bysj.service.impl;

import com.shs.bysj.pojo.ManagerRole;
import com.shs.bysj.pojo.Menu;
import com.shs.bysj.pojo.RoleMenu;
import com.shs.bysj.repository.RoleMenuRepository;
import com.shs.bysj.service.IRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: shs
 * @Data: 2022/3/30 10:41
 */
@Service
public class RoleMenuService implements IRoleMenuService {
    @Autowired
    private RoleMenuRepository roleMenuRepository;
    @Autowired
    private MenuService menuService;
    @Override
    public List<RoleMenu> findAllMenuByRoleId(Long rid) {
        List<RoleMenu> rMList = roleMenuRepository.findAllByRoleId(rid);

        return rMList;
    }

    @Override
    public void addRoleMenu(RoleMenu roleMenu) {
        roleMenuRepository.save(roleMenu);
    }

    @Override
    public List<RoleMenu> findAllByRoleIdList(List<Long> rids) {
        return roleMenuRepository.findAllByRoleIdIn(rids);
    }

}

