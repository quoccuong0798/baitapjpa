package com.example.baitapjpa.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name="orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String orderCode;
    private double totalAmount;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;
}
