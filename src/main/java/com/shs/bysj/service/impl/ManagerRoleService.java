package com.shs.bysj.service.impl;

import com.shs.bysj.pojo.ManagerRole;
import com.shs.bysj.pojo.Role;
import com.shs.bysj.repository.ManagerRoleRepository;
import com.shs.bysj.service.IManagerRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: shs
 * @Data: 2022/3/29 20:45
 */
@Service
public class ManagerRoleService implements IManagerRoleService {

    @Autowired
    private ManagerRoleRepository managerRoleRepository;
    @Autowired
    private RoleService roleService;

    @Override
    public List<ManagerRole> findAllByManagerId(Long id) {
        return managerRoleRepository.findAllByManagerId(id);
    }

    @Override
    public void deleteAllByManagerId(Long mid) {
        managerRoleRepository.deleteAllByManagerId(mid);
    }

    @Override
    public void addManagerRole(ManagerRole managerRole) {
        managerRoleRepository.save(managerRole);
    }

    @Override
    public void addAllManagerRole(List<ManagerRole> managerRoles) {
        managerRoleRepository.saveAll(managerRoles);
    }
}
