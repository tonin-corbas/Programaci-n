package org.example.proyectofinale;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BBDD {
    private static final String URL = "jdbc:mariadb://localhost:3306/proyecto_final";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
