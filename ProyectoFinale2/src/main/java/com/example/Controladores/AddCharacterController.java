package com.example.controller;

import com.example.model.DatabaseConnection;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddCharacterController {

    @FXML
    private TextField nameField;
    @FXML
    private TextField surnameField;
    @FXML
    private TextField brotherhoodField;
    @FXML
    private TextField ratingField;

    @FXML
    private void handleAddCharacter() {
        String name = nameField.getText();
        String surname = surnameField.getText();
        String brotherhood = brotherhoodField.getText();
        double rating = Double.parseDouble(ratingField.getText());

        String insertQuery = "INSERT INTO personajes (Nombre, Apellido, Hermandad, id_juego) VALUES (?, ?, ?, ?)";
        String insertRatingQuery = "INSERT INTO calificacion (Puntuacion, id_personaje) VALUES (?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(insertQuery, PreparedStatement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, name);
            pstmt.setString(2, surname);
            pstmt.setString(3, brotherhood);
            pstmt.setInt(4, 1); // Asignar el juego correspondiente
            pstmt.executeUpdate();

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int characterId = generatedKeys.getInt(1);

                    try (PreparedStatement pstmtRating = conn.prepareStatement(insertRatingQuery)) {
                        pstmtRating.setDouble(1, rating);
                        pstmtRating.setInt(2, characterId);
                        pstmtRating.executeUpdate();
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
