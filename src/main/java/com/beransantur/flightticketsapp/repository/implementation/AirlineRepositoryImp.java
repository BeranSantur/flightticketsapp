package com.beransantur.flightticketsapp.repository.implementation;

import com.beransantur.flightticketsapp.model.Airline;
import com.beransantur.flightticketsapp.repository.abstraction.IAirlineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import java.util.List;

import static com.beransantur.flightticketsapp.repository.scripts.AirlineRepositoryScripts.*;

@RequiredArgsConstructor
@Repository
public class AirlineRepositoryImp implements IAirlineRepository {
    private final Sql2o sql2o;

    @Override
    public List<Airline> getAllAirlines() {
        try(Connection con = sql2o.open(); Query query = con.createQuery(GET_ALL_AIRLINES)){
            return query
                   .executeAndFetch(Airline.class);
        }
    }

    @Override
    public Airline getAirlineById(Integer id){
        try(Connection con = sql2o.open(); Query query = con.createQuery(GET_AIRLINE_BY_ID)){
            return query
                    .addParameter("id" ,id)
                    .executeAndFetchFirst(Airline.class);
        }
    }

    public Integer saveAirline(Airline airline){
        try(Connection con = sql2o.open(); Query query = con.createQuery(SAVE_AIRLINE)){
             query
                    .addParameter("name", airline.getName())
                    .executeUpdate();
            return Integer.valueOf(getMaxId(sql2o, "airline_companies"));
        }
    }

}
