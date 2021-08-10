module com.kitSoft {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.kitSoft to javafx.fxml;
    exports com.kitSoft;
}