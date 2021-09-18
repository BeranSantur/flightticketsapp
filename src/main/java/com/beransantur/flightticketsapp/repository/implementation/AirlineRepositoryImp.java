package com.beransantur.flightticketsapp.repository.implementation;

import com.beransantur.flightticketsapp.model.Airline;
import com.beransantur.flightticketsapp.repository.abstraction.IAirlineRepository;
import lombok.RequiredArgsConstructor;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import java.util.List;

import static com.beransantur.flightticketsapp.repository.scripts.AirlineRepositoryScripts.*;

@RequiredArgsConstructor
public class AirlineRepositoryImp implements IAirlineRepository {
    private final Sql2o sql2o;

    @Override
    public List<Airline> getAllAirlines() {
        try(Connection con = sql2o.open(); Query query = con.createQuery(GET_ALL_AIRLINES)){
            return query
                   .executeAndFetch(Airline.class);
        }
    }

}
