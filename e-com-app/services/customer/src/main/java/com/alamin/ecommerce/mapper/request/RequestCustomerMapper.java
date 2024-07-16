package com.alamin.ecommerce.mapper.request;

import com.alamin.ecommerce.dto.request.RequestCustomerDTO;
import com.alamin.ecommerce.model.Customer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.function.Function;
@Component
@Slf4j
@RequiredArgsConstructor
public class RequestCustomerMapper implements Function<RequestCustomerDTO, Customer> {
    private final RequestAddressMapper requestAddressMapper;
    @Override
    public Customer apply(RequestCustomerDTO dto) {
        return dto == null ? null :Customer.builder()
                .firstname(dto.firstname())
                .lastname(dto.lastname())
                .email(dto.email())
                .address(requestAddressMapper.apply(dto.address()))
                .build();
    }
}
