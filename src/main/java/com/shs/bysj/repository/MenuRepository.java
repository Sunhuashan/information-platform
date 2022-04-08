package com.shs.bysj.repository;

import com.shs.bysj.pojo.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @Author: shs
 * @Data: 2022/3/29 19:00
 */
public interface MenuRepository extends JpaRepository<Menu,Long> , JpaSpecificationExecutor<Menu> {
    public void deleteByMenuName(String menuName);
    public Menu findByMenuName(String menuName);
    public List<Menu> findAllByIdIn(List<Long> mids);
    public List<Menu> findAllByMenuParentId(Long pid);
}
