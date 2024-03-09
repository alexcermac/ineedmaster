package com.personalproj.ineedmaster.controllers;

import com.personalproj.ineedmaster.dto.SolutionRequestDTO;
import com.personalproj.ineedmaster.dto.SolutionSearchResponseDTO;
import com.personalproj.ineedmaster.exceptions.ResourceNotFoundException;
import com.personalproj.ineedmaster.models.Solution;
import com.personalproj.ineedmaster.service.ISolutionService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/solutions")
@RequiredArgsConstructor
@CrossOrigin
public class SolutionController {
    private final ISolutionService solutionService;
    private final ModelMapper modelMapper;

    @GetMapping("{id}")
    public ResponseEntity<SolutionSearchResponseDTO> getSolutionById(@PathVariable Integer id) {
        Optional<Solution> solution = solutionService.getSolutionById(id);
        SolutionSearchResponseDTO solutionResponse = modelMapper.map(solution, SolutionSearchResponseDTO.class);

        return ResponseEntity.ok().body(solutionResponse);
    }

    @GetMapping("/county/{countyId}/city/{cityId}")
    public List<SolutionSearchResponseDTO> getSolutionsByCountyIdAndCityId(
            @PathVariable Integer countyId,
            @PathVariable Integer cityId
    ) {
        List<Solution> solutions = solutionService.getSolutionsByCountyIdAndCityId(countyId, cityId);
        List<SolutionSearchResponseDTO> solutionsDTO = solutions.stream()
                .map(solution -> modelMapper.map(solution, SolutionSearchResponseDTO.class))
                .toList();
        return solutionsDTO;
    }

    @GetMapping("/county/{countyId}/city/{cityId}/category/{categoryId}")
    public List<SolutionSearchResponseDTO> getSolutionsByCountyIdAndCityIdAndCategoryId(
            @PathVariable Integer countyId,
            @PathVariable Integer cityId,
            @PathVariable Integer categoryId
    ) {
        List<Solution> solutions = solutionService.getSolutionsByCountyIdAndCityIdAndCategoryId(countyId, cityId, categoryId);
        List<SolutionSearchResponseDTO> solutionsDTO = solutions.stream()
                .map(solution -> modelMapper.map(solution, SolutionSearchResponseDTO.class))
                .toList();
        return solutionsDTO;
    }

    @GetMapping("/county/{countyId}/city/{cityId}/category/{categoryId}/subcategory/{subcategoryId}")
    public List<SolutionSearchResponseDTO> getSolutionsByCountyIdAndCityIdAndCategoryIdAndSubcategoryId(
            @PathVariable Integer countyId,
            @PathVariable Integer cityId,
            @PathVariable Integer categoryId,
            @PathVariable Integer subcategoryId
    ) {
        List<Solution> solutions = solutionService.getSolutionsByCountyIdAndCityIdAndCategoryIdAndSubcategoryId(countyId, cityId, categoryId, subcategoryId);
        List<SolutionSearchResponseDTO> solutionsDTO = solutions.stream()
                .map(solution -> modelMapper.map(solution, SolutionSearchResponseDTO.class))
                .toList();
        return solutionsDTO;
    }

    @GetMapping("/county/{countyId}/category/{categoryId}")
    public List<SolutionSearchResponseDTO> getSolutionsByCountyIdAndCategoryId(
            @PathVariable Integer countyId,
            @PathVariable Integer categoryId
    ) {
        List<Solution> solutions = solutionService.getSolutionsByCountyIdAndCategoryId(countyId, categoryId);
        List<SolutionSearchResponseDTO> solutionsDTO = solutions.stream()
                .map(solution -> modelMapper.map(solution, SolutionSearchResponseDTO.class))
                .toList();
        return solutionsDTO;
    }

    @GetMapping("/county/{countyId}/category/{categoryId}/subcategory/{subcategoryId}")
    public List<SolutionSearchResponseDTO> getSolutionsByCountyIdAndCategoryId(
            @PathVariable Integer countyId,
            @PathVariable Integer categoryId,
            @PathVariable Integer subcategoryId
    ) {
        List<Solution> solutions = solutionService.getSolutionsByCountyIdAndCategoryIdAndSubcategoryId(countyId, categoryId, subcategoryId);
        List<SolutionSearchResponseDTO> solutionsDTO = solutions.stream()
                .map(solution -> modelMapper.map(solution, SolutionSearchResponseDTO.class))
                .toList();
        return solutionsDTO;
    }

    @GetMapping("/category/{categoryId}/subcategory/{subcategoryId}")
    public List<SolutionSearchResponseDTO> getSolutionsByCategoryIdAndSubcategoryId(
            @PathVariable Integer categoryId,
            @PathVariable Integer subcategoryId
    ) {
        List<Solution> solutions = solutionService.getSolutionsByCategoryIdAndSubcategoryId(categoryId, subcategoryId);
        List<SolutionSearchResponseDTO> solutionsDTO = solutions.stream()
                .map(solution -> modelMapper.map(solution, SolutionSearchResponseDTO.class))
                .toList();
        return solutionsDTO;
    }

    @GetMapping("/master/{id}")
    public List<SolutionSearchResponseDTO> getSolutionsByMasterId(@PathVariable Integer id) {
        List<Solution> solutions = solutionService.getSolutionsByMasterId(id);
        List<SolutionSearchResponseDTO> solutionsDTO = solutions.stream()
                .map(solution -> modelMapper.map(solution, SolutionSearchResponseDTO.class))
                .toList();
        return solutionsDTO;
    }

    @GetMapping("/last-10")
    public List<SolutionSearchResponseDTO> getLast10Solutions() {
        List<Solution> solutions = solutionService.getLast10Solutions();
        List<SolutionSearchResponseDTO> solutionsDTO = solutions.stream()
                .map(solution -> modelMapper.map(solution, SolutionSearchResponseDTO.class))
                .toList();
        return solutionsDTO;
    }

    @PostMapping
    public ResponseEntity<SolutionRequestDTO> createSolution(@Valid @RequestBody SolutionRequestDTO solutionRequestDTO) {
        Solution solutionRequest = modelMapper.map(solutionRequestDTO, Solution.class);

        Solution createdSolution = solutionService.createSolution(solutionRequest);
        SolutionRequestDTO solutionResponse = modelMapper.map(createdSolution, SolutionRequestDTO.class);

        return new ResponseEntity<>(solutionResponse, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<SolutionRequestDTO> updateSolution(@PathVariable Integer id, @RequestBody SolutionRequestDTO newSolutionRequestDto) {
        Solution solutionRequest = modelMapper.map(newSolutionRequestDto, Solution.class);

        Solution updatedSolution = solutionService.updateSolution(id, solutionRequest);
        SolutionRequestDTO updatedSolutionRequestDto = modelMapper.map(updatedSolution, SolutionRequestDTO.class);

        return new ResponseEntity<>(updatedSolutionRequestDto, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteSolution(@PathVariable Integer id) {
        solutionService.deleteSolution(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException exception) {
        Map<String, Object> body = new HashMap<>();
        body.put("message", exception.getMessage());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
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
