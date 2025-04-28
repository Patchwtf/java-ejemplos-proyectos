package org.example.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    private static String url = "jdbc:mysql://localhost:3306/project";
    private static String user ="root";
    private static String password = "12345";
    private static Connection myConn;
    public static Connection main(String[] args) throws SQLException {
        if(myConn == null){
            myConn = DriverManager.getConnection(url, user, password);
        }
        return myConn;
    }

}
