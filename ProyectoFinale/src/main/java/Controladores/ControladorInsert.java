package Controladores;

import org.example.proyectofinale.BBDD;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ControladorInsert {
    @FXML
    private TextField nombreField;
    @FXML
    private TextField apellidoField;
    @FXML
    private TextField hermandadField;
    @FXML
    private TextField idJuegoField;

    @FXML
    private void insertarPersonaje() {
        String nombre = nombreField.getText();
        String apellido = apellidoField.getText();
        String hermandad = hermandadField.getText();
        int idJuego = Integer.parseInt(idJuegoField.getText());

        String query = "INSERT INTO personajes (Nombre, Apellido, Hermandad, id_juego) VALUES (?, ?, ?, ?)";
        try (Connection connection = BBDD.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, nombre);
            pstmt.setString(2, apellido);
            pstmt.setString(3, hermandad);
            pstmt.setInt(4, idJuego);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
