package com.alamin.ecommerce.mapper.response;

import com.alamin.ecommerce.dto.response.ResponseAddressDTO;
import com.alamin.ecommerce.model.Address;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@Slf4j
public class ResponseAddressMapper implements Function<Address, ResponseAddressDTO> {
    @Override
    public ResponseAddressDTO apply(Address entity) {
        return entity == null ? null :new ResponseAddressDTO(
                entity.getId(), entity.getStreet(), entity.getHouseNumber(), entity.getZipCode(),
                entity.getCreatedAt(), entity.getUpdatedAt(), entity.getDeletedAt(), entity.getBrowser(), entity.getCreatedBy(), entity.getUpdatedBy(), entity.getDeletedBy(), entity.getIp(), entity.isStatus()
        );
    }
}
