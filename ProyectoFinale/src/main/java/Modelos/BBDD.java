package Modelos;

import java.sql.*;

public class BBDD {
    private static final String url = "jdbc:mysql://localhost:3306/proyectofinale";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, USER, PASSWORD);
    }
}

