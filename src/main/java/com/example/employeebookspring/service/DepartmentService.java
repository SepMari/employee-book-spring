package com.example.employeebookspring.service;

import com.example.employeebookspring.model.Employee;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DepartmentService {
    public EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public List<Employee> getDepartment(int id) {
        return employeeService.getAllEmployees().stream()
                .filter(e -> e.getDepartment() == id)
                .collect(Collectors.toList());
    }

    public int getSalarySumOneDepartment(int id) {
        return getDepartment(id).stream().
                mapToInt(Employee::getSalary).
                sum();
    }

    public int getMaxSalaryInDepartment(int id) {
        return getDepartment(id).stream()
                .map(Employee::getSalary)
                .max(Integer::compareTo)
                .orElseGet(() -> 0);
    }

    public int getMinSalaryInDepartment(int id) {
        return getDepartment(id).stream()
                .map(Employee::getSalary)
                .min(Integer::compareTo)
                .orElseGet(() -> 0);
    }

    public int getNumberOfDepartment() {
        return employeeService.getAllEmployees().stream()
                .map(Employee::getDepartment)
                .max(Integer::compareTo)
                .orElseGet(() -> 0);
    }

    public Map<Integer, List<Employee>> getEmployeesSortedByDepartment() {
        int number = getNumberOfDepartment();
        Map<Integer, List<Employee>> result = new HashMap<>();
        for (int i = 1; i <= number ; i++) {
            result.put(i, getDepartment(i));
        }
        return result;
    }

}
