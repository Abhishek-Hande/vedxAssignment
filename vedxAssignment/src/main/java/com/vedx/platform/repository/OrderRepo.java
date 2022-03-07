package com.vedx.platform.repository;

import com.vedx.platform.entity.Order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order,String> {

    
}
