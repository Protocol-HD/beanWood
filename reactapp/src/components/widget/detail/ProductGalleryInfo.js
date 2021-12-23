import React, { useState, useEffect, useRef } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import ProductDescriptionsection from './productsection/ProductDescriptionsection';
import axios from 'axios';

function ProductGalleryInfo({id}) {

    const [product, setProduct] = useState({})
    const [colorIds, setColorIds] = useState([])
    const [colorId, setColorId] = useState(0)
    const [proMainImg1, setProMainImg1] = useState("")
    const [proMainImg2, setProMainImg2] = useState("")
    const [proMainImg3, setProMainImg3] = useState("")
    let [quantitynumber, setQuantitynumber] =useState(1);
    const size = useRef('')
    let goCart = useNavigate();
    let goWish = useNavigate();

    useEffect(() => {
        // fetch(`http://localhost:3006/products/${id}`)
        // .then(res => {
        //     return res.json()
        // })
        // .then(data => {
        //     setProduct(data)
        //     setProMainImg1(data.productImage[0].imageUrl)
        //     console.log(data.productImage[0].imageUrl)
        //     setProMainImg2(data.productImage[1].imageUrl)
        //     setProMainImg3(data.productImage[2].imageUrl)
        //     setColorIds(data.colorId)
        //     console.log(data.colorId)
        // })

        axios.get(`http://localhost:3006/products/${id}`)
        .then(Response => {
            setProduct(Response.data)
            setColorIds(Response.data.colorId)
            setProMainImg1(Response.data.productImage[0].imageUrl)
            setProMainImg2(Response.data.productImage[1].imageUrl)
            setProMainImg3(Response.data.productImage[2].imageUrl)
        })
    }, [id]);

    const addCart = (e) => {
        // fetch("http://localhost:3005/cartLists", {
        //     method: "POST",
        //     headers: {
        //         "content-Type": "application/json",
        //     },
        //     body: JSON.stringify({
        //         productId: id,
        //         quantity: 1
        //         color : e.target.value,
        //         size : size.current.value
        //     })
        // })
        // .then(res => {
        //     if(res.ok) console.log("success")
        // });

        e.preventDefault();
        const url = "http://localhost:3005/cartLists"

        if(colorId == 0) {
            window.alert("Select color.")
        } else {
            axios.post(url,{
                productId: parseInt(id),
                quantity: quantitynumber,
                color : parseInt(colorId),
                size : size.current.value, 
                itemTotal: quantitynumber * product.price, 
                itemImg: proMainImg1
            }).then(Response=>{
                goCart("/cart")
            })
        }

    }

    const getColor = (e) => {
        setColorId(e.target.value)
    }

    const handleCount = ( count ) => {
        if(count<=0) 
            return alert("You have to choose at least one.")
        setQuantitynumber(count)
    }

    const handlePostWish = () => {

        if(colorId == 0) {
            window.alert("Select color.")

        } else {
            axios.post("http://localhost:3005/wishLists", {
                productId: parseInt(id),
                quantity: quantitynumber,
                color : parseInt(colorId),
                size : size.current.value, 
                itemTotal: quantitynumber * product.price, 
                itemImg: proMainImg1
            })
            .then(Response => {
                goWish("/wish")
            })
        }
    }

    return (     
        <>                
        <div className="product-gallery-info-section section-fluid-270 section-top-gap-100">
            <div className="box-wrapper">
                <div className="product-gallery-info-wrapper">
                    <div className="container-fluid">
                        <div className="row">
                            <div className="col-xxl-8 col-lg-6">
                                
                                <div className="product-gallery product-gallery--style-tab">
                                    <div className="row flex-md-row flex-column-reverse">
                                        <div className="col-md-3">
                                            <ul className="product-thumbnail-image nav">
                                                <li className="nav-item">
                                                    <button className="nav-link active" data-bs-toggle="tab" data-bs-target="#img-1" type="button">
                                                        <span className="thumb">
                                                            <img className="img-fluid" src={`../../assets/images/products/${proMainImg1}`} alt={proMainImg1}/>
                                                        </span>
                                                    </button>
                                                </li>
                                                <li className="nav-item" role="presentation">
                                                    <button className="nav-link" data-bs-toggle="tab" data-bs-target="#img-2" type="button">
                                                        <span className="thumb">
                                                            <img className="img-fluid" src={`../../assets/images/products/${proMainImg2}`} alt={proMainImg2}/>
                                                        </span>
                                                    </button>
                                                </li>

                                                <li className="nav-item" role="presentation">
                                                    <button className="nav-link" data-bs-toggle="tab" data-bs-target="#img-3" type="button">
                                                        <span className="thumb">
                                                            <img className="img-fluid" src={`../../assets/images/products/${proMainImg3}`} alt={proMainImg3}/>
                                                        </span>
                                                    </button>
                                                </li>
                                            </ul>
                                            
                                        </div>
                                        <div className="col-md-9">                   
                                            <div className="product-large-image tab-content">
                                                <div className="tab-pane fade show active" id="img-1" role="tabpanel">
                                                    <div className="image">
                                                        <img className="img-fluid" src={`../../assets/images/products/${proMainImg1}`} alt={proMainImg1}/>
                                                    </div>
                                                </div>
                                                <div className="tab-pane fade" id="img-2" role="tabpanel">
                                                    <div className="image">
                                                        <img className="img-fluid" src={`../../assets/images/products/${proMainImg2}`} alt={proMainImg2}/>
                                                    </div>
                                                </div>
                                                <div className="tab-pane fade" id="img-3" role="tabpanel">
                                                    <div className="image">
                                                        <img className="img-fluid" src={`../../assets/images/products/${proMainImg3}`} alt={proMainImg3}/>
                                                    </div>
                                                </div>
                                            </div>                                            
                                        </div>
                                    </div>
                                </div>
                                
                                
                            </div>

                            <div className="col-xxl-4 col-lg-6">
                                <form onSubmit={addCart}>
                                    <div className="product-content">
                                        <span className="catagory">{product.categoryId == 1 ? "Men" : product.categoryId == 2 ? "Women" : product.categoryId == 3 ? "Kid" : product.categoryId == 4 ? "Others" : ""}</span>
                                        <h2 className="title">{product.productName}</h2>
                                        <span className="author">Design: kakakoli Fashion</span>
                                        <div className="bottom">
                                            <ul className="review-star">
                                                {[...Array(product.star)].map((n, index) => {
                                                    return (
                                                        <div>
                                                            <li className="fill"><span className="material-icons">star</span></li>
                                                        </div>
                                                    )
                                                })}
                                                {/* <li className="fill"><span className="material-icons">star</span></li>
                                                <li className="fill"><span className="material-icons">star</span></li>
                                                <li className="fill"><span className="material-icons">star</span></li>
                                                <li className="fill"><span className="material-icons">star</span></li>
                                                <li className="fill"><span className="material-icons">star_half</span></li> */}
                                            </ul>
                                            <button type="button" onClick={handlePostWish} className="wishlist">Add Wishlist</button>
                                        </div>

                                        <span className="price">${((100 - product.sale) * 0.01) * product.price} 
                                        {
                                            ((100 - product.sale) * 0.01) * product.price === product.price ? '' : <del>${product.price}</del>
                                        } 
                                        </span>

                                        <div className="product-variables">
                                            <div className="product-variable-color">
                                                <h6 className="title">Color</h6>
                                                <ul className="color-select">
                                                    {
                                                        colorIds.map(item=>(
                                                            <li key={item}>
                                                                <label class="checkbox-default" for="color-red">
                                                                    <input type="radio" name="color" id={item} value={item} onChange={getColor} />
                                                                    <span>
                                                                        {
                                                                            item===1 ? "Red" : item===2 ? "Green" : item===3 ? "Blue" : item===4 ? "Black" : ""
                                                                        }
                                                                    </span>
                                                                </label>
                                                            </li>
                                                        ))
                                                    }
                                                
                                                </ul>
                                            </div>
                                            

                                            <ul className="variable-items">
                                                <li className="variable-single-items type-select">
                                                    <select className="nice-select" tabindex="0" ref={size}>
                                                        <option value="S" defaultValue>Size: S</option>
                                                        <option value="M">Size: M</option>
                                                        <option value="L">Size: L</option>
                                                        <option value="XL">Size: XL</option>
                                                        <option value="XXl">Size: XXL</option>
                                                    </select>
                                                </li>

                                                <li className="variable-single-items">
                                                    <div className="num-block skin-2">
                                                        <div className="num-in">
                                                            <span className="minus" onClick={()=>{handleCount(--quantitynumber)}}></span>
                                                            <input type="text" className="in-num" value={quantitynumber} readonly=""/>
                                                            <span className="plus" onClick={()=>{handleCount(++quantitynumber)}}></span>
                                                        </div>
                                                    </div>
                                                </li>

                                                <li className="variable-single-items">
                                                    <button type="submit" className="btn btn-sm btn-default">Add To Cart</button>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </form>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
        <ProductDescriptionsection product={product} />
        
        </>
    );
}

export default ProductGalleryInfo;

