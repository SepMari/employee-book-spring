package com.example.employeebookspring.controller;


import com.example.employeebookspring.model.Employee;
import com.example.employeebookspring.record.EmployeeRequest;
import com.example.employeebookspring.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.OptionalInt;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public Collection<Employee> getAllEmployees() {
        return this.employeeService.getAllEmployees();
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody EmployeeRequest employeeRequest) {
        return this.employeeService.addEmployee(employeeRequest);
    }

    @GetMapping("/employees/salary/sum")
    public int getSalarySum() {
        return this.employeeService.getSalarySum();
    }

    @GetMapping("employees/salary/min")
    public OptionalInt getSalaryMin() {
        return this.employeeService.getSalaryMin();
    }

    @GetMapping("employees/salary/max")
    public OptionalInt getSalaryMax() {
        return this.employeeService.getSalaryMax();
    }

    @GetMapping("employees/salary/average")
    public double getSalaryAverage() {
        return this.employeeService.getSalaryAverage();
    }

    @GetMapping("employees/salary/allEmployee")
    public List<Employee> getEmployeeSalaryAverage() {
        return this.employeeService.getEmployeeSalaryAverage();
    }
}
