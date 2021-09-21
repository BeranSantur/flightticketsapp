package com.beransantur.flightticketsapp.utils.sql;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

@Slf4j
@RequiredArgsConstructor
public class CommonSql {
    private static final StringBuilder sqlBuilder = new StringBuilder();

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

    public static String isEntityWithGivenIdExist(String tableName){
        return sqlBuilder.delete(0, sqlBuilder.length())
                .append("SELECT")
                .append("ID")
                .append("FROM")
                .append(tableName)
                .append("WHERE ID=:id").toString();

        }
    }

