package Controladores;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ControladorFiltro {

    @FXML
    private TextField filterField;

    @FXML
    private ListView<String> personajesList;

    @FXML
    private void filterPersonajes() {
        String filter = filterField.getText();

        String url = "jdbc:mysql://localhost:3306/proyectofinale";
        String user = "root";
        String password = "";

        String sql = "SELECT Nombre, Apellido FROM personajes WHERE Nombre LIKE '%" + filter + "%'";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            personajesList.getItems().clear();

            while (rs.next()) {
                String nombre = rs.getString("Nombre");
                String apellido = rs.getString("Apellido");
                personajesList.getItems().add(nombre + " " + apellido);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
