import React, { memo, useEffect } from 'react';
import MovieCard from './MovieCard';
import Movie from './Movie';

const Movies = memo(
	({
		movies,
		selectedMovie,
		movieService,
		onSelect,
		isMyMovie,
		onMyMovies,
		onDelete,
		onAdd,
	}) => {
		if (isMyMovie && isMyMovie == true) isMyMovie = true;
		else isMyMovie = false;

		useEffect(() => {
			if (isMyMovie) onMyMovies();
		}, []);

		return (
			<>
				{selectedMovie && (
					<Movie
						movie={selectedMovie}
						movieService={movieService}
						isMyMovie={isMyMovie}
						onDelete={onDelete}
						onAdd={onAdd}
					/>
				)}
				<ul className="movies">
					{movies.map((movie) => (
						<MovieCard
							key={movie.title + movie.pubDate + movie.index}
							movie={movie}
							onSelect={onSelect}
						/>
					))}
				</ul>
			</>
		);
	}
);

export default Movies;
