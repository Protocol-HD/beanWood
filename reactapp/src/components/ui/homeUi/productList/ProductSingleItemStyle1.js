import React, {useState, useEffect} from 'react';
import { Link } from 'react-router-dom';
import ToolTipTagItems from './ToolTipTagItems';
import styles from './ProductSingleItemStyle1.module.css';
import axios from 'axios';

function ProductSingleItemStyle1({id, path, checkDir}) {
    const [productItem, setProductItem] = useState({
        categoryId: '', 
        productName : '', 
        price : '', 
        sale : '', 
        star : '', 
        description : ''
    })
    const [addPath, setAddPath] = useState("")

    const [imgUrl, setImgUrl] = useState("")

    const handlePost = () => {
        
        axios.post("http://localhost:3005/cartLists", {
            productId: id, 
            quantity: 1, 
            price: productItem.price,
            color : 1,
            size : "S",
            itemTotal: productItem.price * 1, 
            itemImg: imgUrl
        })
        .then(Response => {
            if(Response.ok) alert("Success!")
        })
    }

    const handlePostWish = () => {
        axios.post("http://localhost:3005/wishLists", {
            productId: id, 
            quantity: 1, 
            price: productItem.price,
            color : 1,
            size : "S",
            itemTotal: productItem.price,
            itemImg: imgUrl
        })
        .then(Response => {
            if(Response.ok) alert("Success!")
        })
    }

    useEffect(() => {
        
        axios.get(`http://localhost:3006/products/${id}`)
        .then(Response => {
            setProductItem(Response.data)
            setImgUrl(Response.data.productImage[0].imageUrl)
        })

        if(checkDir) {
            setAddPath("../.")
        }
    }, [id, checkDir])

    return (
        <div className={path == "home" ? "col-sm-6 col-md-4 col-lg-3 mb-4" : path == "shop" ? "col-12" : path == "exclusive" ? "mx-3" : ""}>
            <div className="product-single-item-style-1 swiper-slide">
            <Link to={`/shop/detail/${id}`} className="image img-responsive">
                <img className="img-fluid" src={`${addPath}./assets/images/products/${imgUrl}`} alt="product" />
                <ToolTipTagItems sale={productItem.sale} />
            </Link>
            <div className="content">
                <div className="top">
                    <span className="catagory">{productItem.categoryId == 1 ? "Men" : productItem.categoryId == 2 ? "Women" : productItem.categoryId == 3 ? "Kid" : productItem.categoryId == 4 ? "Others" : ""}</span>
                    <h4 className="title"><Link to={`/shop/detail/${id}`}>{productItem.productName}</Link></h4>
                    <span className="price">
                        ${((100 - productItem.sale) * 0.01) * productItem.price}
                        {
                            ((100 - productItem.sale) * 0.01) * productItem.price === productItem.price ? '' : <del>${productItem.price}</del>
                        }  
                    </span>
                </div>
                <div className="bottom">
                    <ul className="review-star">
                        {[...Array(productItem.star)].map((n, index) => {
                            return (
                                <div>
                                    <li className="fill"><span className="material-icons">star</span></li>
                                </div>
                            )
                        })}
                    
                    </ul>
                    <div className="product-event-items">
                        <button className={styles.button} onClick={handlePost}>
                            <Link to="/cart" className="btn cart-btn">Add to cart</Link>
                        </button>
                        <button onClick={handlePostWish}>
                            <Link to="/wish" className="btn wishlist-btn"><span className="material-icons">favorite_border</span></Link>
                        </button>
                    </div>
                </div>
            </div>
            </div>
        </div>
    );
}

export default ProductSingleItemStyle1;