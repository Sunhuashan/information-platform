package com.shs.bysj.repository;

import com.shs.bysj.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: shs
 * @Data: 2022/4/6 12:47
 */
public interface UserRepository extends JpaRepository<User,Long>, JpaSpecificationExecutor<User> {
    @Transactional
    public void deleteUserByUsername(String name);
}
