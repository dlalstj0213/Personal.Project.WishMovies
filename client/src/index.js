import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import '@fortawesome/fontawesome-free/js/all.js';
import App from './App';
import MovieService from './service/movie.js';
import HttpClient from './module/httpClient.js';
import { BrowserRouter } from 'react-router-dom';

const movieService = new MovieService(
	new HttpClient('http://localhost:3000', '/api/movie')
);

ReactDOM.render(
	<React.StrictMode>
		<BrowserRouter>
			<App movieService={movieService} />
		</BrowserRouter>
	</React.StrictMode>,
	document.getElementById('root')
);
