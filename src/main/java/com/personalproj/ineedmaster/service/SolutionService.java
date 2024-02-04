package com.personalproj.ineedmaster.service;

import com.personalproj.ineedmaster.models.Solution;
import com.personalproj.ineedmaster.repository.SolutionRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
        return solutionRepository.findById(id);
    }

    @Override
    public Solution updateSolution(Integer id, Solution newSolution) {
        Optional<Solution> foundSolution = solutionRepository.findById(id);

        if(foundSolution.isPresent()) {
            Solution solution = foundSolution.get();

            solution.setTitle(newSolution.getTitle());

            return solutionRepository.save(solution);
        } else {
            throw new EntityNotFoundException("Solution with id " + id + " not found.");
        }
    }

    @Override
    public void deleteSolution(Integer id) {
        Optional<Solution> foundSolution = solutionRepository.findById(id);

        if(foundSolution.isPresent()) {
            solutionRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Solution with id " + id + " not found.");
        }
    }
}
