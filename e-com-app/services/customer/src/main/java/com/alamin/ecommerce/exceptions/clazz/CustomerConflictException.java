package com.alamin.ecommerce.exceptions.clazz;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CustomerConflictException extends RuntimeException {

    private final String msg;
}