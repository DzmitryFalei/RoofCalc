module com.example.roofcalc {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.roofcalc to javafx.fxml;
    exports com.example.roofcalc;
}