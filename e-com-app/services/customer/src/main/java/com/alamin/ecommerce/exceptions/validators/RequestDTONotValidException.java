package com.alamin.ecommerce.exceptions.validators;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
public class RequestDTONotValidException extends RuntimeException {

    private final Set<String> errorMessages;

}