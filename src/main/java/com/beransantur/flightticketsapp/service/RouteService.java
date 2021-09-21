package com.beransantur.flightticketsapp.service;

import com.beransantur.flightticketsapp.model.Route;
import com.beransantur.flightticketsapp.repository.abstraction.IRouteRepository;
import com.beransantur.flightticketsapp.utils.exceptions.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RouteService {
    private final IRouteRepository routeRepository;

    public List<Route> getAllRoutes() {
        return routeRepository.getAllRoutes();
    }

    public Route getRouteById(Integer id) {
        throwExceptionIfNotFoundById(id);
        return routeRepository.getRouteById(id);
    }

    public Route saveRoute(Route route) {
        return routeRepository.getRouteById(routeRepository.saveRoute(route));
    }

    private void throwExceptionIfNotFoundById(Integer id) throws EntityNotFoundException {
        boolean isAirportExist = routeRepository.isRouteExist(id);
        if (!isAirportExist) {
            throw new EntityNotFoundException(id.toString());
        }
    }
}
