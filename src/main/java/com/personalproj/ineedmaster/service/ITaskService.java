package com.personalproj.ineedmaster.service;

import com.personalproj.ineedmaster.models.Task;

import java.util.Date;
import java.util.List;

public interface ITaskService {
    Task getTaskById(Integer id);
    List<Task> getTasksByCustomerId(Integer id);
    List<Task> getFutureTasksByCustomerIdAndCurrentDate(Integer id, Date currentDate);
    Task createTask(Task task);
    Task updateTask(Integer id, Task task);
    void deleteTask(Integer id);
}
