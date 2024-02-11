package com.personalproj.ineedmaster.dto;

import com.personalproj.ineedmaster.models.TaskStatus;
import lombok.Data;

import java.util.Date;

@Data
public class TaskRequestDTO {
    private Integer id;
    private Integer customerId;
    private Integer masterId;
    private Integer solutionId;
    private Date date;
    private String startHour;
    private String endHour;
    private TaskStatus status;
    private String address;
}
