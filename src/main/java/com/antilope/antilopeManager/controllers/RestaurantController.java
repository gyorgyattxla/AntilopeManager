package com.antilope.antilopeManager.controllers;

import com.antilope.antilopeManager.models.RestaurantCard;
import com.antilope.antilopeManager.services.RestaurantCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Controller
public final class RestaurantController {

    @Autowired
    private RestaurantCardService restaurantService;

    private static final String UPLOAD_DIR = "src/main/resources/static/images/";

    @GetMapping("/")
    public String showRestaurantCards(Model model) {
        List<RestaurantCard> restaurantCards = restaurantService.getAllCards();
        model.addAttribute("restaurantCards", restaurantCards);
        return "index.html";
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
    public String submitForm(@ModelAttribute RestaurantCard restaurantCard,
                             @RequestParam("file")MultipartFile file,
                             Model model) {
        if (!file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            try {
                File directory = new File(UPLOAD_DIR);
                if (!directory.exists()){
                    directory.mkdirs();
                }
                Files.copy(file.getInputStream(), Paths.get(UPLOAD_DIR + fileName));

                String relativePath = "/images/" + fileName;
                restaurantCard.setImagepath(relativePath);

                restaurantService.saveCard(restaurantCard);
            } catch (IOException e) {
                model.addAttribute("message", "Restaurant creation failed: " + e.getMessage());
            }
        }
        else {
            restaurantCard.setImagepath("/images/missing_img2.png");
            restaurantService.saveCard(restaurantCard);
        }
        return "redirect:/";
    }

    @PostMapping("/{id}/delete")
    public String deleteRestaurant(@PathVariable Long id, Model model){
        RestaurantCard restaurantCard = restaurantService.findById(id);
        restaurantService.deleteCard(restaurantCard);
        return "redirect:/";
    }
}

