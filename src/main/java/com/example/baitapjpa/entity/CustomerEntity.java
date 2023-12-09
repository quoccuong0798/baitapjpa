package com.example.baitapjpa.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "customer")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name="email")
    private String email;
    @OneToMany(mappedBy = "customer")
    private List<OrderEntity> orders;







}
