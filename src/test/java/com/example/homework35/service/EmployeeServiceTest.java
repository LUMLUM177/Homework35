package com.example.homework35.service;

import com.example.homework35.model.Employee;
import org.junit.jupiter.api.Test;


import static com.example.homework35.constants.EmployeeServiceTestConstants.*;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {

    private final EmployeeService out = new EmployeeService();

    @Test
    public void shouldReturnFindEmployeeCorrectlyDataEmployees() {
        out.addEmployee(IVAN_REQUEST);
        out.addEmployee(PETR_REQUEST);
        out.addEmployee(NIKOLAY_REQUEST);
        out.addEmployee(VASILIY_REQUEST);
        Employee result = out.findEmployee(7);
        assertEquals(NIKOLAY, result);
    }

    @Test
    public void shouldReturnAddEmployeesWhenCorrectlyDataEmployees() {
        Employee result = out.addEmployee(NIKOLAY_REQUEST);
        assertEquals(result, NIKOLAY);
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
        out.addEmployee(IVAN_REQUEST);
        out.addEmployee(PETR_REQUEST);
        out.addEmployee(NIKOLAY_REQUEST);
        out.addEmployee(VASILIY_REQUEST);
        double result = out.getSalarySum();
        assertEquals(IVAN.getSalary() + PETR.getSalary() + NIKOLAY.getSalary() + VASILIY.getSalary(), result);
    }

    @Test
    public void shouldReturnAverageSalaryWhenCorrectlyDataEmployees() {
        out.addEmployee(IVAN_REQUEST);
        out.addEmployee(PETR_REQUEST);
        out.addEmployee(NIKOLAY_REQUEST);
        out.addEmployee(VASILIY_REQUEST);
        double result = out.getAverageSum();
        assertEquals((IVAN.getSalary() + PETR.getSalary() + NIKOLAY.getSalary() + VASILIY.getSalary()) / 4, result);
    }

    @Test
    public void shouldReturnMinSalaryWhenCorrectlyDataEmployees() {
        out.addEmployee(IVAN_REQUEST);
        out.addEmployee(PETR_REQUEST);
        out.addEmployee(NIKOLAY_REQUEST);
        out.addEmployee(VASILIY_REQUEST);
        Employee result = out.getSalaryMin();
        assertEquals(PETR, result);
    }

    @Test
    public void shouldReturnMaxSalaryWhenCorrectlyDataEmployees() {
        out.addEmployee(IVAN_REQUEST);
        out.addEmployee(PETR_REQUEST);
        out.addEmployee(NIKOLAY_REQUEST);
        out.addEmployee(VASILIY_REQUEST);
        Employee result = out.getSalaryMax();
        assertEquals(IVAN, result);
    }


}