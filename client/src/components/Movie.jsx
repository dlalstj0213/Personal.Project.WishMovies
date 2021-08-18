import React, { memo } from 'react';

const Movie = memo(({ movie, onDelete, onAdd, isMyMovie }) => {
	const onClickAdd = () => {
		onAdd(movie);
	};
	const onClickDelete = () => {
		onDelete(movie);
	};

	return (
		<div className="movie-selected">
			<h1 className="movie-title">
				{movie.title}
				<br />
				<span className="movie-subtitle">{movie.subtitle}</span>
			</h1>

			<div className="movie-info">
				<img className="movie-img" src={movie.image} alt="" />
				<div className="movie-content">
					<div className="movie-text">
						<p>제작일: {movie.pubDate}</p>
						<p>감독: {movie.director}</p>
						<p>출연: {movie.actor}</p>
						<p>
							평점: <span>{movie.userRating}</span>
						</p>
						{!!isMyMovie ? (
							<button className="del-button" onClick={onClickDelete}>
								내 영화 제거
							</button>
						) : (
							<button className="add-button" onClick={onClickAdd}>
								내 영화 추가
							</button>
						)}
					</div>
				</div>
			</div>
		</div>
	);
});

export default Movie;
