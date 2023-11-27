package com.mmdt.pdfgenerator.dietplan;

import com.mmdt.pdfgenerator.config.PdfConfig;
import com.mmdt.pdfgenerator.dietplan.impl.MealPlanGeneratorImpl;

public class MealPlanRunner {
    public static void main(String[] args) {

        PdfConfig pdfConfig = new PdfConfig();

        pdfConfig.setBaseDest("C:/Users/Admin/Downloads/dietplans_output/");
        pdfConfig.setHeaderPngPath("C:/Users/Admin/Downloads/dietplans_output/source/MMDT_Header.png");
        pdfConfig.setFooterPngPath("C:/Users/Admin/Downloads/dietplans_output/source/MMDT_Footer.png");
        // Create an instance of MealPlanGeneratorImpl
        MealPlanGenerator mealPlanGenerator = new MealPlanGeneratorImpl(pdfConfig);

        // Define the sample plan name
        String samplePlan = "MealRunner";

        // Invoke the generateMealPlanPDF method
        mealPlanGenerator.generateMealPlanPDF(samplePlan);

    }
}

