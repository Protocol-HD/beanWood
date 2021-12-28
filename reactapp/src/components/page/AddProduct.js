import axios from 'axios';
import React, { useRef, useState } from 'react';

function AddProduct() {
	const productUrl = "http://localhost:8080/product/save";
	const productImageUrl = "http://localhost:8080/productImage/save";
	const productName = useRef();
	const productPrice = useRef();
	const productSale = useRef();
	const productDescription = useRef();
	const productCategory = useRef();
	const productColor = useRef();
	const productSize = useRef();
	const productImage = useRef();
	const [productId, setProductId] = useState();

	const addProduct = (e) => {
		e.preventDefault();
		axios.post(productUrl, {
			productName: productName.current.value,
			price: parseInt(productPrice.current.value),
			sale: parseInt(productSale.current.value),
			description: productDescription.current.value,
			category: parseInt(productCategory.current.value),
			color: parseInt(productColor.current.value),
			size: parseInt(productSize.current.value),
		})
		// .then(Response => setProductId(Response.data.id))
		// .then(axios.post(productImageUrl, {
		// 	productId: parseInt(productId),
		// 	image: productImage.current.value,
		// }))
	}

	return (
		<div className='container' >
			<div className='row'>
				<form onSubmit={addProduct}>
					<div className="col-12">
						<label for="name" className="form-label">name</label>
						<input type="text" className="form-control" id="name" placeholder="product name" required="" ref={productName} />
					</div>

					<div className="col-12">
						<label for="price" className="form-label">price</label>
						<input type="text" className="form-control" id="price" placeholder="product price" required="" ref={productPrice} />
					</div>

					<div className="col-12">
						<label for="sale" className="form-label">sale</label>
						<input type="text" className="form-control" id="sale" placeholder="product sale" required="" ref={productSale} />
					</div>

					<div className="col-12">
						<label for="description" className="form-label">description</label>
						<input type="text" className="form-control" id="description" placeholder="product description" required="" ref={productDescription} />
					</div>

					<div className="col-12">
						<label for="category" className="form-label">category</label>
						<input type="text" className="form-control" id="category" placeholder="product category" required="" ref={productCategory} />
					</div>

					<div className="col-12">
						<label for="color" className="form-label">color</label>
						<input type="text" className="form-control" id="color" placeholder="product color" required="" ref={productColor} />
					</div>

					<div className="col-12">
						<label for="size" className="form-label">size</label>
						<input type="text" className="form-control" id="size" placeholder="product size" required="" ref={productSize} />
					</div>

					<div className="col-12">
						<label for="image" className="form-label">image</label>
						<input type="text" className="form-control" id="image" placeholder="product image" required="" ref={productImage} />
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