package com.example.homework35.service;

import com.example.homework35.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private DepartmentService departmentService;

    private List<Employee> actualEmployees;

    @BeforeEach
    public void setUp() {
        Employee ivan = new Employee("Ivan", "Ivanov", 1, 30000);
        Employee petr = new Employee("Petr", "Petrov", 1, 10000);
        Employee nikolay = new Employee("Nikolay", "Nikolaev", 2, 25000);
        Employee vasiliy = new Employee("Vasiliy", "Vasiliev", 2, 15000);

        actualEmployees = new ArrayList<>(List.of(ivan, petr, nikolay, vasiliy));

        when(employeeService.getEmployeesList()).thenReturn(actualEmployees);
    }

    @Test
    public void shouldReturnEmployeesFromDepartment() {
        final int departmentId = 1;

        final List<Employee> actual = new ArrayList<>();
        for (int i = 0; i < actualEmployees.size(); i++) {
            if (actualEmployees.get(i).getDepartment() == departmentId) {
                actual.add(actualEmployees.get(i));
            }
        }

        final List<Employee> expected = departmentService.getAllEmployeesInDepartmentToList(departmentId);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnAllEmployees() {

        final Map<Integer, List<Employee>> actual = new HashMap<>();
        for (int i = 0; i < actualEmployees.size(); i++) {
            List<Employee> employees = new ArrayList<>();
            if (actual.containsKey(actualEmployees.get(i).getDepartment())) {
                employees = actual.get(actualEmployees.get(i).getDepartment());
            }
            employees.add(actualEmployees.get(i));
            actual.put(actualEmployees.get(i).getDepartment(), employees);
        }

        final Map<Integer, List<Employee>> expected = departmentService.getAllEmployees();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnSalarySumFromDepartment() {
        final int departmentId = 1;

        double actual = 0;
        for (int i = 0; i < actualEmployees.size(); i++) {
            if (actualEmployees.get(i).getDepartment() == departmentId) {
                actual += actualEmployees.get(i).getSalary();
            }
        }

        final double expected = departmentService.getSalarySumInDepartment(departmentId);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnSalaryMinFromDepartment() {
        final int departmentId = 1;

        double actual = Double.MAX_VALUE;
        for (int i = 0; i < actualEmployees.size(); i++) {
            if (actualEmployees.get(i).getDepartment() == departmentId &&
                   actualEmployees.get(i).getSalary() < actual) {
                actual = actualEmployees.get(i).getSalary();
            }
        }

        final double expected = departmentService.getSalaryMinInDepartment(departmentId);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnSalaryMaxFromDepartment() {
        final int departmentId = 2;

        double actual = Double.MIN_VALUE;
        for (int i = 0; i < actualEmployees.size(); i++) {
            if (actualEmployees.get(i).getDepartment() == departmentId &&
                    actualEmployees.get(i).getSalary() > actual) {
                actual = actualEmployees.get(i).getSalary();
            }
        }

        final double expected = departmentService.getSalaryMaxInDepartment(departmentId);

        assertEquals(expected, actual);
    }


}