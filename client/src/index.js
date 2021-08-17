import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import '@fortawesome/fontawesome-free/js/all.js';
import App from './App';
import MovieService from './service/movie.js';
import HttpClient from './module/httpClient.js';

const movieService = new MovieService(new HttpClient('http://localhost:3000'));

ReactDOM.render(
	<React.StrictMode>
		<App movieService={movieService} />
	</React.StrictMode>,
	document.getElementById('root')
);
