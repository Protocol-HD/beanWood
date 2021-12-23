import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';

function Single_item_cart({ item, delCheck, setDelCheck }) {
    const [product, setProduct] = useState([]);

    const handleDelete = () => {
        if(window.confirm("Do you want to delete it from the cart?")) {
            axios.delete(`http://localhost:3005/cartLists/${item.id}`)
            .then(Response => {
                setDelCheck(!delCheck)
            })
        } else {
            window.alert("Cancel")
        }
    }

    useEffect(() => {
        axios.get(`http://localhost:3006/products/${item.productId}`)
        .then(Response => {
            setProduct(Response.data);
        })
    }, [item.productId])

    return (
        <li className="single-item">
            <div className="box">
                <Link to={`/shop/detail/${product.id}`} className="image">
                    <img src={`assets/images/products/${item.itemImg}`} alt={product.productName} className="offcanvas-wishlist-image"/>
                </Link>
                <div className="content">
                    <Link to={`/shop/detail/${product.id}`} className="title">{product.productName}</Link>
                    <div className="offcanvas-wishlist-item-details">
                        <span className="offcanvas-wishlist-item-details-quantity">{item.quantity} x </span>
                        <span className="offcanvas-wishlist-item-details-price">${product.price}</span>
                    </div>
                </div>
            </div>
            <div className="item-delete text-right">
                <Link to=""><img onClick={handleDelete} src="assets/images/icons/icon-trash.svg" alt=""/></Link>
            </div>
        </li>
    );
}

export default Single_item_cart;