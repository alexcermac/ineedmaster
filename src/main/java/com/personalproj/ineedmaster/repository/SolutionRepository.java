package com.personalproj.ineedmaster.repository;

import com.personalproj.ineedmaster.models.Solution;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SolutionRepository extends JpaRepository<Solution, Integer> {
    List<Solution> findByCountyIdAndCityId(Integer countyId, Integer cityId);
}
