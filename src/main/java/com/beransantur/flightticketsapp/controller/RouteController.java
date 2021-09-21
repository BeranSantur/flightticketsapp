package com.beransantur.flightticketsapp.controller;

import com.beransantur.flightticketsapp.model.Airport;
import com.beransantur.flightticketsapp.model.Route;
import com.beransantur.flightticketsapp.model.dto.RouteRequestDto;
import com.beransantur.flightticketsapp.service.RouteService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/routes")
public class RouteController {
    private final RouteService routeService;
    private final ModelMapper modelMapper;

    @GetMapping()
    public ResponseEntity<List<Route>> getAllRoutes() {
        return ResponseEntity.ok(routeService.getAllRoutes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Route> getRouteById(@PathVariable Integer id) {
        return ResponseEntity.ok(routeService.getRouteById(id));
    }

    @PostMapping()
    public ResponseEntity<Route> saveRoute(@RequestBody RouteRequestDto routeRequestDto) {
        return ResponseEntity.ok(routeService.saveRoute(modelMapper.map(routeRequestDto, Route.class)));
    }
}
