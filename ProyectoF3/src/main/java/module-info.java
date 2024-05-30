module org.example.proyectof3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;


    opens org.example.proyectof3 to javafx.fxml;
    exports org.example.proyectof3;
}