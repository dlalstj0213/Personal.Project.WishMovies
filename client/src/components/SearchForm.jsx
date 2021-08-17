import React, { memo, useRef, useState } from 'react';
import SelectBox from './SelectBox';

const SearchForm = memo(({ onSearch }) => {
	const inputRef = useRef();
	const countryRef = useRef();
	const genreRef = useRef();
	const c = [
		{ name: '한국', code: 'KR' },
		{ name: '일본', code: 'JP' },
		{ name: '미국', code: 'US' },
		{ name: '홍콩', code: 'HK' },
		{ name: '영국', code: 'GB' },
		{ name: '프랑스', code: 'FR' },
		{ name: '기타', code: 'ETC' },
	];
	const g = [
		{ name: '드라마', code: '1' },
		{ name: '판타지', code: '2' },
		{ name: '서부', code: '3' },
		{ name: '공포', code: '4' },
		{ name: '로맨스', code: '5' },
		{ name: '모험', code: '6' },
		{ name: '스릴러', code: '7' },
		{ name: '느와르', code: '8' },
		{ name: '컬트', code: '9' },
		{ name: '다큐멘터리', code: '10' },
		{ name: '코미디', code: '11' },
		{ name: '가족', code: '12' },
		{ name: '미스터리', code: '13' },
		{ name: '전쟁', code: '14' },
		{ name: '애니메이션', code: '15' },
		{ name: '범죄', code: '16' },
		{ name: '뮤지컬', code: '17' },
		{ name: 'SF', code: '18' },
		{ name: '액션', code: '19' },
		{ name: '무협', code: '20' },
		{ name: '에로', code: '21' },
		{ name: '서스펜스', code: '22' },
		{ name: '서사', code: '23' },
		{ name: '블랙코미디', code: '24' },
		{ name: '실험', code: '25' },
		{ name: '영화카툰', code: '26' },
		{ name: '영화음악', code: '27' },
		{ name: '영화패러디포스터', code: '28' },
	];
	const [country, setCountry] = useState(c);
	const [genre, setGenre] = useState(g);

	const handleSearch = () => {
		const title = inputRef.current.value;
		const country = countryRef.current.value;
		const genre = genreRef.current.value;
		onSearch(title, country, genre);
	};

	const onClick = (e) => {
		e.preventDefault();
		handleSearch();
	};

	const onKeyPress = (e) => {
		if (e.key === 'Enter') {
			handleSearch();
		}
	};

	return (
		<>
			<div className="select-box">
				<SelectBox
					category="국가"
					option={country}
					allOption={true}
					reference={countryRef}
				/>
				<SelectBox
					category="장르"
					option={genre}
					allOption={true}
					reference={genreRef}
				/>
			</div>
			<div className="search-box">
				<button className="search-icon" onClick={onClick}>
					<i className="fa fa-search"></i>
				</button>
				<input
					placeholder="영화검색"
					ref={inputRef}
					onKeyPress={onKeyPress}
				></input>
			</div>
		</>
	);
});

export default SearchForm;
