package com.example.employeebookspring;

import com.example.employeebookspring.model.Employee;
import com.example.employeebookspring.record.EmployeeRequest;
import com.example.employeebookspring.service.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceTest {

    EmployeeService employeeService;
    Employee employee1;
    Employee employee2;
    Employee employee3;

    @BeforeEach
    void setUp() {
        employeeService = new EmployeeService();
        employee1 = employeeService.addEmployee(new EmployeeRequest("One", "one", 1, 2500));
        employee2 = employeeService.addEmployee(new EmployeeRequest("Two", "Two", 1, 4000));
        employee3 = employeeService.addEmployee(new EmployeeRequest("Three", "Tree", 2, 7000));
    }

    @Test
    void getAllEmployees() {
        Collection<Employee> actual = employeeService.getAllEmployees();
        assertEquals(3, actual.size());
        Assertions.assertTrue(actual.containsAll(List.of(employee1, employee2, employee3)));
    }

    @Test
    void addValidEmployee() {
        EmployeeRequest request = new EmployeeRequest("Test", "Test", 1, 1250);
        Employee employee = employeeService.addEmployee(request);
        assertEquals(employee.getFirstName(), request.getFirstName());
        assertEquals(employee.getLastName(), request.getLastName());
        assertEquals(employee.getDepartment(), request.getDepartment());
        assertEquals(employee.getSalary(), request.getSalary());
    }

    @Test
    void addInvalidFirstNameEmployee() {
        EmployeeRequest test = new EmployeeRequest("123", "Test", 6, 2000);
        assertThrows(ResponseStatusException.class, () -> employeeService.addEmployee(test));
    }

    @Test
    void addInvalidLastNameEmployee() {
        EmployeeRequest test2 = new EmployeeRequest("test", "123", 1, 2500);
        assertThrows(ResponseStatusException.class, () -> employeeService.addEmployee(test2));
    }

    @Test
    void addSameEmployee() {
        employeeService.addEmployee(new EmployeeRequest("test", "test", 1, 10000));
        employeeService.addEmployee(new EmployeeRequest("test2", "test2", 1, 10000));
        assertEquals(5, employeeService.getAllEmployees().size());
    }

    @Test
    void getSalarySum() {
        assertEquals(13500, employeeService.getSalarySum());
    }

    @Test
    void getMinSalary() {
        assertEquals(2500, employeeService.getSalaryMin());
    }

    @Test
    void getMaxSalary() {
        assertEquals(7000, employeeService.getSalaryMax());
    }

}
