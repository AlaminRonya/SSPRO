package com.alamin.ecommerce.mapper.request;

import com.alamin.ecommerce.dto.request.RequestAddressDTO;
import com.alamin.ecommerce.model.PresentAddress;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@Slf4j
public class RequestAddressMapper implements Function<RequestAddressDTO, PresentAddress> {
    @Override
    public PresentAddress apply(RequestAddressDTO dto) {
        return dto == null ? null :PresentAddress.builder()
                .street(dto.street())
                .houseNumber(dto.houseNumber())
                .zipCode(dto.zipCode())
                .build();
    }
}
