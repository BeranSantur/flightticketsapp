package com.beransantur.flightticketsapp.controller;

import com.beransantur.flightticketsapp.model.Airline;
import com.beransantur.flightticketsapp.model.Airport;
import com.beransantur.flightticketsapp.model.dto.AirportRequestDto;
import com.beransantur.flightticketsapp.service.AirlineService;
import com.beransantur.flightticketsapp.service.AirportService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Api(value = "Acquirer Api for Ds Management")
@RequestMapping("/airports")
public class AirportController {

    private final AirportService airportService;
    private final ModelMapper modelMapper;

    @GetMapping()
    public ResponseEntity<List<Airport>> getAllAirports() {
        return ResponseEntity.ok(airportService.getAllAirports());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Airport> getAirlineById(@PathVariable Integer id) {
        return ResponseEntity.ok(airportService.getAirportById(id));
    }

    @PostMapping()
    public ResponseEntity<Airport> saverRoute(@RequestBody AirportRequestDto airportRequestDto) {
        return ResponseEntity.ok(airportService.saveAirport(modelMapper.map(airportRequestDto, Airport.class)));
    }
}
