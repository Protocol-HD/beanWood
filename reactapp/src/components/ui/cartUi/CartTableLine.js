import React, { useEffect, useRef } from 'react';
import { Link } from 'react-router-dom';
import { useState } from 'react/cjs/react.development';
import axios from 'axios';

function CartTableLine({item, setCheck, check, delCheck, setDelCheck}) {
    const [cartProduct, setCartProduct] = useState([]);
    const qty = useRef()
    const [intQty, setIntQty] = useState(item.quantity)

    const handleQuantity = () => {
        setCheck(true)
        setIntQty(parseInt(qty.current.value))
        fetch(`http://localhost:3005/cartLists/${item.id}`, {
            method: "PUT", 
            headers: {
                "content-Type": "application/json", 
            }, 
            body: JSON.stringify({
                ...item, 
                quantity: parseInt(qty.current.value),
                itemTotal: cartProduct.price * parseInt(qty.current.value)
            })
        }).then(res => {
            if (res.ok) {
                console.log("ok")
            }
        });

        // axios.post(`http://localhost:3005/cartLists/${item.id}`, {
        //     quantity: parseInt(qty.current.value),
        //     itemTotal: cartProduct.price * parseInt(qty.current.value)
        // })
        // .then(Response => {
        //     console.log("ok")
        // });
    }

    const handleDelete = () => {
        // if(window.confirm("카트에서 삭제?")) {
        //     setCheck(!check)
        //     fetch(`http://localhost:3005/cartLists/${item.id}`, {
        //         method: "DELETE",
        //     })
        //     .then(res => {
        //         if(res.ok) {
        //             window.alert("삭제되었습니다.");
        //         }
        //     })
        // } else {
        //     window.alert("삭제 취소")
        // }

        if(window.confirm("Do you want to delete from the cart?")) {
            axios.delete(`http://localhost:3005/cartLists/${item.id}`)
            .then(Response => {
                setDelCheck(!delCheck)
            })
        } else {
            window.alert("Cacel")
        }
    }

    // useEffect(() => {
    //     console.log(check)
    //     fetch(`http://localhost:3005/products/${item.productId}`)
    //     .then(res => {
    //         return res.json();
    //     })
    //     .then(data => {
    //         setCartProduct(data);
    //     })
    // }, [item.productId])

    useEffect(() => {
        console.log(check)
        axios.get(`http://localhost:3006/products/${item.productId}`)
        .then(Response => {
            setCartProduct(Response.data);
        })
    }, [item.productId])

    return (
        <tr>
            <td className="product_remove"><Link to="/cart"><img onClick={handleDelete} src="assets/images/icons/icon-trash.svg" alt="" /></Link></td>
            <td className="product_thumb"><Link to={`/shop/detail/${cartProduct.id}`}><img src={`assets/images/products/${item.itemImg}`} alt={cartProduct.productName} /></Link></td>
            <td className="product_name">
                <Link to={`/shop/detail/${cartProduct.id}`}>{cartProduct.productName} {item.color == 1 ? "Red" : item.color == 2 ? "Green" : item.color == 3 ? "Blue" : item.color == 4 ? "Black" : ""} {item.size}</Link>
            </td>
            <td className="product-price">${cartProduct.price}</td>
            <td className="product_quantity"><label>Quantity</label> <input defaultValue={item.quantity} min="1" onChange={handleQuantity} ref={qty} type="number" /></td>
            <td className="product_total">${ intQty * cartProduct.price}</td>
        </tr>
    );
}

export default CartTableLine;