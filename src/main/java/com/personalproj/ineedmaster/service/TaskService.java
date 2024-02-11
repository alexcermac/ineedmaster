package com.personalproj.ineedmaster.service;

import com.personalproj.ineedmaster.exceptions.ResourceNotFoundException;
import com.personalproj.ineedmaster.models.Task;
import com.personalproj.ineedmaster.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService implements ITaskService {
    private final TaskRepository taskRepository;

    @Override
    public Task getTaskById(Integer id) {
        Optional<Task> task = taskRepository.findById(id);

        if(task.isPresent()) {
            return task.get();
        } else {
            throw new ResourceNotFoundException("Task with id " + id + " not found.");
        }
    }

    @Override
    public List<Task> getTasksByCustomerId(Integer id) {
        return taskRepository.findByCustomerId(id);
    }

    @Override
    public List<Task> getFutureTasksByCustomerIdAndCurrentDate(Integer id, Date currentDate) {
        return taskRepository.findByCustomerIdAndDateAfter(id, currentDate);
    }

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Integer id, Task newTask) {
        Optional<Task> foundTask = taskRepository.findById(id);

        if(foundTask.isPresent()) {
            Task task = foundTask.get();
            task.setStatus(newTask.getStatus());

            return taskRepository.save(task);
        } else {
            throw new ResourceNotFoundException("Task with id " + id + " not found.");
        }
    }

    @Override
    public void deleteTask(Integer id) {
        Optional<Task> foundTask = taskRepository.findById(id);

        if(foundTask.isPresent()) {
            taskRepository.delete(foundTask.get());
        } else {
            throw new ResourceNotFoundException("Task with id " + id + " not found.");
        }
    }
}
