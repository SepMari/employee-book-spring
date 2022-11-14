package com.example.employeebookspring.service;

import com.example.employeebookspring.model.Employee;
import com.example.employeebookspring.record.EmployeeRequest;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final Map<Integer, Employee> employees = new HashMap<>();

    public Collection<Employee> getAllEmployees() {
        return this.employees.values();
    }

    public Employee addEmployee(EmployeeRequest employeeRequest) {
        if (employeeRequest.getFirstName() == null || employeeRequest.getLastName() == null) {
            throw new IllegalArgumentException("Неверно заполнены данные имя или фамилия!");
        }
        Employee employee = new Employee(employeeRequest.getFirstName(), employeeRequest.getLastName(), employeeRequest.getDepartment(), employeeRequest.getSalary());

        this.employees.put(employee.getId(), employee);
        return employee;
    }

    public int getSalarySum() {
        return employees.values().stream()
                .mapToInt(e -> e.getSalary())
                .sum();
    }

    public OptionalInt getSalaryMin() {
        return employees.values().stream()
                .mapToInt(Employee::getSalary)
                .min();
    }


    public OptionalInt getSalaryMax() {
        return employees.values().stream()
                .mapToInt(e -> e.getSalary())
                .max();
    }

    public double getSalaryAverage() {
        return employees.values().stream()
                .mapToInt(e -> e.getSalary())
                .average().orElse(0);
    }

    public List<Employee> getEmployeeSalaryAverage() {
        return employees.values().stream()
                .filter(e -> e.getSalary() > getSalaryAverage())
                .collect(Collectors.toList());
    }

}
