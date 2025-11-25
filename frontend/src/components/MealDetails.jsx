import React from 'react';

const MealDetails = ({ meal, onClose }) => {
    if (!meal) return null;

    const ingredients = [];
    for (let i = 1; i <= 20; i++) {
        const ingredient = meal[`strIngredient${i}`];
        const measure = meal[`strMeasure${i}`];
        if (ingredient && ingredient.trim()) {
            ingredients.push(`${measure ? measure : ''} ${ingredient}`);
        }
    }

    const getEmbedUrl = (url) => {
        if (!url) return null;
        const videoId = url.split('v=')[1];
        const ampersandPosition = videoId ? videoId.indexOf('&') : -1;
        if (ampersandPosition !== -1) {
            return `https://www.youtube.com/embed/${videoId.substring(0, ampersandPosition)}`;
        }
        return `https://www.youtube.com/embed/${videoId}`;
    };

    return (
        <div className="modal-overlay" onClick={onClose}>
            <div className="modal-content" onClick={(e) => e.stopPropagation()}>
                <button className="close-btn" onClick={onClose}>&times;</button>

                <div className="meal-details-header">
                    <img src={meal.strMealThumb} alt={meal.strMeal} />
                    <div>
                        <h2>{meal.strMeal}</h2>
                        <p><strong>Category:</strong> {meal.strCategory}</p>
                        <p><strong>Area:</strong> {meal.strArea}</p>
                        <div className="ingredients-list">
                            {ingredients.map((ing, index) => (
                                <span key={index} className="ingredient-item">{ing}</span>
                            ))}
                        </div>
                    </div>
                </div>

                <div className="instructions">
                    <h3>Instructions</h3>
                    <p>{meal.strInstructions}</p>
                </div>

                {meal.strYoutube && (
                    <div className="video-container">
                        <iframe
                            src={getEmbedUrl(meal.strYoutube)}
                            title="YouTube video player"
                            frameBorder="0"
                            allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
                            allowFullScreen
                        ></iframe>
                    </div>
                )}
            </div>
        </div>
    );
};

export default MealDetails;
