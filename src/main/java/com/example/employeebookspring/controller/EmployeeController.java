package com.example.employeebookspring.controller;


import com.example.employeebookspring.model.Employee;
import com.example.employeebookspring.record.EmployeeRequest;
import com.example.employeebookspring.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.OptionalInt;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("")
    public Collection<Employee> getAllEmployees() {
        return this.employeeService.getAllEmployees();
    }

    @PostMapping("")
    public Employee createEmployee(@RequestBody EmployeeRequest employeeRequest) {
        return this.employeeService.addEmployee(employeeRequest);
    }

    @GetMapping("/salary/sum")
    public int getSalarySum() {
        return this.employeeService.getSalarySum();
    }

    @GetMapping("/salary/min")
    public int getSalaryMin() {
        return this.employeeService.getSalaryMin();
    }

    @GetMapping("/salary/max")
    public int getSalaryMax() {
        return this.employeeService.getSalaryMax();
    }

    @GetMapping("/salary/average")
    public double getSalaryAverage() {
        return this.employeeService.getSalaryAverage();
    }

    @GetMapping("/salary/allEmployee")
    public List<Employee> getEmployeeSalaryAverage() {
        return this.employeeService.getEmployeeSalaryAverage();
    }

}
