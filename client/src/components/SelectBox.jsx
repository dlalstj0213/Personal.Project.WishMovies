import React, { memo } from 'react';

const SelectBox = memo(({ category, option, allOption }) => {
	console.log(allOption);
	return (
		<>
			<label className="">{category}</label>
			<select name="" id="">
				{allOption && (
					<option className="" value="all" selected>
						전체
					</option>
				)}
				{option.map((item) => (
					<option value="1">{item}</option>
				))}
			</select>
		</>
	);
});

export default SelectBox;
