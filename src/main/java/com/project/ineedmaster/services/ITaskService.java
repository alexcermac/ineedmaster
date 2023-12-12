package com.project.ineedmaster.services;

import com.project.ineedmaster.models.Task;

import java.util.List;
import java.util.Optional;

public interface ITaskService {
    // public Task findById(Long Id);
//    Task findById(Long id);
    void create(Task task);
    Optional<Task> findById(Long id);
    void update(Long id, Task task);
    void delete(Long id);
}
