package com.shs.bysj.service;

import com.shs.bysj.pojo.Role;

import java.util.List;
import java.util.Optional;

/**
 * @Author: shs
 * @Data: 2022/3/29 20:06
 */
public interface IRoleService {
    /**
     * 增加角色信息
     */
    public void addRole(Role role);
    /**
     * 删除角色信息
     */
    public void deleteRoleById(Long id);
    public void deleteRoleByRoleName(String roleName);
    /**
     * 更新角色信息
     */
    public void updateRole(Role role);
    /**
     * 查找角色信息
     * @return
     */
    public Role findRoleById(Long id);
    public Role findRoleByRoleName(String roleName);
    public List<Role> findAllRole();
    public List<Role> findAllRoleByIds(List<Long> rids);

}
