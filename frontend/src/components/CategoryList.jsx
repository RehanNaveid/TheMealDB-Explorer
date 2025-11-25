import React from 'react';

const CategoryList = ({ categories, selectedCategory, onSelectCategory }) => {
    return (
        <div className="categories">
            <div
                className={`category-chip ${!selectedCategory ? 'active' : ''}`}
                onClick={() => onSelectCategory(null)}
            >
                All
            </div>
            {categories.map((cat) => (
                <div
                    key={cat.idCategory}
                    className={`category-chip ${selectedCategory === cat.strCategory ? 'active' : ''}`}
                    onClick={() => onSelectCategory(cat.strCategory)}
                >
                    {cat.strCategory}
                </div>
            ))}
        </div>
    );
};

export default CategoryList;
