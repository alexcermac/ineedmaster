package com.project.ineedmaster.services;

import com.project.ineedmaster.controllers.exceptions.task.TaskNotFoundException;
import com.project.ineedmaster.models.Task;
import com.project.ineedmaster.repositories.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService implements ITaskService {
    private final TaskRepository taskRepository;

    @Override
    public void create(Task task) {
        taskRepository.save(task);
    }

    @Override
    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id)
                .map(Optional::of)
                .orElseThrow(() -> new TaskNotFoundException(Long.toString(id)));
    }

    @Override
    public void update(Long id, Task task) {
        Task taskEntity = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(Long.toString(id)));
        taskEntity.setDate(task.getDate());
        taskEntity.setHour(task.getHour());
        taskEntity.setStatus(task.getStatus());
        taskEntity.setAddress(task.getAddress());

        taskRepository.save(taskEntity);
    }

    @Override
    public void delete(Long id) {
        Task taskEntity = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(Long.toString(id)));
        taskRepository.delete(taskEntity);
    }
}
