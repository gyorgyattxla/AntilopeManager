package com.antilope.antilopeManager.models;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Entity
@Builder
@Getter
@Table(name = "employees")
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int restaurant_id;
    private String name;
    private String position;
    private int e_time;
}
