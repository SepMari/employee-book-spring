package com.example.employeebookspring;

import com.example.employeebookspring.model.Employee;
import com.example.employeebookspring.service.DepartmentService;
import com.example.employeebookspring.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {
    Employee employee1;
    Employee employee2;
    Employee employee3;
    Employee employee4;

    @Mock
    EmployeeService employeeService;

    @InjectMocks
    DepartmentService departmentService;

    @BeforeEach
    void setUp() {
        employee1 = new Employee("One", "One", 1, 2500);
        employee2 = new Employee("Two", "Two", 1, 4000);
        employee3 = new Employee("Three", "Three", 1, 7500);
        employee4 = new Employee("Four", "Four", 2, 4000);
        when(employeeService.getAllEmployees()).thenReturn(Set.of(employee1, employee2, employee3, employee4));
    }

    @Test
    void getDepartment() {
        var actual = departmentService.getDepartment(1);
        assertEquals(3, actual.size());
        assertTrue(actual.containsAll(List.of(employee1, employee2, employee3)));
    }

    @Test
    void getSalarySumOneDepartment() {
        assertEquals(14000, departmentService.getSalarySumOneDepartment(1));
    }

    @Test
    void getMaxSalaryInDepartment() {
        assertEquals(7500, departmentService.getMaxSalaryInDepartment(1));
    }

    @Test
    void getMinSalaryInDepartment() {
        assertEquals(2500, departmentService.getMinSalaryInDepartment(1));
    }

    @Test
    void getNumberOfDepartment() {
        assertEquals(2, departmentService.getNumberOfDepartment());
    }

    @Test
    void getEmployeesSortedByDepartment() {
        when(departmentService.getNumberOfDepartment()).thenReturn(2);
        assertTrue(departmentService.getEmployeesSortedByDepartment().get(1)
                .containsAll(List.of(employee1, employee2, employee3)));
        assertTrue(departmentService.getEmployeesSortedByDepartment().get(2)
                .contains(employee4));
    }
}
