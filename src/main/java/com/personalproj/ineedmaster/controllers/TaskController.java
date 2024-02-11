package com.personalproj.ineedmaster.controllers;

import com.personalproj.ineedmaster.dto.TaskMasterUpdateRequestDTO;
import com.personalproj.ineedmaster.dto.TaskRequestDTO;
import com.personalproj.ineedmaster.dto.TaskResponseDTO;
import com.personalproj.ineedmaster.exceptions.ResourceNotFoundException;
import com.personalproj.ineedmaster.models.Task;
import com.personalproj.ineedmaster.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;
    private final ModelMapper modelMapper;

    @GetMapping("{id}")
    public TaskResponseDTO getTaskById(@PathVariable Integer id) {
        Task task = taskService.getTaskById(id);
        TaskResponseDTO taskDto = modelMapper.map(task, TaskResponseDTO.class);
        return taskDto;
    }

    @GetMapping("/customer/{id}")
    public List<Task> getTasksByCustomerId(@PathVariable Integer id) {
        return taskService.getTasksByCustomerId(id);
    }

    @GetMapping("/customer/{id}/future")
    public List<TaskResponseDTO> getFutureTasksByCustomerIdAndCurrentDate(@PathVariable Integer id, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
//        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
//        Date currentDateDate = formatter.parse(currentDateString);
        List<Task> tasks = taskService.getFutureTasksByCustomerIdAndCurrentDate(id, date);
        List<TaskResponseDTO> tasksDto = tasks.stream()
                .map((task) -> modelMapper.map(task, TaskResponseDTO.class))
                .toList();
        return tasksDto;
    }

    @PostMapping
    public TaskResponseDTO createTask(@RequestBody TaskRequestDTO taskRequestDTO) {
        Task task = modelMapper.map(taskRequestDTO, Task.class);
        Task savedTask = taskService.createTask(task);

        TaskResponseDTO taskResponseDTO = modelMapper.map(savedTask, TaskResponseDTO.class);
        return taskResponseDTO;
    }

    @PutMapping("{id}/master")
    public TaskResponseDTO updateTask(@PathVariable Integer id, @RequestBody TaskMasterUpdateRequestDTO taskUpdateDTO) {
        Task newTask = modelMapper.map(taskUpdateDTO, Task.class);
        Task updatedTask = taskService.updateTask(id, newTask);
        TaskResponseDTO taskResponseDTO = modelMapper.map(updatedTask, TaskResponseDTO.class);
        return taskResponseDTO;
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Integer id) {
        taskService.deleteTask(id);
        return new ResponseEntity<>("Task was deleted successfully!", HttpStatus.OK);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException exception) {
        Map<String, Object> body = new HashMap<>();
        body.put("message", exception.getMessage());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
}
