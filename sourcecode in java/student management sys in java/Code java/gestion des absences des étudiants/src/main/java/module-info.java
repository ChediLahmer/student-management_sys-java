module com.example.dualist {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.mail;
    requires javafx.graphics;


    opens com.example.dualist to javafx.fxml;
    exports com.example.dualist;
}