package org.example.util;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    private static String url = "jdbc:mysql://localhost:3306/project";
    private static String user ="root";
    private static String password = "12345";
    private static BasicDataSource pool;
    public static BasicDataSource getIntance() throws SQLException {
        if(pool == null){
            pool = new BasicDataSource();
            pool.setUrl(url);
            pool.setUsername(user);
            pool.setPassword(password);

            pool.setInitialSize(3);
            pool.setMinIdle(2);
            pool.setMaxIdle(10);
            pool.setMaxTotal(10); //Conexiones Activas Simultaneas
        }
        return pool;
    }

    public static Connection getConnection() throws SQLException {
        return getIntance().getConnection();
    }

}
