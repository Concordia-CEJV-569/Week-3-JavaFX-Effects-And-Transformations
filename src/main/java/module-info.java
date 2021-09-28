module com.example.javafxeffectsandtransformations {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafxeffectsandtransformations to javafx.fxml;
    exports com.example.javafxeffectsandtransformations;
}