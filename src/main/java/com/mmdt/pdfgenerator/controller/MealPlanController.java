package com.mmdt.pdfgenerator.controller;

import com.mmdt.pdfgenerator.dietplan.MealPlanGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mealplan")
public class MealPlanController {

    private final MealPlanGenerator mealPlanGenerator;

    public MealPlanController(MealPlanGenerator mealPlanGenerator) {
        this.mealPlanGenerator = mealPlanGenerator;
    }

    @GetMapping("/generate/{fileName}")
    public String generateMealPlanPDF(@PathVariable String fileName) {
        return mealPlanGenerator.generateMealPlanPDF(fileName);
    }
}
