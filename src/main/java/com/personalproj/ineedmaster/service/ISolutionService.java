package com.personalproj.ineedmaster.service;

import com.personalproj.ineedmaster.models.Solution;

import java.util.List;
import java.util.Optional;

public interface ISolutionService {
    Solution createSolution(Solution solution);
    Optional<Solution> getSolutionById(Integer id);
    Solution updateSolution(Integer id, Solution newSolution);
    void deleteSolution(Integer id);
    List<Solution> getSolutionsByCountyIdAndCityId(Integer countyId, Integer cityId);
    List<Solution> getSolutionsByCountyIdAndCityIdAndCategoryId(Integer countyId, Integer cityId, Integer categoryId);
    List<Solution> getSolutionsByCountyIdAndCityIdAndCategoryIdAndSubcategoryId(Integer countyId, Integer cityId, Integer categoryId, Integer subcategoryId);
    List<Solution> getSolutionsByCountyIdAndCategoryId(Integer countyId, Integer categoryId);
    List<Solution> getSolutionsByCountyIdAndCategoryIdAndSubcategoryId(Integer countyId, Integer categoryId, Integer subcategoryId);
    List<Solution> getSolutionsByCategoryIdAndSubcategoryId(Integer categoryId, Integer subcategoryId);
    List<Solution> getSolutionsByMasterId(Integer id);
    List<Solution> getLast10Solutions();
}
