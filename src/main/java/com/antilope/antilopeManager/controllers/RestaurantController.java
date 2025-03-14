package com.antilope.antilopeManager.controllers;

import com.antilope.antilopeManager.models.RestaurantCard;
import com.antilope.antilopeManager.services.RestaurantCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RestaurantController {
    @Autowired
    private RestaurantCardService restaurantService;
    @GetMapping("/")
    public String showRestaurantCards(Model model) {
        List<RestaurantCard> restaurantCards = restaurantService.getAllCards();
        model.addAttribute("restaurantCards", restaurantCards);
        return "index";
    }
}

