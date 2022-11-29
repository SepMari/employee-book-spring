package com.example.employeebookspring.controller;

import com.example.employeebookspring.model.Employee;
import com.example.employeebookspring.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employees/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{id}/employees")
    public List<Employee> getDepartment(@PathVariable("id") int id) {
        return this.departmentService.getDepartment(id);
    }

    @GetMapping("/{id}/salary/sum")
    public int getSalarySumOneDepartment(@PathVariable("id") int id) {
        return this.departmentService.getSalarySumOneDepartment(id);
    }

    @GetMapping("/{id}/salary/max")
    public int getMaxSalaryInDepartment(@PathVariable("id") int id) {
        return this.departmentService.getMaxSalaryInDepartment(id);
    }

    @GetMapping("/{id}/salary/min")
    public int getMinSalaryInDepartment(@PathVariable("id") int id) {
        return this.departmentService.getMinSalaryInDepartment(id);
    }

    @GetMapping("/employees")
    public Map<Integer, List<Employee>> getEmployeesSortedByDepartment() {
        return this.departmentService.getEmployeesSortedByDepartment();
    }

}
