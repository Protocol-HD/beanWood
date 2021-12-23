import React from 'react';
import { Link } from 'react-router-dom';

function ProductDescriptionsection({product}) {
    return ( 

        <div class="product-description-section  section-fluid-270 section-top-gap-100">
            <div class="box-wrapper">
                <div class="product-description-wrapper">
                    <div class="container-fluid">
                        <div class="row justify-content-center">
                            <div class="col-xl-8 col-lg-10">
                                <div class="product-description-content">
                                    <h6 class="title">Description</h6>
                                    <p>{product.description}</p>
    
                                    <p>the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of
                                        type and scrambled it to make a type specimen book</p>
    
                                    <ul class="items-info-list">
                                        <li>There are many variations of passages</li>
                                        <li>If you are going to use a passage of Lorem Ipsum.</li>
                                        <li>The generated Lorem Ipsum is therefore</li>
                                        <li>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</li>
                                        <li>At vero eos et accusamus et iusto odio dignissimos</li>
                                    </ul>
    
                                    <p>the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of
                                        type and scrambled it to make a type specimen book</p>
    
                                    <div class="social-links">
                                        <span class="text">Share:</span>
                                        <div class="items">
                                            <Link to="https://example.com/"><img class="icon-svg" src="assets/images/icons/icon-facebook-f-dark.svg" alt=""/></Link>
                                            <Link to="https://example.com/"><img class="icon-svg" src="assets/images/icons/icon-twitter-dark.svg" alt=""/></Link>
                                            <Link to="https://example.com/"><img class="icon-svg" src="assets/images/icons/icon-pinterest-p-dark.svg" alt=""/></Link>
                                            <Link to="https://example.com/"><img class="icon-svg" src="assets/images/icons/icon-dribbble-dark.svg" alt=""/></Link>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default ProductDescriptionsection;