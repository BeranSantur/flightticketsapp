package com.beransantur.flightticketsapp.utils.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
public class ApiError {
    private HttpStatus httpStatus;
    private String message;
}
