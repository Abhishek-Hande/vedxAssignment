package com.vedx.platform.service;

import java.util.Optional;

import com.vedx.platform.entity.Product;
import com.vedx.platform.repository.ProductRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepo productRepo;

    @Override
    public Product saveProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product findProductById(String id) {
        Optional<Product> result = productRepo.findById(id);
        return result.orElse(null);
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public void deleteProduct(Product product) {
        productRepo.delete(product);
    }

    @Override
    public boolean isProductRegistered(Product product) {
        
        return productRepo.findByProductName(product.getName())!=null;
    }

}
