package com.mmdt.pdfgenerator.dietplan;

import com.mmdt.pdfgenerator.data.MealPOJO;
import com.mmdt.pdfgenerator.dietplan.impl.NotionServiceImpl;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class NotionServiceRunner {

    public static void main(String[] args) {
        // Create an instance of NotionService
        NotionService notionService = new NotionServiceImpl(new RestTemplate());

        // Invoke the getAllMeals method
        List<MealPOJO> meals = notionService.getAllMeals();

        // Display or process the retrieved meals as needed
        for (MealPOJO meal : meals) {
            System.out.println(meal);
            // You can perform further processing or display the data as needed
        }
    }
}
