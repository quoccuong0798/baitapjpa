package com.example.baitapjpa.Service;

import com.example.baitapjpa.Repository.CustomerRepository;
import com.example.baitapjpa.Repository.OrderRepository;
import com.example.baitapjpa.Service.imp.OrderServiceImp;
import com.example.baitapjpa.entity.CustomerEntity;
import com.example.baitapjpa.entity.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements OrderServiceImp {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public String saveOrder(String orderCode, double totalAmount, int customerId) {
        OrderEntity order = new OrderEntity();
        order.setOrderCode(orderCode);
        order.setTotalAmount(totalAmount);
        String data="Thêm thất bại, giá trị Id không có";
        //kiểm tra xem id có tồn tại hay không
        CustomerEntity customer =customerRepository.findById(customerId).orElse(null);
        if (customer == null) {
            //xử lý
           //        throw new IllegalArgumentException("Customer not found for the provided ID.");
        } else {
            order.setCustomer(customer);
            orderRepository.save(order);
            data ="Thêm thành công";
        }

        //Lưu Vào Entity
        return data;

    }
}
