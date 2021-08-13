import React, { memo, useState } from 'react';
import SelectBox from './SelectBox';

const SearchForm = memo(() => {
	const c = ['한국', '미국', '중국'];
	const t = ['로맨틱', 'SF', '판타지'];
	const [country, setCountry] = useState(c);
	const [genre, setGenre] = useState(t);
	return (
		<form className="search-form">
			<div className="select-box">
				<SelectBox category="국가" option={country} allOption={true} />
				<SelectBox category="장르" option={genre} allOption={true} />
			</div>
			<div className="search-box">
				<i class="fa fa-search search-icon"></i>
				<input placeholder="영화검색"></input>
			</div>
		</form>
	);
});

export default SearchForm;
