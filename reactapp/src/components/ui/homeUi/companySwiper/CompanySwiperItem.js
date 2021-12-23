import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';

function CompanySwiperItem({brand}) {

    const [ imgUrl, setImgUrl] = useState("")

    useEffect(()=>{
        setImgUrl(`./assets/images/brand/${brand.image}`)
    })

    return ( 
        
        <Link to="/shop">
            <div className="image" style={{ "width" : "60%", "margin" : "auto" }}>
                <img className="img-fluid" src={imgUrl} alt={brand.name} />
            </div>
        </Link>
                
    );
}

export default CompanySwiperItem;