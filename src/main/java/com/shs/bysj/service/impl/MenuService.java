package com.shs.bysj.service.impl;

import com.shs.bysj.pojo.Menu;
import com.shs.bysj.repository.MenuRepository;
import com.shs.bysj.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: shs
 * @Data: 2022/3/30 9:39
 */
@Service
public class MenuService implements IMenuService {
    @Autowired
    private MenuRepository menuRepository;
    @Override
    public void addMenu(Menu menu) {
        menuRepository.save(menu);
    }

    @Override
    public void deleteMenuById(Long id) {
        menuRepository.deleteById(id);
    }

    @Override
    public void deleteMenuByRoleName(String menuName) {
        menuRepository.deleteByMenuName(menuName);
    }

    @Override
    public void updateMenu(Menu menu) {
        menuRepository.save(menu);
    }

    @Override
    public Menu findMenuById(Long id) {
        return menuRepository.getById(id);
    }

    @Override
    public Menu findRoleByMenuName(String menuName) {
        return menuRepository.findByMenuName(menuName);
    }

    @Override
    public List<Menu> findAllMenu() {
        return menuRepository.findAll();
    }

    @Override
    public List<Menu> fingAllMenuByIds(List<Long> mids) {
        return menuRepository.findAllByIdIn(mids);
    }

    @Override
    public List<Menu> findAllMenuByParentId(Long pid) {
        return menuRepository.findAllByMenuParentId(pid);
    }
}
