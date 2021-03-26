module fxtest {
    requires javafx.controls;
    requires javafx.fxml;

    opens fxtest to javafx.fxml;
    exports fxtest;
}
