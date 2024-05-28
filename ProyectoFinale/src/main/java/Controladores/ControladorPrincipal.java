package Controladores;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import org.kordamp.bootstrapfx.BootstrapFX;

public class ControladorPrincipal {

    @FXML
    private void showListScreen() throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/proyectofinale/ListView.fxml"));
        Scene scene = new Scene(loader.load());
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        stage.setTitle("Lista de Personajes");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void showInsertScreen() throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/proyectofinale/InsertView.fxml"));
        Scene scene = new Scene(loader.load());
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        stage.setTitle("Insertar Personaje");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void showFilterScreen() throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/proyectofinale/FilterView.fxml"));
        Scene scene = new Scene(loader.load());
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        stage.setTitle("Filtrar Personajes");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void showDeleteScreen() throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/proyectofinale/DeleteView.fxml"));
        Scene scene = new Scene(loader.load());
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        stage.setTitle("Eliminar Personaje");
        stage.setScene(scene);
        stage.show();
    }
}
