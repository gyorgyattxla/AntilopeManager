package com.antilope.antilopeManager.repositories;

import com.antilope.antilopeManager.models.RestaurantCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantCardRepository extends JpaRepository<RestaurantCard,Long> {

}
