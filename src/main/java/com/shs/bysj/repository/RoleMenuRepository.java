package com.shs.bysj.repository;

import com.shs.bysj.pojo.RoleMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @Author: shs
 * @Data: 2022/3/29 19:01
 */
public interface RoleMenuRepository extends JpaRepository<RoleMenu, Long>, JpaSpecificationExecutor<RoleMenu> {
    public List<RoleMenu> findAllByRoleId(Long rid);
    public List<RoleMenu> findAllByRoleIdIn(List<Long> rids);
}

