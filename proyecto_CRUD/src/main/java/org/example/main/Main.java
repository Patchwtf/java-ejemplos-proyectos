package org.example.main;

//Se utiliza la base de datos del proyecto JDBC_Oracle_ejemplo

import org.example.model.Employee;
import org.example.repository.EmployeeRepository;
import org.example.repository.Repository;
import org.example.util.DataBaseConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        try (Connection myConn = DataBaseConnection.getIntance();){
            Repository<Employee> repository = new EmployeeRepository();
            repository.findAll().forEach(System.out::println);
            System.out.println("\n" + repository.getById(5));

            System.out.println("\nInsertando empleado\n");
            Employee employee = new Employee();
            employee.setFirst_name("Miles");
            employee.setPa_surname("Morales");
            employee.setMa_surname("Rivera");
            employee.setEmail("miles@mail.com");
            employee.setSalary(5000.99f);
            repository.save(employee);
            repository.findAll().forEach(System.out::println);

            System.out.println("\nActualizacion empleado\n");
            employee.setId(6);
            employee.setMa_surname("Sanchez");
            employee.setEmail("miles_morales@mail.com");
            repository.save(employee);
            repository.findAll().forEach(System.out::println);

            System.out.println("\nEliminacion empleado\n");
            repository.delete(6);
            repository.findAll().forEach(System.out::println);
        }
    }
}