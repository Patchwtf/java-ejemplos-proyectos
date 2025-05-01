package org.example.view;


import org.example.model.Employee;
import org.example.repository.EmployeeRepository;
import org.example.repository.Repository;

import javax.swing.*;

public class SwingApp extends JFrame {

    private final Repository<Employee> employeeRepository;
    private final JTable employeeTable;

    public SwingApp(){
        employeeTable = new JTable();
        employeeRepository = new EmployeeRepository();
    }

}
