package yyit.base.services;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import yyit.base.dao.EmployeeRepository;
import yyit.base.domain.Employee;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @InjectMocks
    EmployeeService service;

    @Mock
    EmployeeRepository dao;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAllEmployees()
    {
        List<Employee> list = new ArrayList<Employee>();
        Employee empOne = new Employee("John", "John");
        Employee empTwo = new Employee("Alex", "kolenchiski");
        Employee empThree = new Employee("Steve", "Waugh");

        list.add(empOne);
        list.add(empTwo);
        list.add(empThree);

        when(dao.findAll()).thenReturn(list);

        //test
        List<Employee> empList = service.findAll();

        assertEquals(3, empList.size());
        verify(dao, times(1)).findAll();
    }

    @Test
    void testCreateOrSaveEmployee()
    {
        Employee employee = new Employee("Lokesh","Gupta");

        service.save(employee);

        verify(dao, times(1)).save(employee);
    }

}