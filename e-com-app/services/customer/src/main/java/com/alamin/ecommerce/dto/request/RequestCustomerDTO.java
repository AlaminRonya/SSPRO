package com.alamin.ecommerce.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record RequestCustomerDTO(
        @NotNull(message = "Customer-firstname is required")
        String firstname,
        @NotNull(message = "Customer-lastname is required")
        String lastname,
        @NotNull(message = "Customer-email is required")
        @Email(message = "Customer-email is not valid email address")
        String email,
        @NotNull(message = "Customer-address is required")
        RequestAddressDTO address
) {
}
