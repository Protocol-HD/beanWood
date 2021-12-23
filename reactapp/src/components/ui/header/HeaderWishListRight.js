import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';
import Single_item_wish from '../../widget/header_wiget/Single_item_wish';

function HeaderWishListRight() {
    const [wish, setWish] = useState([]);
    const [delCheck, setDelCheck] = useState(false);

    useEffect(() => {
        const url = "http://localhost:3005/wishLists"
        axios.get(url)
        .then(Response => {
            setWish(Response.data);
        })
    }, [delCheck])

    return ( 
        <div className="offcanvas offcanvas-end" tabindex="-1" id="wishlistOffcanvas">
            <div className="offcanvas-header">
                <h5 className="offcanvas-title">Wishlist</h5>
                <button type="button" className="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
            </div>
            <div className="offcanvas-body">
                <ul className="offcanvas-products-list">
                    {
                        wish.map(item => (
                            <Single_item_wish 
                                item={item} 
                                delCheck={delCheck} 
                                setDelCheck={setDelCheck} 
                            />
                        ))
                    }
                </ul>
                <div className="offcanvas-action-link">
                    <Link to="/wish" className="btn">View wishlist</Link>
                </div>
            </div>
        </div>
    );
}

export default HeaderWishListRight;