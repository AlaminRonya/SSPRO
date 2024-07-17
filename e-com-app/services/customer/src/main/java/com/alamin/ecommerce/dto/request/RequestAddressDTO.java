package com.alamin.ecommerce.dto.request;

import jakarta.validation.constraints.NotNull;

public record RequestAddressDTO(
        @NotNull(message = "Customer-street is required")
        String street,
        @NotNull(message = "Customer-houseNumber is required")
        String houseNumber,
        @NotNull(message = "Customer-zipCode is required")
        String zipCode
) {
}
