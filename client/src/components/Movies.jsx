import React, { memo } from 'react';
import MovieCard from './MovieCard';

const Movies = memo(({ movies, onSelect }) => {
	return (
		<ul className="movies">
			{movies.map((movie) => (
				<MovieCard
					key={movie.title + movie.pubDate}
					movie={movie}
					onSelect={onSelect}
				/>
			))}
		</ul>
	);
});

export default Movies;
