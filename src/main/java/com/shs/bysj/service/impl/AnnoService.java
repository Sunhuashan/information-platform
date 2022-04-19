package com.shs.bysj.service.impl;

import com.shs.bysj.pojo.Announcement;
import com.shs.bysj.pojo.Manager;
import com.shs.bysj.repository.AnnoRepository;
import com.shs.bysj.repository.ManagerRepository;
import com.shs.bysj.service.IAnnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Author: shs
 * @Data: 2022/4/10 21:29
 */
@Service
public class AnnoService implements IAnnoService {
    @Autowired
    private ManagerRepository managerRepository;
    @Autowired
    private AnnoRepository annoRepository;
    @Override
    public List<Announcement> findAllAnnoById(Manager manager) {
        String name = manager.getManagerUsername();
        Long id = managerRepository.findManagerByManagerUsername(name).getId();
        List<Announcement> list = annoRepository.findAllByAnnoReleaseId(id);
        for (Announcement anno : list) {
            if (anno.isAnnoState())
                anno.setAnnoCheckName(managerRepository.findManagerById(anno.getAnnoCheckId()).getManagerUsername());
        }
        return list;
    }

    @Override
    public void deleteAnnoById(Announcement announcement) {
        Long aid = announcement.getId();
        annoRepository.deleteById(aid);
    }

    @Override
    public void addAnno(Announcement announcement) {
        Date currentDate = new Date();
        java.sql.Date sqlDate = new java.sql.Date(currentDate.getTime());
        announcement.setAnnoDate(sqlDate);

        Long releaseId = managerRepository.findManagerByManagerUsername(announcement.getAnnoReleaseName()).getId();
        announcement.setAnnoReleaseId(releaseId);

        announcement.setAnnoState(false);

        annoRepository.save(announcement);
    }

    @Override
    public void updateAnno(Announcement announcement) {
        Date currentDate = new Date();
        java.sql.Date sqlDate = new java.sql.Date(currentDate.getTime());
        announcement.setAnnoDate(sqlDate);

        annoRepository.save(announcement);
    }

    @Override
    public List<Announcement> findAll() {
        List<Announcement> list = annoRepository.findAll();
        for (Announcement anno : list) {
            String name = managerRepository.findManagerById(anno.getAnnoReleaseId()).getManagerUsername();
            anno.setAnnoReleaseName(name);
        }
        return list;
    }

    @Override
    public void updateState(Announcement announcement) {
        Long id = announcement.getId();
        Announcement annoDB = annoRepository.findAnnouncementById(id);

        annoDB.setAnnoState(announcement.isAnnoState());
        annoDB.setAnnoCheckId(managerRepository.findManagerByManagerUsername(announcement.getAnnoCheckName()).getId());
        annoRepository.save(annoDB);
    }

    @Override
    public List<Announcement> findAllAnnoByState() {
        List<Announcement> list = annoRepository.findAllByAnnoState(true);
        Collections.sort(list, new Comparator<Announcement>() {
            @Override
            public int compare(Announcement o1, Announcement o2) {
                Long diff = o1.getId() - o2.getId();
                if (diff > 0)
                    return -1;
                else if (diff < 0)
                    return 1;
                return 0;
            }
        });
        return list;
    }


}
