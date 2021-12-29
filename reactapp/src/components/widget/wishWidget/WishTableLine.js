/* eslint-disable */
import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';

function WishTableLine({ item, delCheck, setDelCheck }) {
	const productImgUrl = "http://localhost:8080/productImage/findByProductId/";
	const wishListUrl = "http://localhost:8080/wishList/delete/";
	const cartListUrl = "http://localhost:8080/cartList/save";
	const [imgUrl, setImgUrl] = useState("");

	useEffect(() => {
		axios.get(productImgUrl + item.product.id).then(Response => setImgUrl(Response.data[0].image.imageUrl))
	}, [productImgUrl, item.product.id])

	const handleDelete = () => {
		if (window.confirm("Do you want to delete it from the wish list?")) {
			axios.delete(wishListUrl + item.id).then(setDelCheck(!delCheck))
		} else {
			window.alert("Cancel")
		}
	}

	const handlePost = () => {
		axios.post(cartListUrl, {
			productId: item.id,
			quantity: 1
		})
			.then(Response => {
				if (Response.ok) alert("Success!")
			})
	}

	return (
		<tr>
			<td className="product_remove"><Link to=""><img onClick={handleDelete} src="assets/images/icons/icon-trash.svg" alt="" /></Link></td>
			<td className="product_thumb"><Link to={`/shop/detail/${item.product.id}`}><img src={`assets/images/products/${imgUrl}`} alt={item.product.productName} /></Link></td>
			<td className="product_name"><Link to={`/shop/detail/${item.product.id}`}>{item.product.productName}</Link></td>
			<td className="product-price">${item.product.price}</td>
			<td className="product_stock">In Stock</td>
			<td className="product_addcart">
				<button onClick={handlePost}>
					<Link to="/cart" className="btn btn-sm btn-radius btn-default">Add To Cart</Link>
				</button>
			</td>
		</tr>
	);
}

export default WishTableLine;