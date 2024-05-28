package Controladores;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ControladorBorrar {

    @FXML
    private TextField idField;

    @FXML
    private void deletePersonaje() {
        int id = Integer.parseInt(idField.getText());

        String url = "jdbc:mysql://localhost:3306/proyecto final";
        String user = "root";
        String password = "";

        String sql = "DELETE FROM personajes WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
