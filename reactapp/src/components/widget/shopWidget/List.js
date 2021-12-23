import React, { useEffect, useState } from 'react';
import Sidebar from './Sidebar';
import ProductSingleItemStyle1 from '../../ui/homeUi/productList/ProductSingleItemStyle1';
import ListPagenation from '../../ui/shopUi/ListPagination'
import ShopInfo from '../../ui/shopUi/ShopInfo';
import axios from 'axios';

function List() {

    const [productList, setProductList] = useState([]);
    const [mount, setMount] = useState(6);

    useEffect(() => {
        fetch("http://localhost:3005/productList")
        .then(res => {
            return res.json();
        })
        .then(data => {
            setProductList(data.filter(item=> item.productIsShow === true));
        })
    }, []);

    useEffect(() => {
        const url = "http://localhost:3005/productList"
        axios.get(url)
        .then(Response => {
            setProductList(Response.data.filter(item=> item.productIsShow === true));
        })
    }, [])

    const list = productList.map(item => (
        <div className="col-md-6 col-12 mb-25">
            <ProductSingleItemStyle1
                key={item.id}
                id={item.productId}
                path="shop"
            />
        </div>
    )).slice(0, mount)


    return ( 
        <div className="shop-list-section section-fluid-270 section-top-gap-100">
            <div className="box-wrapper">
                <div className="shop-list-wrapper">
                    <div className="container-fluid">
                        <div className="row flex-column-reverse flex-lg-row">
                            <div className="col-xl-3 col-lg-3">
                                <Sidebar />
                            </div>
                            <div className="col-xl-8 offset-xl-1 col-lg-9">
                                <ShopInfo mount={mount} productList={productList} />
                                
                                <div className="product-shop-list-items">
                                    <div className="row mb-n25">
                                        {list}
                                    </div>
                                </div>

                                <ListPagenation />
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default List;