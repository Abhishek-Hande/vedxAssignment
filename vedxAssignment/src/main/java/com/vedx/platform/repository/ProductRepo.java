package com.vedx.platform.repository;

import com.vedx.platform.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepo extends JpaRepository<Product,String> {

    @Query(nativeQuery = true, value = "SELECT * FROM product " +
    "where product_Name = ?1 " )
    Product findByProductName(String name);
    
}
