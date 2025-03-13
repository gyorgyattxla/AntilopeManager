package com.antilope.antilopeManager.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int restaurant_id;
    private String name;
    private String position;
    private int e_time;
}
