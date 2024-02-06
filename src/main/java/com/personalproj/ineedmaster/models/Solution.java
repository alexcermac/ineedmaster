package com.personalproj.ineedmaster.models;

import jakarta.persistence.*;
//import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Solution {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;
//    private Integer masterId;
//    private Integer categoryId;
//    private Integer subcategoryId;
    private String title;
//    private String description;
//    private String type;    // check OR cost/task
//    private float price;
//    private Integer countyId;
    @ManyToOne()
    @JoinColumn(name = "city_id")
//    private Integer cityId;
    private City city;
//    private String startHour;
//    private String endHour;
}
