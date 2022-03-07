package com.vedx.platform.service;

import java.util.List;

import com.vedx.platform.entity.Order;

public interface OrderService {

    public Order saveOrder(Order order);

    public Order findOrderById(String id);

    public Order updateOrder(Order order);

    public void deleteOrder(Order order);

    public  Order placeOrderForCustomer(String customer_id, Order order);

    public Order updateOrderStatus(String order_id, String status);

    public List<Order> getAllOrders();

}
