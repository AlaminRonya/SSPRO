package com.alamin.ecommerce.dto.request;

public record RequestCustomerDTO(
        String firstname,String lastname,
        String email, RequestAddressDTO address
) {
}
