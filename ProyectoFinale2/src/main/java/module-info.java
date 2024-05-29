module com.example.proyectofinale2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.proyectofinale2 to javafx.fxml;
    exports com.example.proyectofinale2;
}