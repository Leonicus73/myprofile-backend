package com.expenditure.myprofile_backend.dto;

import lombok.Data;

@Data
public class MongoExpenditureDTO {
    private String _id; // MongoDB internal ID
    private String id;  // UUID stored in MongoDB
    private String name;
    private double price;
}

