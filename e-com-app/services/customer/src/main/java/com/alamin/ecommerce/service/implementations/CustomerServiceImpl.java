package com.alamin.ecommerce.service.implementations;

import com.alamin.ecommerce.dto.request.RequestCustomerDTO;
import com.alamin.ecommerce.service.interfaces.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    @Override
    public String createCustomer(RequestCustomerDTO dto) {
        return "Customer created";
    }
}
