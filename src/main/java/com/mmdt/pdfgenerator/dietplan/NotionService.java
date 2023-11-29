package com.mmdt.pdfgenerator.dietplan;

import com.mmdt.pdfgenerator.data.MealPOJO;

import java.util.List;

public interface NotionService {
    List<MealPOJO> getAllMeals();
}

