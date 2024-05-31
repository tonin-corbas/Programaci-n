package Controladores;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.io.IOException;

public class ControladorPrincipal {

    @FXML
    private Button btnInsertar;

    @FXML
    private Button btnFiltrar;

    @FXML
    private void mostrarPantallaInsertar() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/org/example/proyectofinale/insert.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Insertar Personaje");
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void mostrarPantallaFiltrar() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/org/example/proyectofinale/filtro.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Filtrar Personajes");
        stage.setScene(new Scene(root));
        stage.show();
    }
}
