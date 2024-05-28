module org.example.proyectofinale {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens org.example.proyectofinale to javafx.fxml;
    opens Controladores to javafx.fxml;
    exports org.example.proyectofinale;
    exports Controladores;
}