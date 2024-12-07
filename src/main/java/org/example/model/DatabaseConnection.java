package org.example.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection;
    private final String URL_SQLITE = "jdbc:sqlite:turnos_peluqueria.db";

    private DatabaseConnection() throws SQLException {
        connection = DriverManager.getConnection(URL_SQLITE);
    }

    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            return connection = DriverManager.getConnection("jdbc:sqlite:turnos_peluqueria.db");
        }

        return connection;
    }
}
