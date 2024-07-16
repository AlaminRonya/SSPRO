package com.alamin.ecommerce.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
import java.util.UUID;

public record ResponseAddressDTO(
        UUID id, String street,String houseNumber,String zipCode,
        LocalDate createdAt,
        LocalDate updatedAt,
        @JsonIgnore
        LocalDate deletedAt,
        @JsonIgnore
        String browser,
        String createdBy,
        String updatedBy,
        @JsonIgnore
        String deletedBy,
        @JsonIgnore
        String ip,
        boolean status
) {
}
