import React, { useEffect, useState } from 'react';
import ShippingItem from '../../ui/homeUi/shippingItem/ShippingItem';
import axios from 'axios';

function Shipping() {

    const [shippingItem, setShippingItem] = useState([]);

    useEffect(() => {

        axios.get("http://localhost:3006/shippingItems")
        .then(Response => {
            setShippingItem(Response.data);
        })
    }, []);
        
    return ( 
        <div className="shipping-section section-fluid-270 section-top-gap-100">
            <div className="box-wrapper">

                <div className="shipping-wrapper">
                    <div className="container-fluid">
                        <div className="row">

                            <div className="row justify-content-between mb-n40">
                                {
                                    shippingItem.map(item => (
                                        <ShippingItem key={item.id} item={item} />
                                    ))
                                }
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    );
}

export default Shipping;