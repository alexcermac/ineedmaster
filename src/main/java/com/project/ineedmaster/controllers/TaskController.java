package com.project.ineedmaster.controllers;

import com.project.ineedmaster.config.ApiError;
import com.project.ineedmaster.controllers.exceptions.task.TaskNotFoundException;
import com.project.ineedmaster.models.Task;
import com.project.ineedmaster.services.TaskService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @PostMapping
    void create(@RequestBody Task task) {
        taskService.create(task);
    }

    @GetMapping("/{id}")
    ResponseEntity<Task> findById(@PathVariable Long id) {
        return taskService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    void update(@PathVariable Long id, @RequestBody Task task) {
        taskService.update(id, task);
//                .map(ResponseEntity::ok)
//                .orEleseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
        taskService.delete(id);
    }

//    @ExceptionHandler(TaskNotFoundException.class)
//    public ResponseEntity<ApiError> handleTaskNotFoundException(TaskNotFoundException e) {
//
//    }
}
