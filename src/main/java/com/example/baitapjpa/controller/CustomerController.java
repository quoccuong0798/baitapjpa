package com.example.baitapjpa.controller;

import com.example.baitapjpa.Service.imp.CustomerServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping ("/api")
public class CustomerController {
    @Autowired
    private CustomerServiceImp customerServiceImp;

    @PostMapping("/add")
    public ResponseEntity<?> addCustomer(@RequestParam String name, @RequestParam String email) {
        System.out.println("Trước hàm");
            customerServiceImp.save(name, email);
        System.out.println("Có vào không thì bảo");

             return new ResponseEntity<>("Thêm thành công", HttpStatus.OK);
    }
}
