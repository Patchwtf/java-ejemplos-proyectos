package org.example;

//Se utiliza la base de datos del proyecto JDBC_Oracle_ejemplo

import org.example.model.Employee;
import org.example.repository.EmployeeRepository;
import org.example.repository.Repository;
import org.example.util.DataBaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException {
        try (Connection myConn = DataBaseConnection.getIntance();){
            Repository<Employee> repository = new EmployeeRepository();
            repository.findAll().forEach(System.out::println);
        }
    }
}