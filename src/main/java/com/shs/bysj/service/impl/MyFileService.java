package com.shs.bysj.service.impl;

import com.shs.bysj.exception.FilenameExistException;
import com.shs.bysj.pojo.MyFile;
import com.shs.bysj.repository.MyFileRepository;
import com.shs.bysj.service.IMyFileService;
import com.shs.bysj.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @Author: shs
 * @Data: 2022/5/1 15:56
 */
@Service
public class MyFileService implements IMyFileService {
    @Autowired
    MyFileRepository myFileRepository;
    @Override
    public void uploadFile(MultipartFile file, String uploadName) throws FilenameExistException, IOException {
        String filename = file.getOriginalFilename().toString();

        if (myFileRepository.findFileByName(filename) != null)
            throw new FilenameExistException("文件名已存在");

        File zipFolder = new File("E:/zip");
        File f = new File(zipFolder,filename);
        if (!f.getParentFile().exists()) {
            f.getParentFile().mkdirs();
        }
        file.transferTo(f);

        MyFile myFile = new MyFile();
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        myFile.setName(filename);
        myFile.setPath(f.getPath());
        myFile.setDate(sqlDate);
        myFile.setUploadName(uploadName);

        myFileRepository.save(myFile);
    }

    @Override
    public List<MyFile> findAllFileByState() {
        List<MyFile> list = myFileRepository.findAllByState(true);
        Collections.reverse(list);
        return list;
    }

    @Override
    public void updateFileState(MyFile myFile) {
        MyFile myFileDB = myFileRepository.findMyFileById(myFile.getId());

        myFileDB.setDate(DateUtil.getSqlDate());
        myFileDB.setState(myFile.isState());
        myFileDB.setCheckName(myFile.getCheckName());

        myFileRepository.save(myFileDB);
    }

    @Override
    public List<MyFile> findAllFile() {
        List<MyFile> list = myFileRepository.findAll();
        Collections.reverse(list);
        return list;
    }

    @Override
    public void addCheckInfo(MyFile myFile) {
        MyFile myFileDB = myFileRepository.findMyFileById(myFile.getId());

        myFileDB.setDate(DateUtil.getSqlDate());
        myFileDB.setCheckInfo(myFile.getCheckInfo());
        myFileDB.setCheckName(myFile.getCheckName());

        myFileRepository.save(myFileDB);
    }

    @Override
    public void deleteFileById(Long id) {
        MyFile myFile = myFileRepository.findMyFileById(id);
        String path = myFile.getPath();
        File file = new File(path);
        if (file.exists())
            file.delete();
        myFileRepository.deleteMyFileById(id);
    }
}
