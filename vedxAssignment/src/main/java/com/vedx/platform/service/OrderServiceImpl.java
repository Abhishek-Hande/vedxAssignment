package com.vedx.platform.service;

import java.util.List;
import java.util.Optional;

import com.vedx.platform.entity.Customer;
import com.vedx.platform.entity.Order;
import com.vedx.platform.repository.CustomerRepo;
import com.vedx.platform.repository.OrderRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepo  orderRepo;

    @Autowired
    CustomerRepo customerRepo;

    @Override
    public Order saveOrder(Order order) {
        return orderRepo.save(order);
    }

    @Override
    public Order findOrderById(String id) {
        Optional<Order> result = orderRepo.findById(id);
        return result.orElse(null);
    }

    @Override
    public Order updateOrder(Order order) {
        return orderRepo.save(order);
    }

    @Override
    public void deleteOrder(Order order) {
        orderRepo.delete(order);
        
    }

    @Override
    public Order placeOrderForCustomer(String customer_id, Order order) {
        Customer customer=customerRepo.findById(customer_id).orElse(null);
        Order result=null;
        if(customer!=null){
            result=order;
            customer.getOrders().add(order);
            customerRepo.save(customer);
        }

        return result;
    }

    @Override
    public Order updateOrderStatus(String order_id, String status) {
       Order result= orderRepo.findById(order_id).orElse(null);
       if(result!=null){
           result.setStatus(status);
           orderRepo.save(result);
       }
        return result;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }
    
}
