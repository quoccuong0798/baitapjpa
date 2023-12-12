package com.example.baitapjpa.Repository;

import com.example.baitapjpa.entity.OrderEntity;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity,Integer> {
    List<OrderEntity> findByCustomer_Id(int Id);
    boolean existsByCustomer_Id(int id);

}
