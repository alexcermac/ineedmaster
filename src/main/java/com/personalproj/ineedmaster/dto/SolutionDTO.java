package com.personalproj.ineedmaster.dto;

import com.personalproj.ineedmaster.models.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SolutionDTO {
    private Integer id;
    @NotNull(message = "Master id should not be null.")
    private Integer userId;
    @NotNull(message = "Category should not be null.")
    private Integer categoryId;
    @NotNull(message = "Subcategory should not be null.")
    private Integer subcategoryId;
    @NotBlank(message = "Title should not be empty.")
    private String title;
    @NotBlank(message = "Description should not be empty.")
    private String description;
    @NotBlank(message = "Type should not be empty.")
    private String type;
    private float price;
    @NotNull(message = "County id should not be null.")
    private Integer countyId;
    @NotNull(message = "City id should not be null.")
    private Integer cityId;
    @NotNull(message = "Start hour should not be null.")
    private String startHour;
    @NotNull(message = "End hour should not be null.")
    private String endHour;
}