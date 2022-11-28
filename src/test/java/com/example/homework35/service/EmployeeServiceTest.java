package com.example.homework35.service;

import com.example.homework35.model.Employee;
import com.example.homework35.record.EmployeeRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {

    public static final Integer KEY_NOT_EXIST = Integer.MAX_VALUE;
    public static final EmployeeRequest NULL_FIRST_NAME = new EmployeeRequest(null, "Ivanov", 1, 10000);
    public static final EmployeeRequest NULL_LAST_NAME = new EmployeeRequest("Ivan", null, 1, 10000);
    public static final EmployeeRequest ILLEGAL_CHARACTERS_FIRST_NAME = new EmployeeRequest("Ivan1", "Ivanov", 1, 10000);
    public static final EmployeeRequest ILLEGAL_CHARACTERS_LAST_NAME = new EmployeeRequest("Ivan", "Ivanov!!", 1, 10000);
    public static final Employee NULL_EMPLOYEE_FOR_TEST = new Employee(null, null, 1, 1);

    private final EmployeeService out = new EmployeeService();

    private List<Employee> actualEmployees;

    @BeforeEach
    public void setUp() {
        Employee ivan = new Employee("Ivan", "Ivanov", 1, 30000);
        EmployeeRequest ivan_request = new EmployeeRequest("Ivan", "Ivanov", 1, 30000);
        Employee petr = new Employee("Petr", "Petrov", 1, 10000);
        EmployeeRequest petr_request = new EmployeeRequest("Petr", "Petrov", 1, 10000);
        Employee nikolay = new Employee("Nikolay", "Nikolaev", 2, 25000);
        EmployeeRequest nikolay_request = new EmployeeRequest("Nikolay", "Nikolaev", 2, 25000);
        Employee vasiliy = new Employee("Vasiliy", "Vasiliev", 2, 15000);
        EmployeeRequest vasiliy_request = new EmployeeRequest("Vasiliy", "Vasiliev", 2, 15000);

        out.addEmployee(ivan_request);
        out.addEmployee(petr_request);
        out.addEmployee(nikolay_request);
        out.addEmployee(vasiliy_request);

        actualEmployees = new ArrayList<>(List.of(ivan, petr, nikolay, vasiliy));
    }

    @Test
    public void shouldReturnFindEmployeeCorrectlyDataEmployees() {
        int departmentId = 7;
        Employee actual = NULL_EMPLOYEE_FOR_TEST;
        for (int i = 0; i < actualEmployees.size(); i++) {
            if (actualEmployees.get(i).getId() == 3) {
                actual = new Employee(actualEmployees.get(i).getFirstName(),
                        actualEmployees.get(i).getLastName(),
                        actualEmployees.get(i).getDepartment(),
                        actualEmployees.get(i).getSalary());
            }
        }
        Employee result = out.findEmployee(departmentId);
        assertEquals(actual, result);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenFirstNameIsNull() {
        assertThrows(IllegalArgumentException.class,
                () -> out.addEmployee(NULL_FIRST_NAME)
        );
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenLastNameIsNull() {
        assertThrows(IllegalArgumentException.class,
                () -> out.addEmployee(NULL_LAST_NAME)
        );
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenFirstNameContainsIllegalCharacters() {
        assertThrows(RuntimeException.class,
                () -> out.addEmployee(ILLEGAL_CHARACTERS_FIRST_NAME)
        );
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenLastNameContainsIllegalCharacters() {
        assertThrows(RuntimeException.class,
                () -> out.addEmployee(ILLEGAL_CHARACTERS_LAST_NAME)
        );
    }

    @Test
    public void shouldThrowRuntimeExceptionRemoveWhenIdNotExist() {
        assertThrows(RuntimeException.class,
                () -> out.removeEmployee(KEY_NOT_EXIST)
        );
    }

    @Test
    public void shouldThrowRuntimeExceptionFindWhenIdNotExist() {
        assertThrows(RuntimeException.class,
                () -> out.findEmployee(KEY_NOT_EXIST)
        );
    }


    @Test
    public void shouldReturnSalaryWhenCorrectlyDataEmployees() {
        double actual = 0;
        for (int i = 0; i < actualEmployees.size(); i++) {
            actual += actualEmployees.get(i).getSalary();
        }
        double result = out.getSalarySum();
        assertEquals(actual, result);
    }

    @Test
    public void shouldReturnAverageSalaryWhenCorrectlyDataEmployees() {
        double actual = 0;
        double sum = 0;
        for (int i = 0; i < actualEmployees.size(); i++) {
            sum += actualEmployees.get(i).getSalary();
        }
        actual = sum / actualEmployees.size();
        double result = out.getAverageSum();

        assertEquals(actual, result);
    }

    @Test
    public void shouldReturnMinSalaryWhenCorrectlyDataEmployees() {
        double min = Double.MAX_VALUE;
        Employee actual = NULL_EMPLOYEE_FOR_TEST;
        for (int i = 0; i < actualEmployees.size(); i++) {
            if (actualEmployees.get(i).getSalary() < min) {
                min = actualEmployees.get(i).getSalary();
                actual = new Employee(actualEmployees.get(i).getFirstName(),
                        actualEmployees.get(i).getLastName(),
                        actualEmployees.get(i).getDepartment(),
                        actualEmployees.get(i).getSalary());
            }
        }

        Employee result = out.getSalaryMin();

        assertEquals(actual, result);
    }

    @Test
    public void shouldReturnMaxSalaryWhenCorrectlyDataEmployees() {
        double max = Double.MIN_VALUE;
        Employee actual = NULL_EMPLOYEE_FOR_TEST;
        for (int i = 0; i < actualEmployees.size(); i++) {
            if (actualEmployees.get(i).getSalary() > max) {
                max = actualEmployees.get(i).getSalary();
                actual = new Employee(actualEmployees.get(i).getFirstName(),
                        actualEmployees.get(i).getLastName(),
                        actualEmployees.get(i).getDepartment(),
                        actualEmployees.get(i).getSalary());
            }
        }
        Employee result = out.getSalaryMax();
        assertEquals(actual, result);
    }


}