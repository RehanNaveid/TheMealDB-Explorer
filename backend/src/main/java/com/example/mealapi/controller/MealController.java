package com.example.mealapi.controller;

import com.example.mealapi.model.ApiResponse;
import com.example.mealapi.model.Category;
import com.example.mealapi.model.Meal;
import com.example.mealapi.service.MealDbService;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class MealController {

    private final MealDbService mealDbService;
    private final CacheManager cacheManager;

    public MealController(MealDbService mealDbService, CacheManager cacheManager) {
        this.mealDbService = mealDbService;
        this.cacheManager = cacheManager;
    }

    private boolean isCached(String cacheName, Object key) {
        Cache cache = cacheManager.getCache(cacheName);
        return cache != null && cache.get(key) != null;
    }

    @GetMapping("/search")
    public ApiResponse<List<Meal>> search(@RequestParam String q) {
        String key = q.trim().toLowerCase();
        boolean cached = isCached("searchMeals", key);

        List<Meal> meals = mealDbService.searchMeals(q);
        return ApiResponse.success(meals, cached);
    }

    @GetMapping("/categories")
    public ApiResponse<List<Category>> getCategories() {
        boolean cached = isCached("categories", "all");

        List<Category> cats = mealDbService.getCategories();
        return ApiResponse.success(cats, cached);
    }

    @GetMapping("/category/{name}")
    public ApiResponse<List<Meal>> getCategory(@PathVariable String name) {
        String key = name.trim().toLowerCase();
        boolean cached = isCached("filterByCategory", key);

        List<Meal> meals = mealDbService.getMealsByCategory(name);
        return ApiResponse.success(meals, cached);
    }

    @GetMapping("/random")
    public ApiResponse<Meal> getRandom() {
        // not cached intentionally
        return ApiResponse.success(mealDbService.getRandomMeal(), false);
    }

    @GetMapping("/meal/{id}")
    public ApiResponse<Meal> getMealById(@PathVariable String id) {
        boolean cached = isCached("mealById", id);

        Meal meal = mealDbService.getMealById(id);
        return ApiResponse.success(meal, cached);
    }
}
