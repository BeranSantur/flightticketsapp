package com.beransantur.flightticketsapp.controller;

import com.beransantur.flightticketsapp.model.Airline;
import com.beransantur.flightticketsapp.service.AirlineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airlines")
@RequiredArgsConstructor
public class AirlineController {

    private final AirlineService airlineService;

    @GetMapping()
    public ResponseEntity<List<Airline>> getAllAirlines(){
        return ResponseEntity.ok(airlineService.getAllAirlines());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Airline> getAirlineById(@PathVariable Integer id){
        return ResponseEntity.ok(airlineService.getAirlineById(id));
    }

    @PostMapping()
    public ResponseEntity<Airline> getAirlineById(@RequestBody Airline airline){
        return ResponseEntity.ok(airlineService.saveAirline(airline));
    }


}
