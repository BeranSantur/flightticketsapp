package com.beransantur.flightticketsapp.repository.abstraction;

import com.beransantur.flightticketsapp.model.Airport;

import java.util.List;

public interface IAirportRepository {
    List<Airport> getAllAirports();

    Airport getAirportById(Integer id);

    Integer saveAirport (Airport airline);

    boolean isAirportExist(Integer id);
}
