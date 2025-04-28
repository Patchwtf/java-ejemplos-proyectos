package org.example;
import java.sql.*;
import java.util.HashMap;

//Se utiliza la base de datos del proyecto JDBC_Oracle_ejemplo

public class Main {
    public static void main(String[] args) {
        HashMap<String, String> datos = new HashMap<>(4) {
            {
                put("link", "jdbc:mysql://localhost:3306/project");
                put("user", "root");
                put("pwd", "12345");
                put("query", "");
            }};
    }
}