package com.beransantur.flightticketsapp.repository.abstraction;

import com.beransantur.flightticketsapp.model.Airline;

import java.util.List;

public interface IAirlineRepository {

    List<Airline> getAllAirlines();

    Airline getAirlineById(Integer id);

    Integer saveAirline (Airline airline);
}
