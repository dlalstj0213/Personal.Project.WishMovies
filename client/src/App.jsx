import './app.css';
import { useEffect, useState } from 'react';
import Header from './components/Header';
import Navbar from './components/Navbar';
import { Route, Switch } from 'react-router-dom';
import Search from './page/Search';

function App() {
	const [message, setMessage] = useState('');

	// useEffect(() => {
	// 	fetch('/hello')
	// 		.then((response) => response.text())
	// 		.then((message) => {
	// 			setMessage(message);
	// 		});
	// }, []);

	return (
		<div className="app">
			<Navbar />
			<Header />
			<Search />
		</div>
	);
}

export default App;
