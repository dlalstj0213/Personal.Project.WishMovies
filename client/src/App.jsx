import './app.css';
import { useEffect, useState } from 'react';
import Header from './components/Header';
import Navbar from './components/Navbar';

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
		</div>
	);
}

export default App;
