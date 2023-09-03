package com.spring.user.controller;

import com.spring.user.dto.HttpResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ErrorController {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<HttpResponse<String>> constraintViolationException(ConstraintViolationException e) {
        Map<String, Object> errors = new HashMap<>();

        for (ConstraintViolation<?> violation : e.getConstraintViolations()) {
            errors.put(
                    toSnakeCase(violation.getPropertyPath().toString()),
                    violation.getMessage()
            );
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(HttpResponse.<String>builder().errors(errors).build());
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<HttpResponse<String>> responseStatusException(ResponseStatusException e) {
        return ResponseEntity.status(e.getStatusCode())
                .body(HttpResponse.<String>builder().error(e.getReason()).build());
    }

    private String toSnakeCase(String field) {
        return field.replaceAll("([a-z])([A-Z]+)", "$1_$2").toLowerCase();
    }
}