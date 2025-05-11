package com.antilope.antilopeManager.services;

import com.antilope.antilopeManager.models.Employees;
import com.antilope.antilopeManager.models.RestaurantCard;
import com.antilope.antilopeManager.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeesRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    public List<Employees> getEmployeesByRestaurant(RestaurantCard
                                                            restaurantCard) {
        return employeesRepository.findByRestaurantCard(restaurantCard);
    }
}
