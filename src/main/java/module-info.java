module com.ignaciocassi {
    requires javafx.controls;
    requires transitive javafx.graphics;
    requires javafx.fxml;
    requires java.sql;
    opens controllers to javafx.fxml;
    exports com.ignaciocassi;
}