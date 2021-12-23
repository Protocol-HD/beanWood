import React from 'react';

function ShippingItem({item}) {
    return ( 
        <div className="col-xl-4 col-md-6 col-12 mb-40">
            <div className="shipping-single-item--style-1">
                <div className="icon">
                    <img className="img-fluid" src={item.url} width="46" height="33" loading="lazy" alt="shipping-icon-1" />
                </div>
                <div className="content">
                    <h4 className="title">{item.title}</h4>
                    <p>{item.text}</p>
                </div>
            </div>
        </div>
     );
}

export default ShippingItem;