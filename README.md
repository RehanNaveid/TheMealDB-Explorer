# TheMealDB Explorer

A full-stack application to explore meals from TheMealDB, built with Spring Boot and React.

## Features
- **Backend**: Spring Boot 3, Java 21, Caffeine Caching, REST API.
- **Frontend**: React 18, Vite, Modern CSS, Responsive Design.
- **Functionality**: Search meals, browse categories, filter by category, view random meal, view meal details (ingredients, video).

## Prerequisites
- Java 21+
- Node.js 18+
- Maven (wrapper included)

## Getting Started

### Backend
1. Navigate to the backend directory:
   ```bash
   cd backend
   ```
2. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```
   The backend will start on `http://localhost:8080`.

### Frontend
1. Navigate to the frontend directory:
   ```bash
   cd frontend
   ```
2. Install dependencies (if not already done):
   ```bash
   npm install
   ```
3. Create `.env` file (if not exists):
   ```bash
   cp .env.example .env
   ```
4. Run the development server:
   ```bash
   npm run dev
   ```
   The frontend will start on `http://localhost:5173`.

## Architecture
- **Backend**: Proxies requests to TheMealDB to avoid exposing API keys (though TheMealDB is free) and to implement caching.
- **Frontend**: Consumes the backend API.

## API Endpoints
- `GET /api/search?q={name}`
- `GET /api/categories`
- `GET /api/category/{name}`
- `GET /api/random`
- `GET /api/meal/{id}`
