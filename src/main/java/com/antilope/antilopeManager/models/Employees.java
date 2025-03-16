package com.antilope.antilopeManager.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import lombok.Builder;
import lombok.Getter;

@Entity
@Builder
@Getter
@Table(name = "employees")
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /* The ID of the employee. */
    private long id;
    /* The ID of the restaurant where the employee works at. */
    private int restaurant_id;
    /* The name of the employee. */
    private String name;
    /* The working position of the employee. */
    private String position;
    /* The number of years the employee has been working at the restaurant. */
    private int e_time;
}
