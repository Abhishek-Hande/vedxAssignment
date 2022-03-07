package com.vedx.platform.service;

import com.vedx.platform.entity.Customer;

public interface CustomerService {

    public Customer saveCustomer(Customer customer);

    public Customer updateCustomer(Customer customer);

    public void deleteCustomer(Customer customer);

    public Customer findCustomerById(String id);

    public Boolean isAlreadyRegister(Customer customer);
}