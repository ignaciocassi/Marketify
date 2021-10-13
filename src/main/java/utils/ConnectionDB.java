package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    public Connection get_Connection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/marketify", "root", "40454481Nacho");
            if (conn != null) {
                System.out.println("Conectado correctamente.");
            }
        } catch (SQLException e) {
            System.out.println("Error al conectarse a la base de datos.");
        }
        return conn;
    }
}
