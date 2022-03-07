package com.vedx.platform.service;

import java.util.Optional;

import com.vedx.platform.entity.Customer;
import com.vedx.platform.repository.CustomerRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepo customerRepo;
    @Override
    public Customer saveCustomer(Customer customer) {
    
        return customerRepo.save(customer);
    }

    @Override
    public Customer findCustomerById(String id) {
        Optional<Customer> result=customerRepo.findById(id);
        return result.orElse(null);
    }
    
    @Override
    public Customer updateCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    @Override
    public void deleteCustomer(Customer customer) {
         customerRepo.delete(customer);
    }

    @Override
    public Boolean isAlreadyRegister(Customer customer) {

        return customerRepo.findByUserName(customer.getUserName())!=null;
    }

   
    
}
