package com.shs.bysj.controller;

import com.shs.bysj.pojo.Product;
import com.shs.bysj.result.Result;
import com.shs.bysj.result.ResultFactory;
import com.shs.bysj.service.IProductService;
import com.shs.bysj.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: shs
 * @Data: 2022/4/18 13:45
 */
@RestController
@CrossOrigin
public class ProductController {
    @Autowired
    IProductService productService;

    @ResponseBody
    @GetMapping(value = "/api/admin/findAllProduct")
    public Result findAllProduct() {
        List<Product> list = productService.findAllProduct();
        return ResultFactory.buildSuccessResult(list);
    }

    @ResponseBody
    @PostMapping(value = "/api/admin/findAllById")
    public Result findAllProductByRealseId(@RequestBody Product product) {
        List<Product> list = productService.findAllProductById(product);
        return ResultFactory.buildSuccessResult(list);
    }

    @ResponseBody
    @PostMapping(value = "/api/admin/addProduct")
    public Result addProduct(@RequestBody Product product) {
        productService.addProduct(product);
        return ResultFactory.buildSuccessResult(null);
    }

    @ResponseBody
    @PostMapping(value = "/api/admin/deleteById")
    public Result deleteById(@RequestBody Product product) {
        productService.deleteById(product);
        return ResultFactory.buildSuccessResult(null);
    }

    @ResponseBody
    @PostMapping(value = "/api/admin/updateProduct")
    public Result updateProduct(@RequestBody Product product) {
        productService.updateProduct(product);
        return ResultFactory.buildSuccessResult(null);
    }

    @ResponseBody
    @PostMapping(value = "/api/admin/updateProductState")
    public Result updateProductState(@RequestBody Product product) {
        productService.updateProductState(product);
        return ResultFactory.buildSuccessResult(null);
    }

    @ResponseBody
    @PutMapping(value = "/api/admin/product-check-info")
    public Result addCheckInfo(@RequestBody Product product) {
        productService.addCheckInfo(product);
        return ResultFactory.buildSuccessResult(null);
    }
}
