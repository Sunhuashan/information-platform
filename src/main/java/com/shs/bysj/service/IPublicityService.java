package com.shs.bysj.service;

import com.shs.bysj.pojo.Publicity;

import java.util.List;

/**
 * @Author: shs
 * @Data: 2022/4/16 15:09
 */
public interface IPublicityService {
    /**
     * 添加新的宣传内容
     * @param publicity
     */
    public void addPublicity(Publicity publicity);

    /**
     * 根据发布人查找发布内容
     * @return
     */
    public List<Publicity> findAllByReleaseName(Publicity publicity);
}
