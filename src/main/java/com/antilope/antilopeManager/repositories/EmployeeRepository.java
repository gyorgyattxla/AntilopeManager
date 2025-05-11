package com.antilope.antilopeManager.repositories;

import com.antilope.antilopeManager.models.Employees;
import com.antilope.antilopeManager.models.RestaurantCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employees, Long> {
    List<Employees> findByRestaurantCard(RestaurantCard restaurantCard);
}
