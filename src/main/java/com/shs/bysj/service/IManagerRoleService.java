package com.shs.bysj.service;

import com.shs.bysj.pojo.Manager;
import com.shs.bysj.pojo.ManagerRole;

import java.util.List;

/**
 * @Author: shs
 * @Data: 2022/3/29 20:26
 */
public interface IManagerRoleService {
    /**
     * 查找管理员拥有角色
     */
    public List<ManagerRole> findAllByManagerId(Long id);

    /**
     * 删除管理员所有角色
     */
    public void deleteAllByManagerId(Long mid);

    /**
     * 添加管理员角色
     */
    public void addManagerRole(ManagerRole managerRole);
    public void addAllManagerRole(List<ManagerRole> managerRoles);
}
