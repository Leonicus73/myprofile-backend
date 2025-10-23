package com.expenditure.myprofile_backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.UUID;

@Entity
@Table(name = "expenditures")
@Data
public class Expenditure {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private double price;

    // Getters and Setters
}
