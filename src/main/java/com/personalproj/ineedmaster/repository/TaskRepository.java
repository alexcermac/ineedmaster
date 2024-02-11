package com.personalproj.ineedmaster.repository;

import com.personalproj.ineedmaster.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findByCustomerId(Integer id);
    List<Task> findByCustomerIdAndDateAfter(Integer id, Date currentDate);
}
