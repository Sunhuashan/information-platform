package com.shs.bysj.service.impl;

import com.shs.bysj.pojo.Role;
import com.shs.bysj.repository.RoleRepository;
import com.shs.bysj.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @Author: shs
 * @Data: 2022/3/29 20:46
 */
@Service
public class RoleService implements IRoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public void addRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    public void deleteRoleById(Long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public void deleteRoleByRoleName(String roleName) {
        roleRepository.deleteByRoleName(roleName);
    }

    @Override
    public void updateRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    public Role findRoleById(Long id) {
        return roleRepository.getById(id);
    }

    @Override
    public Role findRoleByRoleName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }

    @Override
    public List<Role> findAllRole() {
        return roleRepository.findAll();
    }

    @Override
    public List<Role> findAllRoleByIds(List<Long> rids) {
        return roleRepository.findAllByIdIn(rids);
    }

}
