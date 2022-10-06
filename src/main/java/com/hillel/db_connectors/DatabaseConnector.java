package com.hillel.db_connectors;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

public interface DatabaseConnector {
    Connection createConnection();

    default Properties getInfoFromProperties() {
        Properties properties = new Properties();
        try (FileInputStream fin = new FileInputStream("src/main/resources/application.properties")) {
            properties.load(fin);
            return properties;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
