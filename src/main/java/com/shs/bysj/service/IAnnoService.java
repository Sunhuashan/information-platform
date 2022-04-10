package com.shs.bysj.service;

import com.shs.bysj.pojo.Announcement;
import com.shs.bysj.pojo.Manager;
import java.util.List;

/**
 * @Author: shs
 * @Data: 2022/4/10 21:28
 */
public interface IAnnoService {
    /**
     * 根据发布人获取所有公告
     * @return
     */
    public List<Announcement> findAllAnno(Manager manager);
}
