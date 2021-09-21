package com.beransantur.flightticketsapp.repository.abstraction;

import com.beransantur.flightticketsapp.model.Route;

import java.util.List;

public interface IRouteRepository {

    List<Route> getAllRoutes();

    Route getRouteById(Integer id);

    Integer saveRoute(Route route);

    boolean isRouteExist(Integer id);
}
