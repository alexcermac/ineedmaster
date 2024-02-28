package com.personalproj.ineedmaster.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SolutionSearchResponseDTO {
    private Integer id;
    private Integer userId;
    private String userFirstName;
    private Integer categoryId;
    private String categoryName;
    private Integer subcategoryId;
    private String subcategoryName;
    private String title;
    private String description;
    private String type;
    private float price;
    private Integer countyId;
    private String countyName;
    private Integer cityId;
    private String cityName;
    private String startHour;
    private String endHour;
}
