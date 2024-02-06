package com.personalproj.ineedmaster.dto;

import com.personalproj.ineedmaster.models.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SolutionDTO {
    private Integer id;
    @NotNull(message = "Master id should not be null.")
//    private Integer masterId;
    private Integer userId;
//    private String category;
//    private String subcategory;
    @NotBlank(message = "Title should not be empty.")
    private String title;
//    private String description;
//    private String type;
//    private float price;
//    private Integer countyId;
    @NotNull(message = "City id should not be null.")
    private Integer cityId;
//    private String startHour;
//    private String endHour;
}