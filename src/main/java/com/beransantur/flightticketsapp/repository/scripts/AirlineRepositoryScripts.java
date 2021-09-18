package com.beransantur.flightticketsapp.repository.scripts;

import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

public class AirlineRepositoryScripts {
    private static final StringBuilder sqlBuilder = new StringBuilder();

    public static final String GET_ALL_AIRLINES = "SELECT * FROM airline_companies";

    public static final String GET_AIRLINE_BY_ID = "SELECT * FROM airline_companies WHERE ID=:id";

    public static final String SAVE_AIRLINE = "INSERT INTO airline_companies(NAME) VALUES(:name)";

    public static String getMaxId(Sql2o sql2o, String tableName) {
        String script = sqlBuilder.delete(0, sqlBuilder.length())
                .append("SELECT ")
                .append("max(ID)")
                .append("FROM ")
                .append(tableName)
                .toString();

        try (Connection con = sql2o.open(); Query query = con.createQuery(script)) {
            return query.executeAndFetchFirst(String.class);
        } catch (Exception e) {

            throw new RuntimeException(e);
        }
    }

}
