module org.example.hundirlaflota {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.example.hundirlaflota to javafx.fxml;
    exports org.example.hundirlaflota;
}