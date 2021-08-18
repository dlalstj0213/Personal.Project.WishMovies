import React from 'react';
import Movies from '../components/Movies';

const MyMovies = ({
	movies,
	selectedMovie,
	movieService,
	onMyMovies,
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
			isMyMovie={true}
			onMyMovies={onMyMovies}
			onDelete={onDelete}
			onAdd={onAdd}
		/>
	);
};

export default MyMovies;
