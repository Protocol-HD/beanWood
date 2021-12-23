import React, { useEffect, useState } from 'react';
import SidebarWidgetTag from '../../ui/shopUi/SidebarWidgetTag';
import SideBarSingleitem from './SideBarSingleitem';

function Sidebar() {

    const [checkLists, setCheckLists] = useState([])

    useEffect(()=>{
        console.log(checkLists)
    },[checkLists])

    return ( 
        <div className="siderbar-section">
            <SideBarSingleitem 
                title = "categories"
                setCheckLists = {setCheckLists}
                checkLists = {checkLists}
                
            />
            <SideBarSingleitem 
                title = "colors"
                setCheckLists = {setCheckLists}
                checkLists = {checkLists}
            />

            <SideBarSingleitem 
                title = "sizes"
                setCheckLists = {setCheckLists}
                checkLists = {checkLists}
            />


            <SidebarWidgetTag />
        </div>
    );
}

export default Sidebar;