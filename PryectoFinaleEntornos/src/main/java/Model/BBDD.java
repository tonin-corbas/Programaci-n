package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase BBDD para Conectar con la base de datos.
 */
public class BBDD {
    private static final String URL = "jdbc:mysql://localhost:3306/proyectofinale";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
