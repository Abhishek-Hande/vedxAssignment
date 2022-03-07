package com.vedx.platform.service;

import com.vedx.platform.entity.Product;

public interface ProductService {
public Product saveProduct(Product product);
public Product updateProduct(Product product);
public void deleteProduct(Product product);
public Product findProductById(String id);
public boolean isProductRegistered(Product product);
    
}
