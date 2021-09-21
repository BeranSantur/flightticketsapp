package com.beransantur.flightticketsapp.service;

import com.beransantur.flightticketsapp.model.Airline;
import com.beransantur.flightticketsapp.repository.abstraction.IAirlineRepository;
import com.beransantur.flightticketsapp.utils.exceptions.EntityNotFoundException;
import com.beransantur.flightticketsapp.utils.sql.CommonSql;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AirlineService {
    private final IAirlineRepository airlineRepository;

    public List<Airline> getAllAirlines() {return airlineRepository.getAllAirlines();}

    public Airline getAirlineById(Integer id) {
       throwExceptionIfNotFoundById(id);
        return airlineRepository.getAirlineById(id);
    }

    public Airline saveAirline (Airline airline){
    return airlineRepository.getAirlineById(airlineRepository.saveAirline(airline));
    }

    private void throwExceptionIfNotFoundById(Integer id) throws EntityNotFoundException{
        boolean isAirlineExist = airlineRepository.isAirlineExist(id);
        if(!isAirlineExist){
            throw new EntityNotFoundException(id.toString());
        }
    }
}
