package com.antilope.antilopeManager.controllers;

import com.antilope.antilopeManager.models.RestaurantCard;
import com.antilope.antilopeManager.repositories.RestaurantCardRepository;
import com.antilope.antilopeManager.services.RestaurantCardService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
    @GetMapping("/{id}")
    public String showRestaurantDetails(@PathVariable Long id, Model model) {
        RestaurantCard restaurantCards = restaurantService.findById(id);
        model.addAttribute("restaurantCards", restaurantCards);
        return "view.html";
    }
    @GetMapping("/create")
    public String showRestaurantCreation(Model model){
        model.addAttribute("restaurantCard", new RestaurantCard());
        return "create.html";
    }
    @PostMapping("/create")
    public String submitForm(@ModelAttribute RestaurantCard restaurantCard) {
        restaurantService.saveCard(restaurantCard);
        return "redirect:/";
    }
}

