import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';

function WishTableLine({ item, delCheck, setDelCheck }) {

    const [wishProduct, setWishProduct] = useState([]);
    const [imgUrl, setImgUrl] = useState("")

    const handleDelete = () => {
        if(window.confirm("Do you want to delete it from the wish list?")) {
            axios.delete(`http://localhost:3005/wishLists/${item.id}`)
            .then(Response => {
                setDelCheck(!delCheck)
            })
        } else {
            window.alert("Cancel")
        }
    }

    const handlePost = () => {
        axios.post("http://localhost:3005/cartLists", {
            productId: item.id, 
            quantity: 1, 
            price: item.price,
            color : 1,
            size : "S",
            itemTotal: item.price * 1,
            itemImg: imgUrl
        })
        .then(Response => {
            if(Response.ok) alert("Success!")
        })
    }

    useEffect(() => {
        axios.get(`http://localhost:3006/products/${item.productId}`)
        .then(Response => {
            setWishProduct(Response.data);
            setImgUrl(Response.data.productImage[0].imageUrl)
        })
    }, [item.productId])

    return (
        <tr>
            <td className="product_remove"><Link to=""><img onClick={handleDelete} src="assets/images/icons/icon-trash.svg" alt="" /></Link></td>
            <td className="product_thumb"><Link to={`/shop/detail/${wishProduct.id}`}><img src={`assets/images/products/${item.itemImg}`} alt={wishProduct.productName} /></Link></td>
            <td className="product_name"><Link to={`/shop/detail/${wishProduct.id}`}>{wishProduct.productName}</Link></td>
            <td className="product-price">${wishProduct.price}</td>
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