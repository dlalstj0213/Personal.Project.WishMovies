import React from 'react';
import SearchForm from '../components/SearchForm';

const Search = ({ onSearch }) => {
	return (
		<div className="search-form sticky">
			<SearchForm onSearch={onSearch}></SearchForm>
		</div>
	);
};

export default Search;
