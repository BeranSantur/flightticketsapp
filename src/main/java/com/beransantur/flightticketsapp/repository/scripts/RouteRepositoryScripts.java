package com.beransantur.flightticketsapp.repository.scripts;

import com.beransantur.flightticketsapp.utils.sql.CommonSql;

public class RouteRepositoryScripts {

    public static final String GET_ALL_ROUTES = "SELECT * FROM route";

    public static final String GET_ROUTE_BY_ID = "SELECT * FROM route WHERE ID=:id";

    public static final String SAVE_ROUTE = "INSERT INTO route(DEPARTURE, DESTINATION) VALUES(:departure, :destination)";

    public static final String IS_ROUTE_EXIST = CommonSql.isEntityWithGivenIdExist("route");

}
