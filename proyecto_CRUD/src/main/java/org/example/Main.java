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
        try (Connection myConn = DataBaseConnection.getIntance()) {

            if(myConn.getAutoCommit()) myConn.setAutoCommit(false);

            try {
                Repository<Employee> repository = new EmployeeRepository(myConn);
                System.out.println("--------------Incertando cliente------------------");
                Employee employee = new Employee();
                employee.setFirst_name("Gwen");
                employee.setPa_surname("Morales");
                employee.setMa_surname("Rivera");
                employee.setEmail("gwanda@mail.com");
                employee.setSalary(5000.99f);
                employee.setCurp("GMRI242424");
                repository.save(employee);
                myConn.commit();
            } catch (SQLException e) {
                myConn.rollback();
                throw new RuntimeException(e);
            }

        }
    }
}
