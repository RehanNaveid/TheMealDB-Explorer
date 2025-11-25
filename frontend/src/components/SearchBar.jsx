import React, { useState } from 'react';

const SearchBar = ({ onSearch }) => {
    const [query, setQuery] = useState('');

    const handleSubmit = (e) => {
        e.preventDefault();
        onSearch(query);
    };

    return (
        <form className="search-bar" onSubmit={handleSubmit}>
            <input
                type="text"
                placeholder="Search for a meal..."
                value={query}
                onChange={(e) => setQuery(e.target.value)}
            />
        </form>
    );
};

export default SearchBar;
