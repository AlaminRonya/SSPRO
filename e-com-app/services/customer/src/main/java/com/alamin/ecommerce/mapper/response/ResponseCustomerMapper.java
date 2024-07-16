package com.alamin.ecommerce.mapper.response;

import com.alamin.ecommerce.dto.response.ResponseCustomerDTO;
import com.alamin.ecommerce.model.Customer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@Slf4j
@RequiredArgsConstructor
public class ResponseCustomerMapper implements Function<Customer, ResponseCustomerDTO> {
    private final ResponseAddressMapper responseAddressMapper;
    @Override
    public ResponseCustomerDTO apply(Customer entity) {
        return entity == null ? null :new ResponseCustomerDTO(
                entity.getId(), entity.getFirstname(), entity.getLastname(), entity.getEmail(), responseAddressMapper.apply(entity.getAddress()),
                entity.getCreatedAt(), entity.getUpdatedAt(), entity.getDeletedAt(), entity.getBrowser(), entity.getCreatedBy(), entity.getUpdatedBy(), entity.getDeletedBy(), entity.getIp(), entity.isStatus()
        );
    }
}
