package com.example.baitapjpa.controller;

import com.example.baitapjpa.Service.OrderService;
import com.example.baitapjpa.Service.imp.OrderServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    OrderServiceImp orderServiceImp;

    @PostMapping("/create")
    public ResponseEntity<?> createOrder(@RequestParam String oderCode, @RequestParam double totalAmount, @RequestParam int customerId) {
        return new ResponseEntity<>(orderServiceImp.saveOrder(oderCode,totalAmount,customerId), HttpStatus.OK);
    }
    @GetMapping("")
    public ResponseEntity<?> getOrdersByCustomerId(@RequestParam int customerId) {
        return new ResponseEntity<>(orderServiceImp.getOrdersByCustomerId(customerId), HttpStatus.OK);
    }
}
