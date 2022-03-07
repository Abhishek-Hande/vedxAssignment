package com.vedx.platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.vedx.platform.config.EndPointConfig;
import com.vedx.platform.entity.Order;
import com.vedx.platform.service.OrderService;

@RestController
@RequestMapping(value = EndPointConfig.VERSION_1 + EndPointConfig.ORDERSERVICE)
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping(value = EndPointConfig.PLACE_ORDER, method = RequestMethod.POST, consumes = "application/json")
    ResponseEntity<Order>placeOrder(@PathVariable String Customer_id,@RequestBody Order order) throws Exception{

        if(order==null){
            throw new Exception("Invalid order Detalis"); 
        }

         Order result=orderService.placeOrderForCustomer(Customer_id,order);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }


    @RequestMapping(value = EndPointConfig.UPDATE_ORDER_STATUS, method = RequestMethod.PUT, consumes = "application/json")
    ResponseEntity<Order>updateOrderStatus(@PathVariable String order_id,@RequestBody String status) throws Exception{


         Order result=orderService.updateOrderStatus(order_id,status);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
    
    @RequestMapping(value = EndPointConfig.FEATCH_ALL_ORDERS, method = RequestMethod.GET, consumes = "application/json")
    ResponseEntity<List<Order>>getAllOrder() throws Exception{


         List<Order> result=orderService.getAllOrders();
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

}
