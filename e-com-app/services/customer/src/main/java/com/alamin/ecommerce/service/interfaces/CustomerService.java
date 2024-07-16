package com.alamin.ecommerce.service.interfaces;

import com.alamin.ecommerce.dto.request.RequestCustomerDTO;

public interface CustomerService {
    String createCustomer(RequestCustomerDTO dto);
}
