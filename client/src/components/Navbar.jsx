import React, { memo } from 'react';

const Navbar = memo(({ onSearchMovies, onFindMyMovies }) => {
	return (
		<nav className="navbar">
			<ul className="navbar-menu">
				<li className="navbar-menu-item" onClick={onSearchMovies}>
					<a>Home</a>
				</li>
				<li>|</li>
				<li className="navbar-menu-item" onClick={onFindMyMovies}>
					<a>My Movies</a>
				</li>
				<li>|</li>
				<li className="navbar-menu-item">
					<a href="#">Login</a>
				</li>
			</ul>
		</nav>
	);
});

export default Navbar;
