package com.personalproj.ineedmaster.controllers;

import com.personalproj.ineedmaster.dto.SolutionDTO;
import com.personalproj.ineedmaster.models.Solution;
import com.personalproj.ineedmaster.service.SolutionService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/solutions")
@RequiredArgsConstructor
public class SolutionController {
    private final SolutionService solutionService;
    private final ModelMapper modelMapper;

    @GetMapping("{id}")
    public ResponseEntity<SolutionDTO> getSolutionById(@PathVariable Integer id) {
        Optional<Solution> solution = solutionService.getSolutionById(id);

        if(solution.isPresent()) {
            SolutionDTO solutionResponse = modelMapper.map(solution, SolutionDTO.class);

            return ResponseEntity.ok().body(solutionResponse);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<SolutionDTO> createSolution(@RequestBody SolutionDTO solutionDTO) {
        Solution solutionRequest = modelMapper.map(solutionDTO, Solution.class);
        Solution createdSolution = solutionService.createSolution(solutionRequest);

        SolutionDTO solutionResponse = modelMapper.map(createdSolution, SolutionDTO.class);
        return new ResponseEntity<SolutionDTO>(solutionResponse, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<SolutionDTO> updateSolution(@PathVariable Integer id, @RequestBody SolutionDTO newSolutionDto) {
        Solution solutionRequest = modelMapper.map(newSolutionDto, Solution.class);

        try {
            Solution updatedSolution = solutionService.updateSolution(id, solutionRequest);

            SolutionDTO updatedSolutionDto = modelMapper.map(updatedSolution, SolutionDTO.class);
            return new ResponseEntity<>(updatedSolutionDto, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<SolutionDTO> deleteSolution(@PathVariable Integer id) {
        try {
            solutionService.deleteSolution(id);
            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
