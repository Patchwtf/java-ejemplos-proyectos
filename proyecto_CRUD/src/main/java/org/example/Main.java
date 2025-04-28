package org.example;

//Se utiliza la base de datos del proyecto JDBC_Oracle_ejemplo

import org.example.util.DataBaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try (Connection myConn = DataBaseConnection.getIntance();
             Statement myStamt = myConn.createStatement();
             ResultSet myRes = myStamt.executeQuery("SELECT * from employees");){

            while(myRes.next()) System.out.println(myRes.getString("first_name"));

        }catch (Exception e){
            System.out.println("Algo salio mal, chale" + e.getLocalizedMessage());
        }
    }
}