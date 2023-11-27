package com.mmdt.pdfgenerator.dietplan;

import com.mmdt.pdfgenerator.dietplan.impl.MealPlanGeneratorImpl;

public class MealPlanRunner {
    public static void main(String[] args) {
        // Create an instance of MealPlanGeneratorImpl
        MealPlanGenerator mealPlanGenerator = new MealPlanGeneratorImpl();

        // Define the sample plan name
        String samplePlan = "samplePlan";

        // Invoke the generateMealPlanPDF method
        String generatedFileName = mealPlanGenerator.generateMealPlanPDF(samplePlan);

    }
}

