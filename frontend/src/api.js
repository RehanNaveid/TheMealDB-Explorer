const API_URL = import.meta.env.VITE_API_URL || 'http://localhost:8080/api';

export const fetchMeals = async (query) => {
    const response = await fetch(`${API_URL}/search?q=${query}`);
    const data = await response.json();
    return data.data;
};

export const fetchCategories = async () => {
    const response = await fetch(`${API_URL}/categories`);
    const data = await response.json();
    return data.data;
};

export const fetchMealsByCategory = async (category) => {
    const response = await fetch(`${API_URL}/category/${category}`);
    const data = await response.json();
    return data.data;
};

export const fetchRandomMeal = async () => {
    const response = await fetch(`${API_URL}/random`);
    const data = await response.json();
    return data.data;
};

export const fetchMealById = async (id) => {
    const response = await fetch(`${API_URL}/meal/${id}`);
    const data = await response.json();
    return data.data;
};
