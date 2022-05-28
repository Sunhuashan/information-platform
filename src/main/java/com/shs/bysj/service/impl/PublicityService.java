package com.shs.bysj.service.impl;

import com.shs.bysj.pojo.Publicity;
import com.shs.bysj.repository.ManagerRepository;
import com.shs.bysj.repository.PublicityRepository;
import com.shs.bysj.service.IPublicityService;
import com.shs.bysj.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @Author: shs
 * @Data: 2022/4/16 15:15
 */
@Service
public class PublicityService implements IPublicityService {
    @Autowired
    ManagerRepository managerRepository;
    @Autowired
    PublicityRepository publicityRepository;
    @Override
    public void addPublicity(Publicity publicity) {
        Date current = new Date();
        java.sql.Date date = new java.sql.Date(current.getTime());
        publicity.setPubDate(date);

        Long releaseId = managerRepository.findManagerByManagerUsername(publicity.getPubReleaseName()).getId();
        publicity.setPubReleaseId(releaseId);

        publicityRepository.save(publicity);
    }

    @Override
    public List<Publicity> findAllByReleaseName(Publicity publicity) {
        Long rid = managerRepository.findManagerByManagerUsername(publicity.getPubReleaseName()).getId();
        List<Publicity> list = publicityRepository.findAllByPubReleaseId(rid);
        for(Publicity temp : list) {
            if (temp.getPubCheckId() != null)
                temp.setPubCheckName(managerRepository.findManagerById(temp.getPubCheckId()).getManagerUsername());
        }
        Collections.reverse(list);
        return list;
    }

    @Override
    public List<Publicity> findAll() {
        List<Publicity> publicityList = publicityRepository.findAll();
        for(Publicity publicity : publicityList) {
            Long rid = publicity.getPubReleaseId();
            publicity.setPubReleaseName(managerRepository.findManagerById(rid).getManagerUsername());
        }
        Collections.reverse(publicityList);
        return publicityList;
    }

    @Override
    public void updatePublicityState(Publicity publicity) {
        Publicity publicityDB = publicityRepository.findPublicityById(publicity.getId());
        publicityDB.setPubState(publicity.isPubState());

        Long checkId = managerRepository.findManagerByManagerUsername(publicity.getPubCheckName()).getId();

        publicityDB.setPubCheckId(checkId);

        publicityRepository.save(publicityDB);
    }

    @Override
    public void deletePublicity(Publicity publicity) {
        publicityRepository.deleteById(publicity.getId());
    }

    @Override
    public List<Publicity> findAllPublicityByState() {
        return publicityRepository.findAllByPubState(true);
    }

    @Override
    public void addCheckInfo(Publicity publicity) {
        Publicity publicityDB = publicityRepository.findPublicityById(publicity.getId());

        publicityDB.setPubDate(DateUtil.getSqlDate());
        publicityDB.setCheckInfo(publicity.getCheckInfo());
        publicityDB.setPubCheckId(managerRepository.findAllByManagerUsername(publicity.getPubCheckName()).getId());

        publicityRepository.save(publicityDB);
    }
}
