import React, { useState, useEffect } from 'react';
import SearchBar from './components/SearchBar';
import CategoryList from './components/CategoryList';
import MealCard from './components/MealCard';
import MealDetails from './components/MealDetails';
import { fetchMeals, fetchCategories, fetchMealsByCategory, fetchRandomMeal, fetchMealById } from './api';

function App() {
  const [meals, setMeals] = useState([]);
  const [categories, setCategories] = useState([]);
  const [selectedCategory, setSelectedCategory] = useState(null);
  const [selectedMeal, setSelectedMeal] = useState(null);
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    loadCategories();
  }, []);

  const loadCategories = async () => {
    try {
      const cats = await fetchCategories();
      setCategories(cats || []);
    } catch (error) {
      console.error("Failed to load categories", error);
    }
  };

  const handleSearch = async (query) => {
    if (!query.trim()) return;
    setLoading(true);
    setSelectedCategory(null);
    try {
      const results = await fetchMeals(query);
      setMeals(results || []);
    } catch (error) {
      console.error("Search failed", error);
    } finally {
      setLoading(false);
    }
  };

  const handleCategorySelect = async (category) => {
    setSelectedCategory(category);
    setLoading(true);
    try {
      if (category) {
        const results = await fetchMealsByCategory(category);
        setMeals(results || []);
      } else {
        setMeals([]); // Or clear meals, or show random? Let's just clear.
      }
    } catch (error) {
      console.error("Filter failed", error);
    } finally {
      setLoading(false);
    }
  };

  const handleRandom = async () => {
    setLoading(true);
    try {
      const meal = await fetchRandomMeal();
      if (meal) {
        setSelectedMeal(meal);
      }
    } catch (error) {
      console.error("Random failed", error);
    } finally {
      setLoading(false);
    }
  };

  const handleMealClick = async (meal) => {
    // If meal doesn't have instructions, we need to fetch full details
    if (!meal.strInstructions) {
      setLoading(true);
      try {
        const fullMeal = await fetchMealById(meal.idMeal);
        setSelectedMeal(fullMeal);
      } catch (error) {
        console.error("Fetch details failed", error);
      } finally {
        setLoading(false);
      }
    } else {
      setSelectedMeal(meal);
    }
  };

  return (
    <div className="container">
      <header>
        <h1>TheMealDB Explorer</h1>
        <button className="random-btn" onClick={handleRandom}>
          Surprise Me!
        </button>
      </header>

      <SearchBar onSearch={handleSearch} />

      <CategoryList
        categories={categories}
        selectedCategory={selectedCategory}
        onSelectCategory={handleCategorySelect}
      />

      {loading && <p style={{ textAlign: 'center' }}>Loading...</p>}

      {!loading && meals.length === 0 && !selectedCategory && (
        <p style={{ textAlign: 'center', color: '#888' }}>
          Search for a meal or select a category to get started.
        </p>
      )}

      <div className="meal-grid">
        {meals.map((meal) => (
          <MealCard key={meal.idMeal} meal={meal} onClick={handleMealClick} />
        ))}
      </div>

      {selectedMeal && (
        <MealDetails meal={selectedMeal} onClose={() => setSelectedMeal(null)} />
      )}
    </div>
  );
}

export default App;
