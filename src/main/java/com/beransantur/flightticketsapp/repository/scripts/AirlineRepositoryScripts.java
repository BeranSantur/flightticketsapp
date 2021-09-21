package com.beransantur.flightticketsapp.repository.scripts;

import com.beransantur.flightticketsapp.utils.sql.CommonSql;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

public class AirlineRepositoryScripts {
    public static final String GET_ALL_AIRLINES = "SELECT * FROM airline";

    public static final String GET_AIRLINE_BY_ID = "SELECT * FROM airline WHERE ID=:id";

    public static final String SAVE_AIRLINE = "INSERT INTO airline(NAME) VALUES(:name)";

    public static final String IS_AIRLINE_EXIST = CommonSql.isEntityWithGivenIdExist("airline");
}
