package com.beransantur.flightticketsapp.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RouteRequestDto {
    private String departure;
    private String destination;
}
