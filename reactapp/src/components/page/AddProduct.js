import axios from 'axios';
import React, { useEffect, useRef, useState } from 'react';

function AddProduct() {
	const productUrl = "http://localhost:8080/product/save";
	const productImageUrl = "http://localhost:8080/productImage/save";
	const imageUrl = "http://localhost:8080/image/save";
	const productName = useRef();
	const productPrice = useRef();
	const productSale = useRef();
	const productDescription = useRef();
	const productCategory = useRef();
	const productColor = useRef();
	const productSize = useRef();
	const productImage = useRef();
	const [productId, setProductId] = useState();
	const [imageId, setImageId] = useState();

	const addProduct = (e) => {
		e.preventDefault();
		axios.post(productUrl, {
			productName: productName.current.value,
			price: productPrice.current.value,
			sale: productSale.current.value,
			description: productDescription.current.value,
			categoryId: productCategory.current.value,
			colorId: productColor.current.value,
			sizeId: productSize.current.value
		})
			.then(Response => setProductId(Response.data.id))
		axios.post(imageUrl, {
			imageUrl: productImage.current.value
		})
			.then(Response => setImageId(Response.data.id))
	}

	useEffect(() => {
		if (productId && imageId)
			axios.post(productImageUrl, {
				productId: productId,
				imageId: imageId
			})
	}, [productId, imageId])

	return (
		<div className='container' >
			<div className='row col-6 m-auto'>
				<form onSubmit={addProduct}>
					<div className="col-12">
						<label for="name" className="form-label">name</label>
						<input type="text" className="form-control" id="name" placeholder="상품명" required="" ref={productName} />
					</div>

					<div className="col-12">
						<label for="price" className="form-label">price</label>
						<input type="text" className="form-control" id="price" placeholder="상품 가격" required="" ref={productPrice} />
					</div>

					<div className="col-12">
						<label for="sale" className="form-label">sale</label>
						<input type="text" className="form-control" id="sale" placeholder="할인율" required="" ref={productSale} />
					</div>

					<div className="col-12">
						<label for="description" className="form-label">description</label>
						<textarea type="text" className="form-control text-box" id="description" placeholder="상품 상세 설명" required="" ref={productDescription} />
					</div>

					<div className="col-12">
						<label for="category" className="form-label">category</label>
						<input type="text" className="form-control" id="category" placeholder="상품 분류" required="" ref={productCategory} />
					</div>

					<div className="col-12">
						<label for="color" className="form-label">color</label>
						<input type="text" className="form-control" id="color" placeholder="색상" required="" ref={productColor} />
					</div>

					<div className="col-12">
						<label for="size" className="form-label">size</label>
						<input type="text" className="form-control" id="size" placeholder="상품 사이즈" required="" ref={productSize} />
					</div>

					<div className="col-12">
						<label for="image" className="form-label">image</label>
						<input type="text" className="form-control" id="image" placeholder="상품 사진" required="" ref={productImage} />
					</div>

					<div className='text-center mt-5'>
						<button type="submit" class="btn btn-secondary">submit</button>
					</div>
				</form>
			</div>
		</div>
	);
}

export default AddProduct;