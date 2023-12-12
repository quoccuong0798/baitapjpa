package com.example.baitapjpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;
}
