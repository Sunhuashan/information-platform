package com.shs.bysj.repository;

import com.shs.bysj.pojo.ManagerRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: shs
 * @Data: 2022/3/29 19:01
 */
public interface ManagerRoleRepository extends JpaRepository<ManagerRole, Long>, JpaSpecificationExecutor<ManagerRole> {
    public List<ManagerRole> findAllByManagerId(Long id);
    @Transactional
    public void deleteAllByManagerId(Long mid);
}
