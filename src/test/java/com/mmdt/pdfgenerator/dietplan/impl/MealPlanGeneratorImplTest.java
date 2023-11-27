package com.mmdt.pdfgenerator.dietplan.impl;

import com.mmdt.pdfgenerator.dietplan.MealPlanGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:application.yml")
class MealPlanGeneratorImplTest {

    @Autowired
    private MealPlanGenerator mealPlanGenerator;

    @Test
    void testGenerateMealPlanPDF() {
        String fileName = "testMealPlan";
        String result = mealPlanGenerator.generateMealPlanPDF(fileName);
        assertNotNull(result);
    }
}
