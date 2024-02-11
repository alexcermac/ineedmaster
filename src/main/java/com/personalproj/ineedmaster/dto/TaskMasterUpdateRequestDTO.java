package com.personalproj.ineedmaster.dto;

import com.personalproj.ineedmaster.models.TaskStatus;
import lombok.Data;

@Data
public class TaskMasterUpdateRequestDTO {
    private TaskStatus status;
}
