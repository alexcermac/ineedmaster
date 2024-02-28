package com.personalproj.ineedmaster.controllers;

import com.personalproj.ineedmaster.dto.TaskMasterUpdateRequestDTO;
import com.personalproj.ineedmaster.dto.TaskRequestDTO;
import com.personalproj.ineedmaster.dto.TaskResponseDTO;
import com.personalproj.ineedmaster.exceptions.ResourceNotFoundException;
import com.personalproj.ineedmaster.models.Task;
import com.personalproj.ineedmaster.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
@CrossOrigin
public class TaskController {
    private final TaskService taskService;
    private final ModelMapper modelMapper;

    @PostMapping
    public TaskResponseDTO createTask(@RequestBody TaskRequestDTO taskRequestDTO) {
        Task task = modelMapper.map(taskRequestDTO, Task.class);
        Task savedTask = taskService.createTask(task);

        TaskResponseDTO taskResponseDTO = modelMapper.map(savedTask, TaskResponseDTO.class);
        return taskResponseDTO;
    }

    @GetMapping("{id}")
    public TaskResponseDTO getTaskById(@PathVariable Integer id) {
        Task task = taskService.getTaskById(id);
        TaskResponseDTO taskDto = modelMapper.map(task, TaskResponseDTO.class);
        return taskDto;
    }

    @GetMapping("/customer/{id}")
    public List<TaskResponseDTO> getTasksByCustomerId(@PathVariable Integer id) {
        List<Task> tasks = taskService.getTasksByCustomerId(id);
        List<TaskResponseDTO> tasksDto = tasks.stream()
                .map(task -> modelMapper.map(task, TaskResponseDTO.class))
                .toList();
        return tasksDto;
    }

    @GetMapping("/customer/{id}/future")
    public List<TaskResponseDTO> getFutureTasksByCustomerIdAndCurrentDate(@PathVariable Integer id, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        List<Task> tasks = taskService.getFutureTasksByCustomerIdAndCurrentDate(id, date);
        List<TaskResponseDTO> tasksDto = tasks.stream()
                .map((task) -> modelMapper.map(task, TaskResponseDTO.class))
                .toList();
        return tasksDto;
    }

    @GetMapping("/customer/{id}/old")
    public List<TaskResponseDTO> getOldTasksByCustomerIdAndCurrentDate(@PathVariable Integer id, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        List<Task> tasks = taskService.getOldTasksByCustomerIdAndCurrentDate(id, date);
        List<TaskResponseDTO> tasksDto = tasks.stream()
                .map((task) -> modelMapper.map(task, TaskResponseDTO.class))
                .toList();
        return tasksDto;
    }

    @GetMapping("/master/{id}/future")
    public List<TaskResponseDTO> getFutureTasksByMasterIdAndCurrentDate(@PathVariable Integer id, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        List<Task> tasks = taskService.getFutureTasksByMasterIdAndCurrentDate(id, date);
        List<TaskResponseDTO> tasksDto = tasks.stream()
                .map((task) -> modelMapper.map(task, TaskResponseDTO.class))
                .toList();
        return tasksDto;
    }

    @GetMapping("/master/{id}/old")
    public List<TaskResponseDTO> getOldTasksByMasterIdAndCurrentDate(@PathVariable Integer id, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        List<Task> tasks = taskService.getOldTasksByMasterIdAndCurrentDate(id, date);
        List<TaskResponseDTO> tasksDto = tasks.stream()
                .map((task) -> modelMapper.map(task, TaskResponseDTO.class))
                .toList();
        return tasksDto;
    }

    @PutMapping("{id}")
    public TaskResponseDTO updateTask(@PathVariable Integer id, @RequestBody TaskRequestDTO taskRequestDTO) {
        Task newTask = modelMapper.map(taskRequestDTO, Task.class);
        Task updatedTask = taskService.updateTask(id, newTask);
        TaskResponseDTO taskResponseDTO = modelMapper.map(updatedTask, TaskResponseDTO.class);
        return taskResponseDTO;
    }

    @PutMapping("{id}/master")
    public TaskResponseDTO updateTaskByMaster(@PathVariable Integer id, @RequestBody TaskMasterUpdateRequestDTO taskUpdateDTO) {
        Task newTask = modelMapper.map(taskUpdateDTO, Task.class);
        Task updatedTask = taskService.updateTask(id, newTask);
        TaskResponseDTO taskResponseDTO = modelMapper.map(updatedTask, TaskResponseDTO.class);
        return taskResponseDTO;
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException exception) {
        Map<String, Object> body = new HashMap<>();
        body.put("message", exception.getMessage());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
}
