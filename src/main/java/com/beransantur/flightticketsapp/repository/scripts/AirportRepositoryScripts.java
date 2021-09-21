package com.beransantur.flightticketsapp.repository.scripts;

import com.beransantur.flightticketsapp.utils.sql.CommonSql;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

public class AirportRepositoryScripts {

    public static final String GET_ALL_AIRPORTS = "SELECT * FROM airport";

    public static final String GET_AIRPORT_BY_ID = "SELECT * FROM airport WHERE ID=:id";

    public static final String SAVE_AIRPORT = "INSERT INTO airport(NAME) VALUES(:name)";

    public static final String IS_AIRPORT_EXIST = CommonSql.isEntityWithGivenIdExist("airport");

}
