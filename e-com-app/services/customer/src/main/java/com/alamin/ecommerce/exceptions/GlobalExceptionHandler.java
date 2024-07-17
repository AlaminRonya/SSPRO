package com.alamin.ecommerce.exceptions;

import com.alamin.ecommerce.exceptions.clazz.CustomerConflictException;
import com.alamin.ecommerce.exceptions.clazz.CustomerNotFoundException;
import com.alamin.ecommerce.exceptions.handler.ErrorResponse;
import com.alamin.ecommerce.exceptions.validators.RequestDTONotValidException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(RequestDTONotValidException.class)
    public ResponseEntity<?> handleRequestDTONotValidException(RequestDTONotValidException exp, WebRequest request) {
        log.info("global exception handler "+exp.getErrorMessages());
        return ResponseEntity
                .badRequest()
                .body(exp.getErrorMessages());
    }
    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<String> handle(CustomerNotFoundException exp) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exp.getMsg());
    }
    @ExceptionHandler(CustomerConflictException.class)
    public ResponseEntity<String> handle(CustomerConflictException exp) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(exp.getMsg());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException exp) {
        var errors = new HashMap<String, String>();
        exp.getBindingResult().getAllErrors()
                .forEach(error -> {
                    var fieldName = ((FieldError) error).getField();
                    var errorMessage = error.getDefaultMessage();
                    errors.put(fieldName, errorMessage);
                });

        return ResponseEntity
                .status(BAD_REQUEST)
                .body(new ErrorResponse(errors));
    }
}