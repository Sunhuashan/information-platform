package com.shs.bysj.service;

import com.shs.bysj.pojo.MyFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @Author: shs
 * @Data: 2022/5/1 15:39
 */
public interface IMyFileService {
    /**
     * 文件上传
     * @param file
     */
    public void uploadFile(MultipartFile file, String uploadName) throws IOException;


    /**
     * 查找所有审核通过的文件
     * @return
     */
    public List<MyFile> findAllFileByState();

    /**
     * 更新文件审核状态
     */
    public void updateFileState(MyFile myFile);

    /**
     * 查找所有文件，以供审核
     * @return
     */
    public List<MyFile> findAllFile();

    /**
     * 添加文件审核意见
     */
    public void addCheckInfo(MyFile myFile);

    /**
     * 删除文件
     * @param id
     */
    public void deleteFileById(Long id);
}
