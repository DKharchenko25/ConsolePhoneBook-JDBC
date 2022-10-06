package com.hillel.db_connectors;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class H2DatabaseConnector implements DatabaseConnector {

    private Properties properties;

    public H2DatabaseConnector() {
        init();
    }

    private void init() {
        try {
            properties = getInfoFromProperties();
            DriverManager.getConnection(properties.getProperty("first_connection.url"),
                    properties.getProperty("db.user"),
                    properties.getProperty("db.password"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection createConnection() {
        try {
            properties = getInfoFromProperties();
            return DriverManager.getConnection(properties.getProperty("connection.url"),
                    properties.getProperty("db.user"),
                    properties.getProperty("db.password"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
