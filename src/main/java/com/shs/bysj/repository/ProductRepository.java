package com.shs.bysj.repository;

import com.shs.bysj.pojo.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @Author: shs
 * @Data: 2022/4/18 13:39
 */
public interface ProductRepository extends JpaRepository<Product,Long>, JpaSpecificationExecutor<Product> {
    public List<Product> findAllByReleaseId(Long rid);
    public Product findProductById(Long id);
}
