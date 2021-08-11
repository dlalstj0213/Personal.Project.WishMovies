import React, { memo } from 'react';

const Navbar = memo(() => {
	return (
		<nav className="navbar">
			<ul className="navbar-menu">
				<li className="navbar-menu-item">
					<a href="#">Home</a>
				</li>
				<li>|</li>
				<li className="navbar-menu-item">
					<a href="#">My Movies</a>
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
