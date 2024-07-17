package com.alamin.ecommerce.controller;

import com.alamin.ecommerce.dto.request.RequestCustomerDTO;
import com.alamin.ecommerce.service.interfaces.CustomerService;
import com.alamin.ecommerce.utils.URLSupplier;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(URLSupplier.CUSTOMER_BASE_URL)
public class CustomerController {
    private final CustomerService customerService;
//    @GetMapping
//    public String getCustomer() {
//        return "Hello World";
//    }
    @PostMapping
    public ResponseEntity<?> postCustomer(@RequestBody RequestCustomerDTO dto) {
        return new ResponseEntity<>(customerService.createCustomer(dto), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<?> getAllCustomers() {
        return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
    }

}
