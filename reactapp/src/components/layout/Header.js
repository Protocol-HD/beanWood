import React, {useState, useEffect} from 'react';
import HeaderCartRight from '../ui/header/HeaderCartRight';
import HeaderToggleMenuRight from '../ui/header/HeaderToggleMenuRight';
import HeaderTop from '../ui/header/HeaderTop';
import HeaderWishListRight from '../ui/header/HeaderWishListRight';
import MobileHeader from '../ui/header/MobileHeader';
import { useLocation } from 'react-router';

function Header({headerClass}) {
    const isTrue = headerClass
    const dir = useLocation()
    const [checkDir, setCheckDir] = useState(false)
    
    useEffect(() => {
        if(dir) setCheckDir(true)
    }, [dir]);

    return ( 
        <>
            <HeaderTop
                headerClass={isTrue}
                checkDir = {checkDir}
            />
            <MobileHeader />
            <HeaderToggleMenuRight />
            <HeaderWishListRight />
            <HeaderCartRight/>
        </>
    );
}

export default Header;