import axios from 'axios';
import React, { useEffect, useRef, useState } from 'react';

function AddProductInfo() {
	const categoryUrl = 'http://localhost:8080/category/save';
	const sizeUrl = 'http://localhost:8080/size/save';
	const colorUrl = 'http://localhost:8080/color/save';
	const categoryName = useRef();
	const size = useRef();
	const color = useRef();
	const [sizeId, setSizeId] = useState();
	const [colorId, setColorId] = useState();

	const addProductInfo = (e) => {
		e.preventDefault();
		axios
			.post(categoryUrl, {
				categoryName: categoryName.current.value,
			})
			.then((Response) => setSizeId(Response.data.id));
		axios
			.post(sizeUrl, {
				size: size.current.value,
			})
			.then((Response) => setColorId(Response.data.id));
	};

	useEffect(() => {
		if (sizeId && colorId)
			axios.post(colorUrl, {
				sizeId: sizeId,
				colorId: colorId,
			});
	}, [sizeId, colorId]);

	return (
		<div className='container'>
			<div className='row col-6 m-auto'>
				<form onSubmit={addProductInfo}>
					<div className='col-12'>
						<label htmlFor='categoryName' className='form-label'>
							category name
						</label>
						<input
							type='text'
							className='form-control'
							id='categoryName'
							placeholder='category name'
							required=''
							ref={categoryName}
						/>
					</div>

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
