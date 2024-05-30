module org.example.proyectofinale {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.kordamp.bootstrapfx.core;

    opens Controladores to javafx.fxml;
    opens Modelos to javafx.base;

    exports org.example.proyectofinale;
    exports Controladores;
    exports Modelos;
    opens org.example.proyectofinale to javafx.base, javafx.fxml;
}
