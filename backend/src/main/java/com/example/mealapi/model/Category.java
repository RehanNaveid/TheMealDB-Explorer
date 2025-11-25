package com.example.mealapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Category {
    public String idCategory;
    public String strCategory;
    public String strCategoryThumb;
    public String strCategoryDescription;
}
