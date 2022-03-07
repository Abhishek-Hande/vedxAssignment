package com.vedx.platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.vedx.platform.config.EndPointConfig;
import com.vedx.platform.entity.Customer;
import com.vedx.platform.service.CustomerService;

@RestController
@RequestMapping(value = EndPointConfig.VERSION_1 + EndPointConfig.CUSTOMERSERVICE)
public class CustomerController {
    
    @Autowired
    CustomerService customerService;


    @RequestMapping(value = EndPointConfig.CREATE_CUSTOMER, method = RequestMethod.POST, consumes = "application/json")
    ResponseEntity<Customer>createCustomer(@RequestBody Customer customer) throws Exception{

        if(customer==null){
            throw new Exception("Customer must not be Empty");
        }
         
        if(customerService.isAlreadyRegister(customer)){
            throw new Exception("Customer Already present with this username: "+customer.getUserName());
        }
        
        Customer result=customerService.saveCustomer(customer);
        return new ResponseEntity<Customer>(result,HttpStatus.OK);
    }
}
