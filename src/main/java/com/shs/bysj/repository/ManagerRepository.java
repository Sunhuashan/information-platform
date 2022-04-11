package com.shs.bysj.repository;

import com.shs.bysj.pojo.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.transaction.annotation.Transactional;

public interface ManagerRepository extends JpaRepository<Manager,Long> , JpaSpecificationExecutor<Manager> {

    public Manager findManagerById(Long id);
    public Manager findAllByManagerUsername(String name);
    public Manager findManagerByManagerUsername(String name);
    @Transactional
    public void deleteByManagerUsername(String name);
}
