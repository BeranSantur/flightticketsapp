package com.beransantur.flightticketsapp.repository.scripts;

public class AirlineRepositoryScripts {
    public static final String GET_ALL_AIRLINES = "SELECT * FROM airline_companies";

    public static final String GET_AIRLINE_BY_ID = "SELECT * FROM airline_companies WHERE ID=:id";

    public static final String SAVE_AIRLINE = "INSERT INT0 airline_companies(NAME) VALUES(:name)";
}
