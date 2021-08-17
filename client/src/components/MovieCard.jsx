import React, { memo } from 'react';

const MovieCard = memo(({ movie, onSelect }) => {
	const onClick = (e) => {
		onSelect(movie);
	};

	return (
		<li className="movie" onClick={onClick}>
			<img src={movie.image} alt="" />
			{movie.title}
			<br />
			{movie.director}
		</li>
	);
});

export default MovieCard;
