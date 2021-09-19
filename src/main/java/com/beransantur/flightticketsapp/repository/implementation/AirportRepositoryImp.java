package com.beransantur.flightticketsapp.repository.implementation;

import com.beransantur.flightticketsapp.model.Airline;
import com.beransantur.flightticketsapp.model.Airport;
import com.beransantur.flightticketsapp.repository.abstraction.IAirportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import java.util.List;

import static com.beransantur.flightticketsapp.repository.scripts.AirportRepositoryScripts.getMaxId;
import static com.beransantur.flightticketsapp.repository.scripts.AirportRepositoryScripts.*;

@RequiredArgsConstructor
@Repository
public class AirportRepositoryImp implements IAirportRepository {
    private final Sql2o sql2o;

    @Override
    public List<Airport> getAllAirports() {
        try(Connection con = sql2o.open(); Query query = con.createQuery(GET_ALL_AIRPORTS)){
            return query
                    .executeAndFetch(Airport.class);
        }
    }

    @Override
    public Airport getAirportById(Integer id){
        try(Connection con = sql2o.open(); Query query = con.createQuery(GET_AIRPORT_BY_ID)){
            return query
                    .addParameter("id" ,id)
                    .executeAndFetchFirst(Airport.class);
        }
    }

    public Integer saveAirport(Airport airport){
        try(Connection con = sql2o.open(); Query query = con.createQuery(SAVE_AIRPORT)){
            query
                    .addParameter("name", airport.getName())
                    .executeUpdate();
            return Integer.valueOf(getMaxId(sql2o, "airport"));
        }
    }

}
