import React, { useEffect, useState } from 'react';
import BannerCardItem from '../../ui/homeUi/bannerCard/BannerCardItem';
import axios from 'axios';

function BannerCard() {

    const [cardItem, setCardItem] = useState([]);

    useEffect(() => {
        // fetch("http://localhost:3006/bannerCard")
        // .then(res => {
        //     return res.json();
        // })
        // .then(data => {
        //     setCardItem(data);
        // })

        axios.get("http://localhost:3006/bannerCard")
        .then(Response => {
            setCardItem(Response.data);
        })
    }, []);

    return ( 
        <div className="banner-card-section section-fluid-270 section-top-gap-100">
            <div className="box-wrapper">
                <div className="banner-card-wrapper">
                    <div className="container-fluid">
                        <div className="row mb-n20">
                            {
                                cardItem.map(item => (
                                    <BannerCardItem key={item.id} item={item} />
                                ))
                            }
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default BannerCard;