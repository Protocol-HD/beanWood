import axios from 'axios';
import React, { useEffect, useRef, useState } from 'react';

function AddProductInfo() {
	const sizeUrl = 'http://localhost:8080/size/save';
	const colorUrl = 'http://localhost:8080/color/save';
	const size = useRef();
	const color = useRef();

	const addProductInfo = (e) => {
		e.preventDefault();
		console.log(size.current.value);
		console.log(color.current.value);

		if (size.current.value !== "") {
			axios.post(sizeUrl, { sizeName: size.current.value })
		}
		if (color.current.value !== "") {
			axios.post(colorUrl, { colorName: color.current.value })
		}
	};

	return (
		<div className='container'>
			<div className='row col-6 m-auto'>
				<form onSubmit={addProductInfo}>
					<div className='col-12'>
						<label htmlFor='size' className='form-label'>
							size
						</label>
						<input
							type='text'
							className='form-control'
							id='size'
							placeholder='size'
							required=''
							ref={size}
						/>
					</div>

					<div className='col-12'>
						<label htmlFor='color' className='form-label'>
							color
						</label>
						<input
							type='text'
							className='form-control'
							id='color'
							placeholder='color'
							required=''
							ref={color}
						/>
					</div>

					<div className='text-center mt-5'>
						<button type='submit' className='btn btn-secondary'>
							submit
						</button>
					</div>
				</form>
			</div>
		</div>
	);
}

export default AddProductInfo;
