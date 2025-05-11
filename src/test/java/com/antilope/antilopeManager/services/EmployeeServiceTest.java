package com.antilope.antilopeManager.services;

import com.antilope.antilopeManager.models.Employees;
import com.antilope.antilopeManager.models.RestaurantCard;
import com.antilope.antilopeManager.repositories.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class EmployeeServiceTest {
    private EmployeeRepository employeeRepository;
    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        employeeRepository = mock(EmployeeRepository.class);
        employeeService = new EmployeeService(employeeRepository);
    }

    @Test
    void testGetEmployeesByRestaurant() {
        // GIVEN
        RestaurantCard mockRestaurant = new RestaurantCard();
        Employees employee1 = new Employees();
        Employees employee2 = new Employees();
        List<Employees> expectedEmployees = Arrays.asList(employee1, employee2);

        when(employeeRepository.findByRestaurantCard(mockRestaurant)).thenReturn(expectedEmployees);

        // WHEN
        List<Employees> result = employeeService.getEmployeesByRestaurant(mockRestaurant);

        // THEN
        assertEquals(expectedEmployees, result);
        verify(employeeRepository, times(1)).findByRestaurantCard(mockRestaurant);
    }
}
