package com.shs.bysj.service;

import com.shs.bysj.pojo.News;
import com.shs.bysj.pojo.Research;

import java.util.List;

/**
 * @Author: shs
 * @Data: 2022/4/18 16:10
 */
public interface IResearchService {
    /**
     * 添加科研信息
     * @param research
     */
    public void addResearch(Research research);

    /**
     * 查找所有科研信息
     * @return
     */
    public List<Research> findAllResearch();

    /**
     * 根据发布人查找科研信息
     * @return
     */
    public List<Research> findResearchByReleaseId(Research research);

    /**
     * 删除科研信息
     * @param research
     */
    public void deleteResearch(Research research);

    /**
     * 更新科研信息
     * @param research
     */
    public void updateResearch(Research research);

    /**
     * 更新科研信息审核状态
     * @param research
     */
    public void updateResearchState(Research research);

    /**
     * 查询所有已经被审核通过的科研信息
     * @return
     */
    public List<Research> findAllResearchByState();

    /**
     * 添加审核意见
     */
    public void addCheckInfo(Research research);
}
