package com.shs.bysj.repository;

import com.shs.bysj.pojo.Publicity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @Author: shs
 * @Data: 2022/4/16 15:16
 */
public interface PublicityRepository extends JpaRepository<Publicity,Long>, JpaSpecificationExecutor<Publicity> {
    public List<Publicity> findAllByPubReleaseId(Long rid);
    public Publicity findPublicityById(Long id);
}
