package com.beransantur.flightticketsapp.repository.scripts;

import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

public class AirportRepositoryScripts {

    private static final StringBuilder sqlBuilder = new StringBuilder();

    public static final String GET_ALL_AIRPORTS = "SELECT * FROM airport";

    public static final String GET_AIRPORT_BY_ID = "SELECT * FROM airport WHERE ID=:id";

    public static final String SAVE_AIRPORT = "INSERT INTO airport(NAME) VALUES(:name)";

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
