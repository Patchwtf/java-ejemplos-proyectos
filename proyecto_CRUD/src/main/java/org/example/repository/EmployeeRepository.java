package org.example.repository;

import org.example.model.Employee;
import org.example.util.DataBaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements  Repository<Employee>{

//    private Connection myConn throws SQLException {
//        return DataBaseConnection.getIntance();
//    };

    private Connection myConn;

    public EmployeeRepository(Connection myConn) {
        this.myConn = myConn;
    }


    @Override
    public List<Employee> findAll() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        try(Statement myStamt = myConn.createStatement();
            ResultSet myRes = myStamt.executeQuery("SELECT * FROM employees");){
            while(myRes.next()){
                employees.add(createEmployee(myRes));
            }
            return employees;
        }
    }

    @Override
    public Employee getById(Integer id) throws SQLException {
        Employee employee = null;
        try(PreparedStatement myStamt = myConn.prepareStatement("SELECT * FROM employees WHERE ID = ?");
        ){
            myStamt.setInt(1, id);
            try(ResultSet myRes = myStamt.executeQuery();){
                if(myRes.next())employee = createEmployee(myRes);
            }
            return employee;
        }
    }

    @Override
    public void save(Employee employee) throws SQLException {
        String sql;
        if (employee.getId() != null && employee.getId() > 0){
            sql = "UPDATE employees set first_name = ?, pa_surname = ?, ma_surname = ?, email = ?, salary = ?, curp = ? where id = ?";
        } else {
             sql = "INSERT INTO employees (first_name, pa_surname, ma_surname, email, salary, curp) values (?,?,?,?,?,?)";
        }
        try (PreparedStatement myStamt = myConn.prepareStatement(sql)){
            myStamt.setString(1, employee.getFirst_name());
            myStamt.setString(2, employee.getPa_surname());
            myStamt.setString(3, employee.getMa_surname());
            myStamt.setString(4, employee.getEmail());
            myStamt.setFloat(5, employee.getSalary());
            myStamt.setString(6, employee.getCurp());
            if (employee.getId() != null && employee.getId() > 0) myStamt.setInt(7, employee.getId());
            myStamt.executeUpdate();
            System.out.println("Se insertó/actualizó el usuario " + employee.getFirst_name());
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try(PreparedStatement myStamt = myConn.prepareStatement("DELETE FROM employees where id = ?")){
            myStamt.setInt(1, id);
            myStamt.executeUpdate();

        }
    }

    private static Employee createEmployee(ResultSet myRes) throws SQLException {
        Employee e = new Employee();
        e.setId(myRes.getInt("id"));
        e.setFirst_name(myRes.getString("first_name"));
        e.setPa_surname(myRes.getString("pa_surname"));
        e.setMa_surname(myRes.getString("ma_surname"));
        e.setEmail(myRes.getString("email"));
        e.setSalary(myRes.getFloat("salary"));
        e.setCurp(myRes.getString("curp"));
        return e;
    }
}