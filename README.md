```markdown
# TheMealDB Explorer

TheMealDB Explorer is a full-stack web application for organized browsing of meals, categories, and recipes using TheMealDB public API. It features a Spring Boot backend with efficient standardized responses and caching, and a React frontend delivering a clear, responsive user experience.

---

## 🚀 Project Overview

- Simplifies TheMealDB (`https://www.themealdb.com/api.php`) with clean REST endpoints
- Backend caches responses to minimize redundant API calls
- Frontend emphasizes clarity, speed, and usability
- Demonstrates clean API design, effective caching, and modern UI
- 100% local runnable—no external database required

---

## ⚙️ Architecture

### Backend (Spring Boot)
- Proxies TheMealDB API with Spring RestClient
- Caffeine-based in-memory caching: TTL + max size
- Unified API response format:
  ```
  {
    "status": "ok",
    "cached": false,
    "data": { ... }
  }
  ```
- Cache key normalization for reliable hits

### Frontend (React + Vite)
- Uses Fetch API to call backend endpoints only
- Features: search, category browsing, filtering, random meal, recipe details
- Extracts up to 20 ingredients per meal
- Embeds YouTube tutorial for recipes (if available)
- CSS Grid & Flexbox for responsiveness

---

## 📚 Backend API Endpoints

| Endpoint                | Description                         |
|-------------------------|-------------------------------------|
| `GET /api/search?q={}`  | Search meals by name                |
| `GET /api/categories`   | Retrieve all categories             |
| `GET /api/category/{}`  | Meals within a category             |
| `GET /api/random`       | Retrieve a random meal              |
| `GET /api/meal/{id}`    | Detailed information for meal ID     |

- Upstream: [https://www.themealdb.com/api/json/v1/1/](https://www.themealdb.com/api/json/v1/1/)

### Caching Configuration
- **Provider:** Caffeine
- **Max Entries:** 500
- **Expiry:** 1 hour
- **Cached:** search results, categories, category meals, meal details
- **Not Cached:** random meal

---

## 💡 Frontend Features

- Search meals by name
- Browse all categories
- View meals in a category
- Full recipe details: ingredients, instructions, embedded YouTube video
- Generate random meal
- Responsive layout (mobile + desktop)
- **Config:**  
  Set API url via `.env`:
  ```
  VITE_API_URL=http://localhost:8080/api
  ```

---

## 🛠️ Getting Started

### Backend

```
cd backend
mvn spring-boot:run
# Runs at http://localhost:8080
```

### Frontend

```
cd frontend
npm install
npm run dev
# Runs at http://localhost:5173
```

---

## 📂 Project Structure

```
TheMealDB-Explorer/
 ├── backend/
 │    ├── src/main/java/com/example/mealapi/
 │    ├── src/main/resources/
 │    └── pom.xml
 ├── frontend/
 │    ├── src/
 │    ├── public/
 │    └── package.json
 ├── assets/            # screenshots
 └── README.md
```

---

## 🖼️ Screenshots

Place screenshots in `assets/` folder and reference as follows:
- ![Search](./assets/search.png)
- ![Category Meals](./assets/category-meals.png)
- ![Meal Details](./assets/meal-details.png)


---

## 📝 Notes

- Caffeine chosen for development simplicity and speed
- Cache keys are normalized for consistent lookups
- API responses use a predictable envelope for frontend integration
- Minimal frontend, avoids unnecessary libraries

---

## ✅ Conclusion

TheMealDB Explorer meets assignment requirements: local execution, REST APIs, caching, responsive UI, and a clean split between frontend and backend.  
This project showcases robust full-stack engineering using Spring Boot and React.

---
```
