import './app.css';
import { useCallback, useEffect, useState } from 'react';
import Header from './components/Header';
import Navbar from './components/Navbar';
import { Route, Switch } from 'react-router-dom';
import Search from './page/Search';
import AllMovies from './page/AllMovies';

function App({ movieService }) {
	const [movies, setMovies] = useState([]);
	const [selectedMovie, setSelectedMovie] = useState(null);

	const selectMovie = (movie) => {
		setSelectedMovie(movie);
	};

	const search = useCallback(
		(query, country, genre) => {
			// setSelectedMovie(null);
			movieService.search(query, country, genre).then((movies) => {
				setMovies(movies);
			});
		},
		[movieService]
	);

	useEffect(() => {
		movieService.search('베테랑', '', '').then((movies) => {
			setMovies(movies);
			setSelectedMovie(movies[0]);
		});
	}, [movieService]);

	console.log(movies); // 데이터 테스팅 코드

	return (
		<div className="app">
			<Navbar />
			<Header />
			<Search onSearch={search} />
			<AllMovies
				movies={movies}
				selectedMovie={selectedMovie}
				movieService={movieService}
				onSelect={selectMovie}
			/>
		</div>
	);
}

export default App;
