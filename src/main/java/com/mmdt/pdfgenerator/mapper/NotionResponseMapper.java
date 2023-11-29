package com.mmdt.pdfgenerator.mapper;

import com.mmdt.pdfgenerator.data.MealPOJO;
import com.mmdt.pdfgenerator.data.NotionResponse;

import java.util.ArrayList;
import java.util.List;

public class NotionResponseMapper {

    public static List<MealPOJO> mapToListOfMealPOJO(NotionResponse notionResponse) {
        List<MealPOJO> mealPOJOList = new ArrayList<>();

        if (notionResponse != null && notionResponse.getResults() != null) {
            for (NotionResponse.Result result : notionResponse.getResults()) {
                MealPOJO mealPOJO = new MealPOJO(result);
                mealPOJOList.add(mealPOJO);
            }
        }

        return mealPOJOList;
    }
}

