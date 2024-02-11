package com.personalproj.ineedmaster.service;

import com.personalproj.ineedmaster.exceptions.ResourceNotFoundException;
import com.personalproj.ineedmaster.models.Solution;
import com.personalproj.ineedmaster.repository.SolutionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SolutionService implements ISolutionService {
    private final SolutionRepository solutionRepository;

    @Override
    public Solution createSolution(Solution solution) {
        return solutionRepository.save(solution);
    }

    @Override
    public Optional<Solution> getSolutionById(Integer id) {
//        return solutionRepository.findById(id)
//                .orElseThrow(() -> new IllegalStateException(String.format("Employee with id &s does not exist.", id)));

//        Optional<Solution> foundSolution = solutionRepository.findById(id);
//
//        if(foundSolution.isPresent()) {
//            return foundSolution;
//        } else {
//            throw new EntityNotFoundException("Solution with id " + id + " not found.");
//        }
        Optional<Solution> foundSolution = solutionRepository.findById(id);

        if(foundSolution.isPresent()) {
            return foundSolution;
        } else {
            throw new ResourceNotFoundException("Service with id " + id + " not found.");
        }
    }

    @Override
    public Solution updateSolution(Integer id, Solution newSolution) {
        Optional<Solution> foundSolution = solutionRepository.findById(id);

        if(foundSolution.isPresent()) {
            Solution solution = foundSolution.get();

            solution.setTitle(newSolution.getTitle());
            solution.setDescription(newSolution.getDescription());
            solution.setType(newSolution.getType());
            solution.setPrice(newSolution.getPrice());
            solution.setCategory(newSolution.getCategory());
            solution.setSubcategory(newSolution.getSubcategory());
            solution.setStartHour(newSolution.getStartHour());
            solution.setEndHour(newSolution.getEndHour());

            return solutionRepository.save(solution);
        } else {
            throw new ResourceNotFoundException("Service with id " + id + " not found.");
        }
    }

    @Override
    public void deleteSolution(Integer id) {
        Optional<Solution> foundSolution = solutionRepository.findById(id);

        if(foundSolution.isPresent()) {
            solutionRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Service with id " + id + " not found.");
        }
    }

    @Override
    public List<Solution> getSolutionsByCountyIdAndCityId(Integer countyId, Integer cityId) {
        return solutionRepository.findByCountyIdAndCityId(countyId, cityId);
    }

    @Override
    public List<Solution> getSolutionsByCountyIdAndCityIdAndCategoryId(Integer countyId, Integer cityId, Integer categoryId) {
        return solutionRepository.findByCountyIdAndCityIdAndCategoryId(countyId, cityId, categoryId);
    }

    @Override
    public List<Solution> getSolutionsByCountyIdAndCityIdAndCategoryIdAndSubcategoryId(Integer countyId, Integer cityId, Integer categoryId, Integer subcategoryId) {
        return solutionRepository.findByCountyIdAndCityIdAndCategoryIdAndSubcategoryId(countyId, cityId, categoryId, subcategoryId);
    }

    @Override
    public List<Solution> getSolutionsByCountyIdAndCategoryId(Integer countyId, Integer categoryId) {
        return solutionRepository.findByCountyIdAndCategoryId(countyId, categoryId);
    }
    @Override
    public List<Solution> getSolutionsByCountyIdAndCategoryIdAndSubcategoryId(Integer countyId, Integer categoryId, Integer subcategoryId) {
        return solutionRepository.findByCountyIdAndCategoryIdAndSubcategoryId(countyId, categoryId, subcategoryId);
    }

    @Override
    public List<Solution> getSolutionsByMasterId(Integer id) {
        return solutionRepository.findByUserId(id);
    }
}
