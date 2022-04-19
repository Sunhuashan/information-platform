package com.shs.bysj.service.impl;

import com.shs.bysj.pojo.Research;
import com.shs.bysj.repository.ManagerRepository;
import com.shs.bysj.repository.ResearchRepository;
import com.shs.bysj.service.IResearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * @Author: shs
 * @Data: 2022/4/18 16:17
 */
@Service
public class ResearchService implements IResearchService {
    @Autowired
    ResearchRepository researchRepository;
    @Autowired
    ManagerRepository managerRepository;
    @Override
    public void addResearch(Research research) {
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        research.setDate(sqlDate);

        Long releaseId = managerRepository.findManagerByManagerUsername(research.getReleaseName()).getId();
        research.setReleaseId(releaseId);

        researchRepository.save(research);
    }

    @Override
    public List<Research> findAllResearch() {

        List<Research> list = researchRepository.findAll();
        for (Research research : list) {
            research.setReleaseName(managerRepository.findManagerById(research.getReleaseId()).getManagerUsername());
        }
        return list;
    }

    @Override
    public List<Research> findResearchByReleaseId(Research research) {
        Long releaseId = managerRepository.findManagerByManagerUsername(research.getReleaseName()).getId();
        List<Research> list = researchRepository.findAllByReleaseId(releaseId);
        for (Research temp : list)
            if (temp.isState())
                temp.setCheckName(managerRepository.findManagerById(temp.getCheckId()).getManagerUsername());
        return list;
    }

    @Override
    public void deleteResearch(Research research) {
        researchRepository.deleteById(research.getId());
    }

    @Override
    public void updateResearch(Research research) {
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        research.setDate(sqlDate);

        researchRepository.save(research);
    }

    @Override
    public void updateResearchState(Research research) {
        Research researchDB = researchRepository.findResearchById(research.getId());
        researchDB.setState(research.isState());

        Long checkId = managerRepository.findManagerByManagerUsername(research.getCheckName()).getId();

        researchDB.setCheckId(checkId);
        researchRepository.save(researchDB);
    }

    @Override
    public List<Research> findAllResearchByState() {
        List<Research> list = researchRepository.findAllByState(true);
        Collections.sort(list, new Comparator<Research>() {
            @Override
            public int compare(Research o1, Research o2) {
                Long diff = o1.getId() - o2.getId();
                if (diff > 0)
                    return 1;
                if (diff < 0)
                    return -1;
                return 0;
            }
        });
        return list;
    }
}
