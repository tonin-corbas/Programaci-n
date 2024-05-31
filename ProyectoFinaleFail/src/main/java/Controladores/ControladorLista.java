package Controladores;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class ControladorLista {

    @FXML
    private ListView<String> personajesList;

    @FXML
    private void initialize() {
        String url = "jdbc:mysql://localhost:3306/proyectofinale";
        String user = "root";
        String password = "";

        String sql = "SELECT p.Nombre, p.Apellido, j.Nombre as Juego FROM personajes p JOIN juego_al_que_pertenece j ON p.id_juego = j.id";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String nombre = rs.getString("Nombre");
                String apellido = rs.getString("Apellido");
                String juego = rs.getString("Juego");
                personajesList.getItems().add(nombre + " " + apellido + " - " + juego);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
