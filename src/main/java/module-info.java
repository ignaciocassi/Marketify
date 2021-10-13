module com.ignaciocassi {
    requires javafx.controls;
    requires transitive javafx.graphics;
    requires javafx.fxml;
    requires java.sql;
    requires java.naming;
    requires org.hibernate.orm.core;
    requires java.persistence;
    opens controllers to javafx.fxml;
    exports com.ignaciocassi;
}