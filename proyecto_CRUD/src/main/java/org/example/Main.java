package org.example;

import org.example.model.Employee;
import org.example.repository.EmployeeRepository;
import org.example.repository.Repository;
import org.example.util.DataBaseConnection;
import org.example.view.SwingApp;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println("Listando todos");
        Repository<Employee> repository = new EmployeeRepository();
        repository.findAll().forEach(System.out::println);

        System.out.println("########################\nBuscando por ID");
        System.out.println(repository.getById(2));
    }
}
