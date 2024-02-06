package com.personalproj.ineedmaster;

import com.personalproj.ineedmaster.models.Solution;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;

public class SolutionValidationTest {
    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    private Solution createSolution() {
        Solution solution = new Solution();
        solution.setTitle("Title for solution");
        return solution;
    }

    @Test
    public void ifMasterIdIsNull_masterIdValidationFails() {
        Solution solution = new Solution();
        Set<ConstraintViolation<Solution>> violations = validator.validate(solution);
        assertEquals(violations.isEmpty(), false);
    }
}
