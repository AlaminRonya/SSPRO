package com.alamin.ecommerce.service.interfaces;

import com.alamin.ecommerce.dto.request.RequestCustomerDTO;
import com.alamin.ecommerce.dto.response.ResponseCustomerDTO;

import java.util.Set;

public interface CustomerService {
    String createCustomer(RequestCustomerDTO dto);
    Set<ResponseCustomerDTO> getAllCustomers();
}
