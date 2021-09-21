package com.beransantur.flightticketsapp.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Route {
    private Integer id;
    private String departure;
    private String destination;
}
