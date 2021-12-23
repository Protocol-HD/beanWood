import React, { useEffect } from 'react';
import Breadcrumb from '../widget/Breadcrumb';
import CartTable from '../ui/cartUi/CartTable';
import Coupon from '../ui/cartUi/Coupon';
import CartTotals from '../ui/cartUi/CartTotals';
import { useState } from 'react/cjs/react.development';

function Cart({setHeaderClass}) {
    const [check, setCheck] = useState(false)

    useEffect(() =>{
        setHeaderClass(false)
    },[setHeaderClass])

    return (
        <>
            <Breadcrumb />
            <div className="cart-section section-fluid-270 section-top-gap-100">
                <CartTable 
                    check = { check }
                    setCheck = { setCheck }                
                />
                <div className="coupon_area">
                    <div className="container-fluid">
                        <div className="row">
                            <Coupon />
                            <CartTotals 
                                check = { check }
                            />
                        </div>
                    </div>
                </div>
            </div>
        </>
    );
}

export default Cart;