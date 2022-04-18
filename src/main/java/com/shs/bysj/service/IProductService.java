package com.shs.bysj.service;

import com.shs.bysj.pojo.Product;

import java.util.List;

/**
 * @Author: shs
 * @Data: 2022/4/18 13:41
 */
public interface IProductService {
    /**
     * 查找所有产品
     * @return
     */
    public List<Product> findAllProduct();

    /**
     * 根据发布人查找产品
     * @return
     */
    public List<Product> findAllProductById(Product product);
    /**
     * 添加产品
     * @param product
     */
    public void addProduct(Product product);
    /**
     * 删除产品
     */
    public void deleteById(Product product);

    /**
     * 更新产品
     * @param product
     */
    public void updateProduct(Product product);
}
