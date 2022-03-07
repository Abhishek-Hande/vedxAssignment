package com.vedx.platform.controller;

import com.vedx.platform.config.EndPointConfig;
import com.vedx.platform.entity.Product;
import com.vedx.platform.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = EndPointConfig.VERSION_1 + EndPointConfig.PRODUCTSERVISE)
public class ProductController {
    
    @Autowired 
    ProductService productService;
    @RequestMapping(value = EndPointConfig.CREATE_PRODUCT, method = RequestMethod.POST, consumes = "application/json")
    ResponseEntity<Product>createProduct(@RequestBody Product product) throws Exception{

        if(product==null){
            throw new Exception("product must not be Empty");
        }
         
        if(productService.isProductRegistered(product)){
            throw new Exception("Product Already present on this platform with name "+product.getName());
        }
        
        Product result=productService.saveProduct(product);
        return new ResponseEntity<Product>(result,HttpStatus.OK);
    }
}
