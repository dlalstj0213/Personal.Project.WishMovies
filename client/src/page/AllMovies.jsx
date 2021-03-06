import React from 'react';
import Movies from '../components/Movies';

const AllMovies = ({
	movies,
	selectedMovie,
	movieService,
	onSelect,
	onDelete,
	onAdd,
}) => {
	return (
		<Movies
			movies={movies}
			selectedMovie={selectedMovie}
			movieService={movieService}
			onSelect={onSelect}
			onDelete={onDelete}
			onAdd={onAdd}
		/>
	);
};

export default AllMovies;
