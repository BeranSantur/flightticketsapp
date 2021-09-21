package com.beransantur.flightticketsapp.utils.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ApiError> handleNotFound(EntityNotFoundException ex) {

        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, ex.getMessage());

        return new ResponseEntity<>(apiError, apiError.getHttpStatus());
    }
}
