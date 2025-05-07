package org.example.main;

import org.example.Util.UtilEntity;
import org.example.entity.Employee;

import javax.persistence.EntityManager;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManager em = UtilEntity.getEntityManager();
        List<Employee> employees = em.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
        System.out.println("-------------------Listar Todos----------------");
        employees.forEach(System.out::println);

        System.out.println("------------------Buscar Uno-------------------");
        int employeeId = 3;
        Employee employee = em.find(Employee.class, employeeId);
        System.out.println("Empleado encontrado" + employee);


        System.out.println("------------------Crear Uno-------------------");
        Employee newEmployee = new Employee();

        newEmployee.setFirstName("Dalia");
        newEmployee.setPaSurname("Perez");
        newEmployee.setMaSurname("Sanchez");
        newEmployee.setMail("dalia@mail.com");
        newEmployee.setSalary(400f);

        em.getTransaction().begin();
        em.persist(newEmployee);
        em.getTransaction().commit();

        System.out.println("Empleado creado" + newEmployee + "\n" + newEmployee.getId());

        System.out.println("------------------Actualizar Uno-------------------");
        int employeeToUptId = newEmployee.getId();
        Employee employeeToUpt = em.find(Employee.class, employeeToUptId);
        System.out.println("Empleado a modifiar" + employeeToUpt);

        employeeToUpt.setFirstName("Laurel");
        employeeToUpt.setSalary(80000f);

        em.getTransaction().begin();
        em.merge(employeeToUpt);
        em.getTransaction().commit();
        System.out.println("Empleado actualizado" + employeeToUpt);

        System.out.println("------------------Eliminar Uno-------------------");
        int employeeToDeleteId = newEmployee.getId();
        Employee employeeToDelete = em.find(Employee.class, employeeToDeleteId);

        em.getTransaction().begin();
        em.remove(employeeToDelete);
        em.getTransaction().commit();
        em.close();

    }
}