package com.shs.bysj.repository;

import com.shs.bysj.pojo.MyFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @Author: shs
 * @Data: 2022/5/1 16:00
 */
public interface MyFileRepository extends JpaRepository<MyFile,Long>, JpaSpecificationExecutor<MyFile> {
    public MyFile findFileByName(String name);
    public List<MyFile> findAllByState(boolean s);
}
