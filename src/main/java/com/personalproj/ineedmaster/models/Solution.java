package com.personalproj.ineedmaster.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Solution {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private Integer userId;
//    private Integer categoryId;
//    private Integer subcategoryId;
    private String title;
//    private String description;
//    private String type;
//    private float price;
//    private Integer countyId;
//    private Integer cityId;
//    private String startHour;
//    private String endHour;
}
