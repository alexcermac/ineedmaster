package com.personalproj.ineedmaster.dto;

import com.personalproj.ineedmaster.models.TaskStatus;
import lombok.Data;

import java.util.Date;

@Data
public class TaskResponseDTO {
    private Integer id;
    private Integer customerId;
    private Integer masterId;
    private String masterFirstName;

    private String solutionCategoryName;
    private String solutionSubcategoryName;
    private String solutionTitle;
    private String solutionDescription;
    private String solutionType;
    private String solutionPrice;

    private Date date;
    private String startHour;
    private String endHour;
    private TaskStatus status;
    private String address;
}
