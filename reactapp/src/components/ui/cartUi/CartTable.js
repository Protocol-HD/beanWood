import React, { useEffect } from 'react';
import { useState } from 'react/cjs/react.development';
import CartTableLine from './CartTableLine';
import axios from 'axios';

function CartTable({setCheck, check}) {
    const [cart, setCart] = useState([]);
    const [delCheck, setDelCheck] = useState(false);

    // useEffect(() => {
    //     console.log(check)
    //     fetch("http://localhost:3005/cartLists")
    //     .then(res => {
    //         return res.json();
    //     })
    //     .then(data => {
    //         setCart(data);
    //     })
    // }, [])
    useEffect(() => {
        const url = "http://localhost:3005/cartLists"
        axios.get(url)
        .then(Response => {
            setCart(Response.data);
        })
    }, [delCheck])

    return (
        <div className="cart-table-wrapper">
            <div className="container-fluid">
                <div className="row">
                    <div className="col-12">
                        <div className="table_desc">
                            <div className="table_page table-responsive">
                                <table>
                                    
                                    <thead>
                                        <tr>
                                            <th className="product_remove">Delete</th>
                                            <th className="product_thumb">Image</th>
                                            <th className="product_name">Product</th>
                                            <th className="product-price">Price</th>
                                            <th className="product_quantity">Quantity</th>
                                            <th className="product_total">Total</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        {
                                            cart.map(item => (
                                                <CartTableLine 
                                                    item={item}
                                                    setCheck = {setCheck}
                                                    check = { check }
                                                    delCheck={delCheck}
                                                    setDelCheck={setDelCheck}
                                                />
                                            ))
                                        }

                                    </tbody>
                                </table>
                            </div>
                            <div className="cart_submit">
                                <button className="btn btn-sm btn-radius btn-default" type="submit">update cart</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default CartTable;