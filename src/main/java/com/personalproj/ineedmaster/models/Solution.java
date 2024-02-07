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

//    private Integer categoryId;
//    private Integer subcategoryId;
    @ManyToOne()
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne()
    @JoinColumn(name = "subcategory_id")
    private Subcategory subcategory;

    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private Type type;    // check OR cost/task

    private float price;

    @ManyToOne()
    @JoinColumn(name = "county_id")
    private County county;

    @ManyToOne()
    @JoinColumn(name = "city_id")
    private City city;

    private String startHour;
    private String endHour;
}
