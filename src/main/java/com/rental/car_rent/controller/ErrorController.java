package com.rental.car_rent.controller;

import com.rental.car_rent.DTO.DataResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class ErrorController {
    @ExceptionHandler({ResponseStatusException.class})
    public ResponseEntity<?> responseStatusException(ResponseStatusException e) {
        DataResponse<?> response = DataResponse.builder()
                .statusCode(e.getRawStatusCode())
                .message(e.getReason())
                .build();
        return ResponseEntity
                .status(e.getStatus())
                .body(response);
    }
}
