package com.shs.bysj.repository;

import com.shs.bysj.pojo.Role;
import com.shs.bysj.pojo.RoleMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @Author: shs
 * @Data: 2022/3/29 19:00
 */
public interface RoleRepository extends JpaRepository<Role, Long>, JpaSpecificationExecutor<Role> {
    public void deleteByRoleName(String roleName);
    public Role findByRoleName(String roleName);
    public List<Role> findAllByIdIn(List<Long> rids);
}
