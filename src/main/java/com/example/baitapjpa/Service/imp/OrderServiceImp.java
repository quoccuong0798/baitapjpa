package com.example.baitapjpa.Service.imp;

import com.example.baitapjpa.entity.OrderEntity;

import java.util.List;

public interface OrderServiceImp {
    String saveOrder(String orderCode, double totalAmount, int customerId );
    List<OrderEntity> getOrdersByCustomerId(int customerId);
}
