import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';
import CategoryTab from '../../ui/homeUi/productList/CategoryTab';
import TabContent from '../../ui/homeUi/productList/TabContent';

function ProductTap() {
    const [list, setList] =  useState([])
    const [categories, setCategories] = useState([])

    const url = "http://localhost:3006/products"
    const categoryUrl = "http://localhost:3005/categories"

    useEffect(() => {
        
        axios.get(url)
        .then(Response => {
            setList(Response.data)
        })

        axios.get(categoryUrl)
        .then(Response => {
            setCategories(Response.data)
        })

    }, []);

    const handleTab = (e) => {
        
        const url = `http://localhost:3006/products?categoryId=${e.target.value}`

        axios.get(url)
        .then(Response => {
            setList(Response.data)
        })
    }

    const handleTabAll = () => {
        const url = `http://localhost:3006/products`

        axios.get(url)
        .then(Response => {
            setList(Response.data)
        })
    }

    return (
        <div className="product-tab-items-section section-fluid-270 section-top-gap-100">
            <div className="box-wrapper">
                <div className="section-wrapper">
                    <div className="container-fluid">
                        <div className="row justify-content-between align-items-center flex-warp">
                            <div className="col-xxl-4 col-lg-5 col-md-6 col-sm-8 col-auto me-5">
                                <div className="section-content section-content-gap-60">
                                    <h2 className="section-title">Products</h2>
                                    <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div className="product-tab-item-wrapper">
                    <div className="container-fluid">
                        <div className="row">
                            <div className="col-12">
                                
                                <ul className="product-tab nav" role="tablist">
                                <li className="nav-item" role="presentation">
                                    <button className="nav-link active" data-bs-toggle="tab" data-bs-target="all" type="button" onClick={handleTabAll}>All<img src="assets/images/icons/product-tab-icon-1.svg" alt="" /></button>
                                </li>
                                    {
                                        categories.map(item=>(
                                            <CategoryTab 
                                                key={item.id}
                                                name={item.name}
                                                icon={item.icon}
                                                id={item.id}
                                                handleTab={handleTab}
                                            />
                                        ))
                                    
                                    }
                                </ul>
                                
                                <TabContent list={list} />


                                <div className="d-flex justify-content-center">
                                    <Link to="/shop" className="btn btn-md btn-default btn-section-bottom">View All Product</Link>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default ProductTap;