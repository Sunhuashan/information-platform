package com.shs.bysj.service.impl;


import com.shs.bysj.pojo.Manager;
import com.shs.bysj.repository.ManagerRepository;
import com.shs.bysj.service.IManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ManagerService implements IManagerService {

    @Autowired
    private ManagerRepository managerRepository;


    @Override
    public List<Manager> findAllManager(){
        return managerRepository.findAll();
    }

    @Override
    public Manager findManagerById(Long id){
        return managerRepository.getById(id);
    }

    @Override
    public Manager findManagerByManagerName(String name) {
        return managerRepository.findManagerByManagerUsername(name);
    }

    @Override
    public void addManager(Manager manager){
        managerRepository.save(manager);
    }

    @Override
    public void deleteManagerById(Long id) {

    }

    @Override
    public void deleteManagerByManagerUsername(String name) {
        managerRepository.deleteByManagerUsername(name);
    }

    @Override
    public boolean isExist(String managerUsername) {
        if(managerRepository.findAllByManagerUsername(managerUsername) == null) {
            return false;
        } else {
            return true;
        }
    }



}
