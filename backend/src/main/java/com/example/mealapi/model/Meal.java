package com.example.mealapi.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Meal {
    public String idMeal;
    public String strMeal;
    public String strCategory;
    public String strArea;
    public String strInstructions;
    public String strMealThumb;
    public String strTags;
    public String strYoutube;

    // Ingredients and measures are dynamic in the API (strIngredient1, strMeasure1,
    // etc.)
    // We will map them to a map for easier consumption if needed, or just keep them
    // as is.
    // For simplicity and to match the API response structure expected by frontend
    // (or just pass through),
    // we can map specific fields. However, the requirement says "Maps JSON to model
    // classes".
    // Since the API returns flat structure for ingredients, let's keep it flat or
    // use a custom deserializer.
    // But for a "Explorer", passing the raw fields is often easiest unless we want
    // to clean it up.
    // Let's add the first 20 ingredients/measures as fields to ensure Jackson maps
    // them automatically.

    public String strIngredient1;
    public String strIngredient2;
    public String strIngredient3;
    public String strIngredient4;
    public String strIngredient5;
    public String strIngredient6;
    public String strIngredient7;
    public String strIngredient8;
    public String strIngredient9;
    public String strIngredient10;
    public String strIngredient11;
    public String strIngredient12;
    public String strIngredient13;
    public String strIngredient14;
    public String strIngredient15;
    public String strIngredient16;
    public String strIngredient17;
    public String strIngredient18;
    public String strIngredient19;
    public String strIngredient20;

    public String strMeasure1;
    public String strMeasure2;
    public String strMeasure3;
    public String strMeasure4;
    public String strMeasure5;
    public String strMeasure6;
    public String strMeasure7;
    public String strMeasure8;
    public String strMeasure9;
    public String strMeasure10;
    public String strMeasure11;
    public String strMeasure12;
    public String strMeasure13;
    public String strMeasure14;
    public String strMeasure15;
    public String strMeasure16;
    public String strMeasure17;
    public String strMeasure18;
    public String strMeasure19;
    public String strMeasure20;

    public String strSource;
    public String dateModified;
}
