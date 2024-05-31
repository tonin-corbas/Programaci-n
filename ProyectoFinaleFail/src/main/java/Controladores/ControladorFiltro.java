package Controladores;

import Modelos.Personaje;
import org.example.proyectofinale.BBDD;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ControladorFiltro {
    @FXML
    private ListView<Personaje> listViewPersonajes;
    @FXML
    private TextField puntuacionMinimaField;

    private ObservableList<Personaje> personajes;

    @FXML
    public void initialize() {
        personajes = FXCollections.observableArrayList();
        listViewPersonajes.setItems(personajes);
    }

    @FXML
    private void filtrarPersonajes() {
        double puntuacionMinima = Double.parseDouble(puntuacionMinimaField.getText());
        personajes.clear();

        String query = "SELECT p.* FROM personajes p " +
                "JOIN calificacion c ON p.id = c.id_personaje " +
                "WHERE c.Puntuacion >= " + puntuacionMinima;
        try (Connection connection = BBDD.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Personaje personaje = new Personaje(
                        rs.getInt("id"),
                        rs.getString("Nombre"),
                        rs.getString("Apellido"),
                        rs.getString("Hermandad"),
                        rs.getInt("id_juego")
                );
                personajes.add(personaje);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
