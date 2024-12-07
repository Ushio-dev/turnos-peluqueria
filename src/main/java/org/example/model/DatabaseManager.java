package org.example.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {
    public static void GenerateTables(Connection connection) throws SQLException {
        String  SQL = "CREATE TABLE IF NOT EXISTS turnosClientes(" +
                " id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " nombre TEXT NOT NULL," +
                " telefono INTEGER NOT NULL," +
                " fechaTurno TEXT NOT NULL," +
                " horaTurno TEXT NOT NULL)";
        Statement stmt =connection.createStatement();
        stmt.execute(SQL);
    }
}
