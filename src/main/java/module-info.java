module library.main.librarymanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.fasterxml.jackson.databind;
    opens library.main.virtualbookmanager to javafx.fxml;
    exports library.main.virtualbookmanager;
    exports library.main.virtualbookmanager.application;
    opens library.main.virtualbookmanager.application to javafx.fxml;
}