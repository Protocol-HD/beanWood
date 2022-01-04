import axios from 'axios';
import React, { useEffect, useState } from 'react';

function EditProductListItem({ product, setShowMenu, setEditId }) {
	const findProductImageUrl = "http://localhost:8080/productImage/findByProductId/";
	const [imageUrl, setImageUrl] = useState("");

	useEffect(() => {
		axios.get(findProductImageUrl + product.id).then(Response => {
			if (Response.data[0]) {
				setImageUrl(Response.data[0].image.imageUrl);
			} else {
				setImageUrl("No Image");
			}
		});
	})

	return (
		<tr key={product.id}>
			<td className="product_remove"><button><img src="assets/images/icons/icon-trash.svg" alt="" /></button></td>
			<td className="product_thumb"><img src={`assets/images/products/${imageUrl}`} alt={imageUrl} /></td>
			<td className="product_name">{product.productName}</td>
			<td className="product-price">{product.price}$</td>
			<td className="product_addcart"><button onClick={() => { setShowMenu(3); setEditId(product.id) }} className="btn btn-sm btn-radius btn-default">Edit</button></td>
		</tr>
	);
}

export default EditProductListItem;