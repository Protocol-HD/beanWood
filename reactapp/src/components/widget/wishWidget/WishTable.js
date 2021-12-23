import React, { useState, useEffect } from "react";
import axios from 'axios';
import WishTableLine from './WishTableLine';

function WishTable() {
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
        <div className="wishlist-section section-fluid-270 section-top-gap-100">
            <div className="wishlish-table-wrapper">
                <div classNameName="container-fluid">
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
                                                <th className="product_stock">Stock Status</th>
                                                <th className="product_addcart">Add To Cart</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            {
                                                wish.map(item => (
                                                    <WishTableLine 
                                                        item={item}
                                                        delCheck={delCheck}
                                                        setDelCheck={setDelCheck}
                                                    />
                                                ))
                                            }
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default WishTable;
