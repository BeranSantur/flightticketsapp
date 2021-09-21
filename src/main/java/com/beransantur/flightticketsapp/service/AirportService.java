package com.beransantur.flightticketsapp.service;

import com.beransantur.flightticketsapp.model.Airline;
import com.beransantur.flightticketsapp.model.Airport;
import com.beransantur.flightticketsapp.repository.abstraction.IAirportRepository;
import com.beransantur.flightticketsapp.utils.exceptions.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AirportService {
    private final IAirportRepository airportRepository;

    public List<Airport> getAllAirports() {
        return airportRepository.getAllAirports();
    }

    public Airport getAirportById(Integer id) {
        throwExceptionIfNotFoundById(id);
        return airportRepository.getAirportById(id);
    }

    public Airport saveAirport(Airport airport) {
        return airportRepository.getAirportById(airportRepository.saveAirport(airport));
    }

    private void throwExceptionIfNotFoundById(Integer id) throws EntityNotFoundException {
        boolean isAirportExist = airportRepository.isAirportExist(id);
        if (!isAirportExist) {
            throw new EntityNotFoundException(id.toString());
        }
    }
}
