module com.example.yakboksdemo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.yakboksdemo to javafx.fxml;
    exports com.example.yakboksdemo;
}