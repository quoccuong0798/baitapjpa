package com.example.baitapjpa.Service;

import com.example.baitapjpa.Repository.CustomerRepository;
import com.example.baitapjpa.Service.imp.CustomerServiceImp;
import com.example.baitapjpa.entity.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements CustomerServiceImp {
    @Autowired
    CustomerRepository customerRepository;
    @Override
    public void save(String name, String email) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setName(name);
        customerEntity.setEmail(email);
        customerRepository.save(customerEntity);
        System.out.println(customerEntity);

    }
}
