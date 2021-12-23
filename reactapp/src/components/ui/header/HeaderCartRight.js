import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';
import Single_item_cart from '../../widget/header_wiget/Single_item_cart';

function HeaderCartRight() {
    const [cart, setCart] = useState([]);
    const [delCheck, setDelCheck] = useState(false);

    useEffect(() => {
        const url = "http://localhost:3005/cartLists"
        axios.get(url)
        .then(Response => {
            setCart(Response.data);
        })
    }, [delCheck])

    return ( 
        <div className="offcanvas offcanvas-end" tabindex="-1" id="addcartOffcanvas">
            <div className="offcanvas-header">
                <h5 className="offcanvas-title">Add Cart</h5>
                <button type="button" className="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
            </div>
            <div className="offcanvas-body">
                <ul className="offcanvas-products-list">
                    {
                        cart.map(item => (
                            <Single_item_cart 
                                item={item}
                                delCheck={delCheck} 
                                setDelCheck={setDelCheck}
                            />
                        ))
                    }
                </ul>
                <div className="offcanvas-action-link">
                    <Link to="/cart" className="btn">View Cart</Link>
                    <Link to="checkout.html" className="btn">Checkout</Link>
                </div>
            </div>
        </div>

    );
}

export default HeaderCartRight;