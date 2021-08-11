import React, { memo } from 'react';

const Header = memo(() => {
	return (
		<header className="app-header">
			<img src="./img/logo.jpg" alt="WishMovies Logo" className="logo-img" />
		</header>
	);
});

export default Header;
