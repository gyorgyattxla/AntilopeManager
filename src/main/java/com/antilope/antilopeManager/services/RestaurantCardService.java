package com.antilope.antilopeManager.services;

import com.antilope.antilopeManager.models.RestaurantCard;
import com.antilope.antilopeManager.repositories.RestaurantCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantCardService {
    @Autowired
    private RestaurantCardRepository restaurantCardRepository;

    public List<RestaurantCard> getAllCards(){
        return restaurantCardRepository.findAll();
    }
    public RestaurantCard findById(Long id) {
        return restaurantCardRepository.findById(id).orElseThrow(() -> new RuntimeException("Restaurant not found"));
    }

    public void saveCard(RestaurantCard restaurantCard) {
        restaurantCardRepository.save(restaurantCard);
    }
}
