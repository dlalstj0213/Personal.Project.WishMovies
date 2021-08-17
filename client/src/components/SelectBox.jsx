import React, { memo } from 'react';

const SelectBox = memo(({ category, option, allOption, reference }) => {
	return (
		<>
			<label className="">{category}</label>
			<select ref={reference}>
				{allOption && (
					<option value="" defaultValue="">
						전체
					</option>
				)}
				{option.map((item) => (
					<option value={item.code}>{item.name}</option>
				))}
			</select>
		</>
	);
});

export default SelectBox;
