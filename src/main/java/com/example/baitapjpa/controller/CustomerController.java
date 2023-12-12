package com.example.baitapjpa.controller;

import com.example.baitapjpa.Repository.CustomerRepository;
import com.example.baitapjpa.Service.imp.CustomerServiceImp;
import com.example.baitapjpa.entity.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    private CustomerServiceImp customerServiceImp;
    @Autowired
    CustomerRepository customerRepository;

    @PostMapping("/add")
    public ResponseEntity<?> addCustomer(@RequestParam String name, @RequestParam String email) {
        System.out.println("Trước hàm");
        customerServiceImp.save(name, email);
        System.out.println("Có vào không thì bảo");

        return new ResponseEntity<>("Thêm thành công", HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<?> getAllCustomers() {
        List<CustomerEntity> list = customerRepository.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/id")
    public ResponseEntity<?> getById(@RequestParam int id) {
        //cách 1:
        //orElseThrow để ném một exception nếu không tìm thấy khách hàng:
        /*CustomerEntity customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Không tìm thấy khách hàng"));
        return new ResponseEntity<>(customer, HttpStatus.OK);*/
        Optional<CustomerEntity> optionalCustomer = customerRepository.findById(id);
        //cách 2
        if (optionalCustomer.isPresent()) {
            CustomerEntity customer = optionalCustomer.get();
            // Thực hiện các thao tác với customer
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } else {
            // Xử lý khi không tìm thấy customer
            return new ResponseEntity<>("Không tìm thấy khách hàng", HttpStatus.NOT_FOUND);
        }
    }




}
