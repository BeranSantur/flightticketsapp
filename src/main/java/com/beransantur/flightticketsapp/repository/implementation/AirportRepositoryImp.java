package com.beransantur.flightticketsapp.repository.implementation;

import com.beransantur.flightticketsapp.model.Airline;
import com.beransantur.flightticketsapp.model.Airport;
import com.beransantur.flightticketsapp.repository.abstraction.IAirportRepository;
import com.beransantur.flightticketsapp.utils.log.InfoLogMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import java.util.List;

import static com.beransantur.flightticketsapp.repository.scripts.AirlineRepositoryScripts.IS_AIRLINE_EXIST;
import static com.beransantur.flightticketsapp.repository.scripts.AirportRepositoryScripts.*;
import static com.beransantur.flightticketsapp.utils.sql.CommonSql.getMaxId;

@RequiredArgsConstructor
@Repository
public class AirportRepositoryImp implements IAirportRepository {
    private final Sql2o sql2o;
    private final String entityName = "Airport";
    private final InfoLogMessage infoLog = InfoLogMessage.builder().entityName(entityName).build();

    @Override
    public List<Airport> getAllAirports() {
        try (Connection con = sql2o.open(); Query query = con.createQuery(GET_ALL_AIRPORTS)) {
            List<Airport> airports = query
                    .executeAndFetch(Airport.class);

            infoLog.allEntitiesFound();
            return airports;
        }
    }

    @Override
    public Airport getAirportById(Integer id) {
        try (Connection con = sql2o.open(); Query query = con.createQuery(GET_AIRPORT_BY_ID)) {
            Airport airport = query
                    .addParameter("id", id)
                    .executeAndFetchFirst(Airport.class);

            infoLog.entityFoundById(id);
            return airport;
        }
    }

    public Integer saveAirport(Airport airport) {
        try (Connection con = sql2o.open(); Query query = con.createQuery(SAVE_AIRPORT)) {
            query
                    .addParameter("name", airport.getName())
                    .executeUpdate();

            infoLog.entityCreated();
            return Integer.valueOf(getMaxId(sql2o, "airport"));
        }
    }

    @Override
    public boolean isAirportExist(Integer id) {
        try (Connection con = sql2o.open(); Query query = con.createQuery(IS_AIRPORT_EXIST)) {
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
