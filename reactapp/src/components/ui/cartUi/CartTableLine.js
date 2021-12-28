import React, { useEffect, useRef } from 'react';
import { Link } from 'react-router-dom';
import { useState } from 'react/cjs/react.development';
import axios from 'axios';

function CartTableLine({ item, setCheck, check, delCheck, setDelCheck }) {
	const qty = useRef();
	const [intQty, setIntQty] = useState(item.quantity);
	const [product, setProduct] = useState({});
	const [productImg, setProductImg] = useState([]);

	const handleQuantity = () => {
		setCheck(true)
		setIntQty(parseInt(qty.current.value))
		axios.put("http://localhost:8080/cartList/update", {
			...item,
			id: item.id,
			productId: product.id,
			quantity: parseInt(qty.current.value)
		});
	}

	const handleDelete = () => {


		if (window.confirm("Do you want to delete from the cart?")) {
			axios.delete(`http://localhost:8080/cartList/delete/${item.id}`)
				.then(setDelCheck(!delCheck))
		} else {
			window.alert("Cacel")
		}
	}


	useEffect(() => {
		axios.get(`http://localhost:8080/product/find/${item.product.id}`)
			.then(Response => {
				setProduct(Response.data);
			});
		axios.get(`http://localhost:8080/productImage/findByProductId/${item.product.id}`)
			.then(Response => {
				console.log(Response.data[0].image.imageUrl);
				setProductImg(Response.data[0].image.imageUrl);
			});
	}, []);

	return (
		<tr>
			<td className="product_remove"><Link to="/cart"><img onClick={handleDelete} src="assets/images/icons/icon-trash.svg" alt="" /></Link></td>
			<td className="product_thumb"><Link to={`/shop/detail/${product.id}`}><img src={`assets/images/products/${productImg}`} alt={product.productName} /></Link></td>
			<td className="product_name">
				<Link to={`/shop/detail/${product.id}`}>{product.productName} {item.color == 1 ? "Red" : item.color == 2 ? "Green" : item.color == 3 ? "Blue" : item.color == 4 ? "Black" : ""} {item.size}</Link>
			</td>
			<td className="product-price">${product.price}</td>
			<td className="product_quantity"><label>Quantity</label> <input defaultValue={item.quantity} min="1" onChange={handleQuantity} ref={qty} type="number" /></td>
			<td className="product_total">${intQty * product.price}</td>
		</tr>
	);
}

export default CartTableLine;