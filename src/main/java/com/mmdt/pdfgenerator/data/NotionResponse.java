package com.mmdt.pdfgenerator.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class NotionResponse {
    @JsonProperty("object")
    private String object;
    @JsonProperty("results")
    private List<Result> results;

    

    @Data
    public static class Result {
        @JsonProperty("id")
        private String id;
        @JsonProperty("created_time")
        private String createdTime;
        @JsonProperty("last_edited_time")
        private String lastEditedTime;
        @JsonProperty("created_by")
        private User createdBy;
        @JsonProperty("last_edited_by")
        private User lastEditedBy;
        @JsonProperty("cover")
        private Object cover;
        @JsonProperty("icon")
        private Object icon;
        @JsonProperty("parent")
        private Parent parent;
        @JsonProperty("archived")
        private boolean archived;
        @JsonProperty("properties")
        private Properties properties;
        @JsonProperty("url")
        private String url;
        @JsonProperty("public_url")
        private String publicUrl;

        

        @Data
        public static class User {
            @JsonProperty("object")
            private String object;
            @JsonProperty("id")
            private String id;

            
        }

        @Data
        public static class Parent {
            @JsonProperty("type")
            private String type;
            @JsonProperty("database_id")
            private String databaseId;

            
        }

        @Data
        public static class Properties {
            @JsonProperty("Calories")
            private Formula calories;
            @JsonProperty("Fat")
            private Number fat;
            @JsonProperty("Carbs")
            private Number carbs;
            @JsonProperty("Preparation Time (in Mins)")
            private Number preparationTime;
            @JsonProperty("Directions")
            private RichText directions;
            @JsonProperty("Servings")
            private Number servings;
            @JsonProperty("Fibre")
            private Number fibre;
            @JsonProperty("Quantity")
            private RichText quantity;
            @JsonProperty("Image")
            private Files image;
            @JsonProperty("Tags")
            private MultiSelect tags;
            @JsonProperty("Meal Desc")
            private RichText mealDesc;
            @JsonProperty("Ingredients")
            private RichText ingredients;
            @JsonProperty("Difficulty")
            private Select difficulty;
            @JsonProperty("Protein")
            private Number protein;
            @JsonProperty("Meal Name")
            private Title mealName;
            @JsonProperty("Meal Unit")
            private Relation mealUnit;

            
        }

        @Data
        public static class Formula {
            @JsonProperty("id")
            private String id;
            @JsonProperty("type")
            private String type;
            @JsonProperty("formula")
            private FormulaDetails formulaDetails;
        }

        @Data
        public static class FormulaDetails {
            @JsonProperty("type")
            private String type;
            @JsonProperty("number")
            private Double number;

            // Getters and setters...
        }

        @Data
        public static class RichText {
            @JsonProperty("id")
            private String id;
            @JsonProperty("type")
            private String type;
            @JsonProperty("rich_text")
            private List<Text> richText;

            
        }

        @Data
        public static class Text {
            @JsonProperty("type")
            private String type;
            @JsonProperty("text")
            private Content text;

            
        }

        @Data
        public static class Content {
            @JsonProperty("content")
            private String content;

            
        }

        @Data
        public static class Number {
            @JsonProperty("id")
            private String id;
            @JsonProperty("type")
            private String type;
            @JsonProperty("number")
            private Double number;

            
        }

        @Data
        public static class Files {
            @JsonProperty("id")
            private String id;
            @JsonProperty("type")
            private String type;
            @JsonProperty("files")
            private List<File> files;

            
        }

        @Data
        public static class File {
            @JsonProperty("id")
            private String id;
            @JsonProperty("type")
            private String type;

            
        }

        @Data
        public static class MultiSelect {
            @JsonProperty("id")
            private String id;
            @JsonProperty("type")
            private String type;
            @JsonProperty("multi_select")
            private List<SelectOption> multiSelect;

            
        }

        @Data
        public static class SelectOption {
            @JsonProperty("id")
            private String id;
            @JsonProperty("name")
            private String name;
            @JsonProperty("color")
            private String color;

            
        }

        @Data
        public static class Select {
            @JsonProperty("id")
            private String id;
            @JsonProperty("type")
            private String type;
            @JsonProperty("select")
            private SelectOption select;

            
        }

        @Data
        public static class Title {
            @JsonProperty("id")
            private String id;
            @JsonProperty("type")
            private String type;
            @JsonProperty("title")
            private List<Text> title;

            
        }

        @Data
        public static class Relation {
            @JsonProperty("id")
            private String id;
            @JsonProperty("type")
            private String type;
            @JsonProperty("relation")
            private List<String> relation;
            @JsonProperty("has_more")
            private boolean hasMore;

            
        }
    }
}
