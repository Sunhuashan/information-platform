package com.shs.bysj.service.impl;

import com.shs.bysj.pojo.Announcement;
import com.shs.bysj.pojo.Manager;
import com.shs.bysj.repository.AnnoRepository;
import com.shs.bysj.repository.ManagerRepository;
import com.shs.bysj.service.IAnnoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author: shs
 * @Data: 2022/4/10 21:29
 */
public class AnnoService implements IAnnoService {
    @Autowired
    private ManagerRepository managerRepository;
    @Autowired
    private AnnoRepository annoRepository;
    @Override
    public List<Announcement> findAllAnno(Manager manager) {
        String name = manager.getManagerUsername();
        Long id = managerRepository.findManagerByManagerUsername(name).getId();


    }
}
