package com.example.controller;

import com.example.model.Character;
import com.example.model.DatabaseConnection;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainController {
    @FXML
    private TableView<Character> characterTable;
    @FXML
    private TableColumn<Character, String> nameColumn;
    @FXML
    private TableColumn<Character, String> surnameColumn;
    @FXML
    private TableColumn<Character, String> brotherhoodColumn;
    @FXML
    private TableColumn<Character, Double> ratingColumn;
    @FXML
    private TextField ratingFilterField;

    @FXML
    private void initialize() {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        surnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));
        brotherhoodColumn.setCellValueFactory(new PropertyValueFactory<>("brotherhood"));
        ratingColumn.setCellValueFactory(new PropertyValueFactory<>("rating"));

        loadCharacters();
    }

    @FXML
    private void handleFilter() {
        double rating = Double.parseDouble(ratingFilterField.getText());
        loadCharacters(rating);
    }

    private void loadCharacters() {
        loadCharacters(0);
    }

    private void loadCharacters(double minRating) {
        characterTable.getItems().clear();

        String query = "SELECT p.id, p.Nombre, p.Apellido, p.Hermandad, c.Puntuacion " +
                "FROM personajes p " +
                "JOIN calificacion c ON p.id = c.id_personaje " +
                "WHERE c.Puntuacion >= ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setDouble(1, minRating);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Character character = new Character(
                        rs.getInt("id"),
                        rs.getString("Nombre"),
                        rs.getString("Apellido"),
                        rs.getString("Hermandad"),
                        0, // id_juego no es necesario en esta consulta
                        rs.getDouble("Puntuacion")
                );
                characterTable.getItems().add(character);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
@FXML
private void openAddCharacterScreen() {
    try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/fxml/add_character_screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Añadir Personaje");
        stage.setScene(scene);
        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
