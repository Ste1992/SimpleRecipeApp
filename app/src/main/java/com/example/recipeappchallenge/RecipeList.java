package com.example.recipeappchallenge;

public class RecipeList {
    private String title;
    private String description;
    private String text;
    private String ingredients;
    private int image;

    RecipeList(String title, String description, String text, String ingredients, int image) {
        this.title = title;
        this.description = description;
        this.text = text;
        this.ingredients = ingredients;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getText() {
        return text;
    }

    public String getIngredients() {
        return ingredients;
    }

    public int getImage() {
        return image;
    }
}
