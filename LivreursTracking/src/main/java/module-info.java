module com.livtrack.livreurstracking {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.livtrack.livreurstracking to javafx.fxml;
    exports com.livtrack.livreurstracking;
}