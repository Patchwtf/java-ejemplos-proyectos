package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public Conexion() {
    }
    public Connection get_connection() throws SQLException {
        Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mensajes_app", "root", "");
        return myConn;
    };


}
