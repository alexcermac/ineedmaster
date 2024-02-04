package com.personalproj.ineedmaster.service;

import com.personalproj.ineedmaster.dto.SolutionDTO;
import com.personalproj.ineedmaster.models.Solution;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface ISolutionService {
    Solution createSolution(Solution solution);
    Optional<Solution> getSolutionById(Integer id);
    Solution updateSolution(Integer id, Solution newSolution);
    void deleteSolution(Integer id);
}
