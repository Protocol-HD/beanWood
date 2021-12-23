import React, { useState, useEffect } from 'react';
import { useParams, useLocation, useSearchParams } from 'react-router-dom';
import Breadcrumb from '../ui/Breadcrumb';
import ProductGalleryInfo from '../widget/detail/ProductGalleryInfo';
import ProductSection from '../widget/detail/productsection/ProductSection';
import ExclusiveCollection from '../widget/homeWidget/ExclusiveCollection';

function Detail ({setHeaderClass}) {

    const dir = useLocation()
    const [checkDir, setCheckDir] = useState(false)
    const { id } = useParams();
    const [product, setProduct] = useState({})

    useEffect(() => {
        if(dir) setCheckDir(true)
        setHeaderClass(false)

        fetch(`http://localhost:3006/products/${id}`)
        .then(res => {
            return res.json()
        })
        .then(data => {
            setProduct(data)
        })
    }, [id, setHeaderClass]);

    return ( 
        <>
            <Breadcrumb
                checkDir = {checkDir}
            />
            <ProductGalleryInfo id={id} />
            <ExclusiveCollection checkDir = {checkDir} />
            {/* <ProductSection ctgy={product.categoryId} /> */}
        </>
    );
}

export default Detail ;


