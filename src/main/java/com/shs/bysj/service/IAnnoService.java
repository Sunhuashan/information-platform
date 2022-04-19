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
    public List<Announcement> findAllAnnoById(Manager manager);

    /**
     * 根据id删除公告
     */
    public void deleteAnnoById(Announcement announcement);

    /**
     * 添加新的公告
     * @param announcement
     */
    public void addAnno(Announcement announcement);

    /**
     * 修改公告信息
     * @param announcement
     */
    public void updateAnno(Announcement announcement);

    /**
     * 查找所有的公告信息
     * @return
     */
    public List<Announcement> findAll();

    /**
     * 更新公告审核状态
     * @param announcement
     */
    public void updateState(Announcement announcement);

    /**
     * 查找所有已审核通过的通知
     * @return
     */
    public List<Announcement> findAllAnnoByState();
}
