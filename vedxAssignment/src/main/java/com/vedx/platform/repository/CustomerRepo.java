package com.vedx.platform.repository;

import com.vedx.platform.entity.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepo extends JpaRepository<Customer, String> {

    @Query(nativeQuery = true, value = "SELECT * FROM customer " +
            "where user_Name = ?1 " )
    Customer findByUserName(String userName);

}
