package com.antilope.antilopeManager.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Table(name = "restaurants")
public class RestaurantCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    public String restaurant_name;
    public String restaurant_location;
    private String restaurant_manager;
    private byte[] restaurant_image;
}
