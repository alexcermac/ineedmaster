package com.personalproj.ineedmaster.repository;

import com.personalproj.ineedmaster.models.Solution;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SolutionRepository extends JpaRepository<Solution, Integer> {
    List<Solution> findByCountyIdAndCityId(Integer countyId, Integer cityId);
    List<Solution> findByCountyIdAndCityIdAndCategoryId(Integer countyId, Integer cityId, Integer categoryId);
    List<Solution> findByCountyIdAndCityIdAndCategoryIdAndSubcategoryId(Integer countyId, Integer cityId, Integer categoryId, Integer subcategoryId);
    List<Solution> findByCountyIdAndCategoryId(Integer countyId, Integer categoryId);
    List<Solution> findByCountyIdAndCategoryIdAndSubcategoryId(Integer countyId, Integer categoryId, Integer subcategoryId);
    List<Solution> findByCategoryIdAndSubcategoryId(Integer categoryId, Integer subcategoryId);
    List<Solution> findByUserId(Integer userId);
    List<Solution> findFirst10ByOrderByIdDesc();
}
