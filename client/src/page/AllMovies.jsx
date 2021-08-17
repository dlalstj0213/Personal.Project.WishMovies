import React from 'react';
import Movies from '../components/Movies';
import Movie from '../components/Movie';

const AllMovies = ({ movies, selectedMovie, movieService, onSelect }) => {
	return (
		<>
			{selectedMovie && (
				<Movie movie={selectedMovie} movieService={movieService} />
			)}
			<Movies movies={movies} onSelect={onSelect} />
		</>
	);
};

export default AllMovies;
