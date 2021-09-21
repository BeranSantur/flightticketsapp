package com.beransantur.flightticketsapp.repository.implementation;

import com.beransantur.flightticketsapp.model.Airline;
import com.beransantur.flightticketsapp.model.Route;
import com.beransantur.flightticketsapp.repository.abstraction.IRouteRepository;
import com.beransantur.flightticketsapp.utils.log.InfoLogMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import java.util.List;

import static com.beransantur.flightticketsapp.repository.scripts.AirportRepositoryScripts.IS_AIRPORT_EXIST;
import static com.beransantur.flightticketsapp.repository.scripts.RouteRepositoryScripts.*;
import static com.beransantur.flightticketsapp.utils.sql.CommonSql.getMaxId;

@RequiredArgsConstructor
@Repository
public class RouteRepositoryImp implements IRouteRepository {

    private final String entityName = "Route";
    private final InfoLogMessage infoLog = InfoLogMessage.builder().entityName(entityName).build();
    private final Sql2o sql2o;

    @Override
    public List<Route> getAllRoutes() {
        try (Connection con = sql2o.open(); Query query = con.createQuery(GET_ALL_ROUTES)) {
            List<Route> routes = query
                    .executeAndFetch(Route.class);

            infoLog.allEntitiesFound();
            return routes;
        }
    }

    @Override
    public Route getRouteById(Integer id) {
        try (Connection con = sql2o.open(); Query query = con.createQuery(GET_ROUTE_BY_ID)) {
            Route route = query
                    .addParameter("id", id)
                    .executeAndFetchFirst(Route.class);

            infoLog.entityFoundById(id);
            return route;
        }
    }

    @Override
    public Integer saveRoute(Route route) {
        try (Connection con = sql2o.open(); Query query = con.createQuery(SAVE_ROUTE)) {
            query
                    .addParameter("departure", route.getDeparture())
                    .addParameter("destination", route.getDestination())
                    .executeUpdate();
            infoLog.entityCreated();
            return Integer.valueOf(getMaxId(sql2o, "route"));
        }
    }

    @Override
    public boolean isRouteExist(Integer id) {
        try (Connection con = sql2o.open(); Query query = con.createQuery(IS_ROUTE_EXIST)) {
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
