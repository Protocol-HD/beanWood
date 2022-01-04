import axios from 'axios';
import React, { useEffect, useRef, useState } from 'react';
import ColorList from '../widget/shopWidget/ColorList';
import SizeList from '../widget/shopWidget/SizeList';

function AddProductInfo({ showMenu }) {
	const sizeUrl = 'http://localhost:8080/size/save';
	const colorUrl = 'http://localhost:8080/color/save';
	const getsizeUrl = 'http://localhost:8080/size/findAll'
	const getcolorUrl = 'http://localhost:8080/color/findAll';
	const size = useRef();
	const color = useRef();
	const [getSize, setGetSize] = useState([]);
	const [getColor, setGetColor] = useState([]);
	const [check, setCheck] = useState();

	useEffect(() => {
		axios.get(getsizeUrl).then(Response => setGetSize(Response.data));
		axios.get(getcolorUrl).then(Response => setGetColor(Response.data));
	}, [])

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
		<div className={showMenu === 4 ? "tab-pane fade show active" : "tab-pane fade"} id="addProductInfo">
			<h4>Add ProductInfo</h4>
			<h5>size list</h5>
			<div className="container-fluid">
				<div className="row">
					<div className="col-12">
						<div className="table_desc">
							<div className="table_page table-responsive">
								<table>
									<thead>
										<tr>
											<th className="size_no">size no</th>
											<th className="size_name">size name</th>
										</tr>
									</thead>
									<tbody>
										{
											getSize.map(item => (
												<SizeList
													key={item.id}
													check={check}
													item={item} />
											))
										}
									</tbody>
								</table>
								<table>
									<thead>
										<tr>
											<th className="color_no">color no</th>
											<th className="color_name">color name</th>
										</tr>
									</thead>
									<tbody>
										{
											getColor.map(item => (
												<ColorList
													key={item.id}
													check={check}
													item={item} />
											))
										}
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
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
						상품 정보 등록
					</button>
				</div>
			</form>
		</div>
	);
}

export default AddProductInfo;
