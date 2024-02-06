package com.personalproj.ineedmaster.controllers;

import com.personalproj.ineedmaster.dto.SolutionDTO;
import com.personalproj.ineedmaster.models.Solution;
import com.personalproj.ineedmaster.service.SolutionService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
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
    public ResponseEntity<SolutionDTO> createSolution(@Valid @RequestBody SolutionDTO solutionDTO) {
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

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
            Map<String, String> errors = new HashMap<>();
            ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = "message";
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
