package com.example.mealapi.service;
import com.example.mealapi.model.Category;
import com.example.mealapi.model.CategoryListResponse;
import com.example.mealapi.model.Meal;
import com.example.mealapi.model.MealListResponse;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Collections;
import java.util.List;

@Service
public class MealDbService {

    private final RestClient restClient;

    public MealDbService(RestClient restClient) {
        this.restClient = restClient;
    }

    @Cacheable(value = "searchMeals", key = "#name.trim().toLowerCase()")
    public List<Meal> searchMeals(String name) {
        MealListResponse response = restClient.get()
                .uri("/search.php?s={name}", name)
                .retrieve()
                .body(MealListResponse.class);
        return response != null && response.meals != null ? response.meals : Collections.emptyList();
    }

    @Cacheable(value = "categories", key = "'all'")
    public List<Category> getCategories() {
        CategoryListResponse response = restClient.get()
                .uri("/categories.php")
                .retrieve()
                .body(CategoryListResponse.class);
        return response != null && response.categories != null ? response.categories : Collections.emptyList();
    }

    @Cacheable(value = "filterByCategory", key = "#category.trim().toLowerCase()")
    public List<Meal> getMealsByCategory(String category) {
        MealListResponse response = restClient.get()
                .uri("/filter.php?c={category}", category)
                .retrieve()
                .body(MealListResponse.class);
        return response != null && response.meals != null ? response.meals : Collections.emptyList();
    }

    public Meal getRandomMeal() {
        MealListResponse response = restClient.get()
                .uri("/random.php")
                .retrieve()
                .body(MealListResponse.class);
        return response != null && response.meals != null && !response.meals.isEmpty() ? response.meals.get(0) : null;
    }

    @Cacheable(value = "mealById", key = "#id.trim()")
    public Meal getMealById(String id) {
        MealListResponse response = restClient.get()
                .uri("/lookup.php?i={id}", id)
                .retrieve()
                .body(MealListResponse.class);
        return response != null && response.meals != null && !response.meals.isEmpty() ? response.meals.get(0) : null;
    }
}
