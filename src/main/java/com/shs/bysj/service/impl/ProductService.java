package com.shs.bysj.service.impl;

import com.shs.bysj.pojo.Product;
import com.shs.bysj.repository.ManagerRepository;
import com.shs.bysj.repository.ProductRepository;
import com.shs.bysj.service.IProductService;
import com.shs.bysj.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @Author: shs
 * @Data: 2022/4/18 13:44
 */
@Service
public class ProductService implements IProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ManagerRepository managerRepository;
    @Override
    public List<Product> findAllProduct() {

        List<Product> list = productRepository.findAll();
        for (Product product : list) {
            product.setReleaseName(managerRepository.findManagerById(product.getReleaseId()).getManagerUsername());
        }
        Collections.reverse(list);
        return list;
    }

    @Override
    public List<Product> findAllProductById(Product product) {
        Long releaseId = managerRepository.findManagerByManagerUsername(product.getReleaseName()).getId();
        List<Product> list = productRepository.findAllByReleaseId(releaseId);
        for (Product temp : list)
            if (temp.getCheckId() != null)
                temp.setCheckName(managerRepository.findManagerById(temp.getCheckId()).getManagerUsername());
        Collections.reverse(list);
        return list;
    }

    @Override
    public void addProduct(Product product) {
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        product.setDate(sqlDate);

        Long releaseId = managerRepository.findManagerByManagerUsername(product.getReleaseName()).getId();
        product.setReleaseId(releaseId);

        productRepository.save(product);
    }

    @Override
    public void deleteById(Product product) {
        productRepository.deleteById(product.getId());
    }

    @Override
    public void updateProduct(Product product) {
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        product.setDate(sqlDate);

        productRepository.save(product);
    }

    @Override
    public void updateProductState(Product product) {
        Product productDB = productRepository.findProductById(product.getId());
        productDB.setState(product.isState());

        Long checkId = managerRepository.findManagerByManagerUsername(product.getCheckName()).getId();
        productDB.setCheckId(checkId);

        productRepository.save(productDB);
    }

    @Override
    public void addCheckInfo(Product product) {
        Product productDB = productRepository.findProductById(product.getId());

        productDB.setDate(DateUtil.getSqlDate());
        productDB.setCheckId(managerRepository.findManagerByManagerUsername(product.getCheckName()).getId());
        productDB.setCheckInfo(product.getCheckInfo());

        productRepository.save(productDB);
    }
}
