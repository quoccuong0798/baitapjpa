package com.example.baitapjpa.Service.imp;

import com.example.baitapjpa.entity.OrderEntity;

public interface OrderServiceImp {
    String saveOrder(String orderCode, double totalAmount, int customerId );
}
