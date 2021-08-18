import './app.css';

import Header from './components/Header';
import Navbar from './components/Navbar';
import { Route, Switch, useHistory } from 'react-router-dom';
import { useCallback, useState } from 'react';
import Search from './page/Search';
import AllMovies from './page/AllMovies';
import MyMovies from './page/MyMovies';

function App({ movieService }) {
	const history = useHistory();
	const [movies, setMovies] = useState([]);
	const [selectedMovie, setSelectedMovie] = useState(null);

	const onSearchMovies = () => {
		history.push('/');
		setMovies([]);
		setSelectedMovie(null);
	};

	const onFindMyMovies = () => {
		history.push(`/my`);
		setMovies([]);
		setSelectedMovie(null);
	};

	const selectMovie = (movie) => {
		setSelectedMovie(movie);
	};

	const search = useCallback(
		(query, country, genre) => {
			onSearchMovies();
			movieService.search(query, country, genre).then((movies) => {
				setMovies([...movies]);
			});
		},
		[movieService]
	);

	const findMyMovies = () => {
		movieService.findMyMovies().then((movies) => {
			setMovies([...movies]);
		});
	};

	const addMovie = (movie) => {
		movieService
			.add(movie)
			.then((result) => {
				console.log(result);
				console.log('SUCCESS');
			})
			.catch((err) => {});
	};

	const deleteMovie = (movie) => {
		const index = movie.index;
		movieService
			.delete(index)
			.then(() => {
				setMovies((movies) => movies.filter((m) => m.index !== index));
				setSelectedMovie(null);
			})
			.catch((err) => {});
	};

	return (
		<div className="app">
			<Navbar onSearchMovies={onSearchMovies} onFindMyMovies={onFindMyMovies} />
			<Header />
			<Search onSearch={search} />
			<Switch>
				(
				<>
					<Route exact path="/">
						<AllMovies
							movies={movies}
							selectedMovie={selectedMovie}
							movieService={movieService}
							onSelect={selectMovie}
							onDelete={deleteMovie}
							onAdd={addMovie}
						/>
					</Route>
					<Route exact path="/my">
						<MyMovies
							movies={movies}
							selectedMovie={selectedMovie}
							movieService={movieService}
							onMyMovies={findMyMovies}
							onSelect={selectMovie}
							onDelete={deleteMovie}
							onAdd={addMovie}
						/>
					</Route>
				</>
				)
			</Switch>
		</div>
	);
}

export default App;
