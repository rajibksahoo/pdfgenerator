package com.mmdt.pdfgenerator.data;


import lombok.Data;

import java.util.List;

import java.util.stream.Collectors;

@Data
public class MealPOJO {
    private String mealId;
    private String mealName;
    private String mealUnit;
    private List<String> tags;
    private String ingredients;
    private String quantity;
    private Float protein;
    private Float carbs;
    private Float fat;
    private Float fibre;
    private Double calories;
    private String directions;
    private Float preparationTime;
    private String difficulty;
    private String image;
    private String mealDesc;
    private Float servings;

    public MealPOJO(NotionResponse.Result notionResult) {
        this.mealId = notionResult.getId();

        // Meal Name
        if (notionResult.getProperties().getMealName() != null
                && notionResult.getProperties().getMealName().getTitle() != null
                && !notionResult.getProperties().getMealName().getTitle().isEmpty()
                && notionResult.getProperties().getMealName().getTitle().get(0).getText() != null) {
            this.mealName = notionResult.getProperties().getMealName().getTitle().get(0).getText().getContent();
        }

        // Tags
        if (notionResult.getProperties().getTags() != null && notionResult.getProperties().getTags().getMultiSelect() != null) {
            this.tags = notionResult.getProperties().getTags().getMultiSelect().stream()
                    .map(multiselect -> multiselect.getName() != null ? multiselect.getName() : null)
                    .collect(Collectors.toList());
        }

        // Ingredients
        if (notionResult.getProperties().getIngredients() != null
                && !notionResult.getProperties().getIngredients().getRichText().isEmpty()
                && notionResult.getProperties().getIngredients().getRichText().get(0).getText() != null) {
            this.ingredients = notionResult.getProperties().getIngredients().getRichText().get(0).getText().getContent();
        }

        // Quantity
        if (notionResult.getProperties().getQuantity() != null
                && !notionResult.getProperties().getQuantity().getRichText().isEmpty()
                && notionResult.getProperties().getQuantity().getRichText().get(0).getText() != null) {
            this.quantity = notionResult.getProperties().getQuantity().getRichText().get(0).getText().getContent();
        }

        // Directions
        if (notionResult.getProperties().getDirections() != null
                && !notionResult.getProperties().getDirections().getRichText().isEmpty()
                && notionResult.getProperties().getDirections().getRichText().get(0).getText() != null) {
            this.directions = notionResult.getProperties().getDirections().getRichText().get(0).getText().getContent();
        }

        // Difficulty
        if (notionResult.getProperties().getDifficulty() != null
                && notionResult.getProperties().getDifficulty().getSelect() != null) {
            this.difficulty = notionResult.getProperties().getDifficulty().getSelect().getName();
        }

        // Image
        if (notionResult.getProperties().getImage() != null
                && notionResult.getProperties().getImage().getFiles() != null
                && !notionResult.getProperties().getImage().getFiles().isEmpty()) {
            this.image = notionResult.getProperties().getImage().getFiles().get(0).getId();
        }

        // Meal Desc
        if (notionResult.getProperties().getMealDesc() != null
                && !notionResult.getProperties().getMealDesc().getRichText().isEmpty()
                && notionResult.getProperties().getMealDesc().getRichText().get(0).getText() != null) {
            this.mealDesc = notionResult.getProperties().getMealDesc().getRichText().get(0).getText().getContent();
        }

        // Servings
        this.servings = notionResult.getProperties().getServings() != null
                ? notionResult.getProperties().getServings().getNumber() != null
                ? notionResult.getProperties().getServings().getNumber().floatValue()
                : null
                : null;

        // Meal Unit
        if (notionResult.getProperties().getMealUnit() != null
                && !notionResult.getProperties().getMealUnit().getRelation().isEmpty()) {
            this.mealUnit = notionResult.getProperties().getMealUnit().getRelation().get(0);
        }

        // Protein
        this.protein = getValueOrDefault(notionResult.getProperties().getProtein());

        // Carbs
        this.carbs = getValueOrDefault(notionResult.getProperties().getCarbs());

        // Fat
        this.fat = getValueOrDefault(notionResult.getProperties().getFat());

        // Fibre
        this.fibre = getValueOrDefault(notionResult.getProperties().getFibre());

        // Calories
        if (notionResult.getProperties().getCalories() != null
                && notionResult.getProperties().getCalories().getFormulaDetails().getNumber() != null) {
            this.calories = notionResult.getProperties().getCalories().getFormulaDetails().getNumber();
        }

        // Preparation Time
        this.preparationTime = getValueOrDefault(notionResult.getProperties().getPreparationTime());
    }

    // Helper method to handle null checks
    private Float getValueOrDefault(NotionResponse.Result.Number number) {
        return number != null && number.getNumber() != null ? number.getNumber().floatValue() : 0.0f;
    }


}

