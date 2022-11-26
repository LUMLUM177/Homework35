package com.example.homework35.service;

import com.example.homework35.model.Employee;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;

import static com.example.homework35.constants.EmployeeServiceTestConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {

    @Mock
    private EmployeeService repositoryMock;

    @InjectMocks
    private DepartmentService out;

    @Test
    public void shouldReturnCollectionOfTeamsWhenFindAllTeamsCalled() {
        when(repositoryMock.getAllEmployees())
                .thenReturn(EMPLOYEE_LIST);

        assertIterableEquals(EMPLOYEE_LIST, out.getAllEmployeesInDepartment(1));
    }








}