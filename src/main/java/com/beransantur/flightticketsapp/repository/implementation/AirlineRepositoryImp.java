package com.beransantur.flightticketsapp.repository.implementation;

import com.beransantur.flightticketsapp.model.Airline;
import com.beransantur.flightticketsapp.repository.abstraction.IAirlineRepository;
import com.beransantur.flightticketsapp.utils.log.InfoLogMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import java.util.List;

import static com.beransantur.flightticketsapp.repository.scripts.AirlineRepositoryScripts.*;
import static com.beransantur.flightticketsapp.utils.sql.CommonSql.getMaxId;

@RequiredArgsConstructor
@Repository
public class AirlineRepositoryImp implements IAirlineRepository {
    private final String entityName = "Airline";
    private final InfoLogMessage infoLog = InfoLogMessage.builder().entityName(entityName).build();
    private final Sql2o sql2o;

    @Override
    public List<Airline> getAllAirlines() {
        try (Connection con = sql2o.open(); Query query = con.createQuery(GET_ALL_AIRLINES)) {
            List<Airline> airlines = query
                    .executeAndFetch(Airline.class);

            infoLog.allEntitiesFound();
            return airlines;
        }
    }

    @Override
    public Airline getAirlineById(Integer id) {
        try (Connection con = sql2o.open(); Query query = con.createQuery(GET_AIRLINE_BY_ID)) {
            Airline airline = query
                    .addParameter("id", id)
                    .executeAndFetchFirst(Airline.class);

            infoLog.entityFoundById(id);
            return airline;
        }
    }

    public Integer saveAirline(Airline airline) {
        try (Connection con = sql2o.open(); Query query = con.createQuery(SAVE_AIRLINE)) {
            query
                    .addParameter("name", airline.getName())
                    .executeUpdate();
            infoLog.entityCreated();
            return Integer.valueOf(getMaxId(sql2o, "airline"));
        }
    }

    @Override
    public boolean isAirlineExist(Integer id) {
        try (Connection con = sql2o.open(); Query query = con.createQuery(IS_AIRLINE_EXIST)) {
            Integer idFromDb = query
                    .executeAndFetchFirst(Integer.class);

            if (idFromDb == null) {
                infoLog.entityWasNotFound();
                return false;
            }
            return true;
        }

    }

}