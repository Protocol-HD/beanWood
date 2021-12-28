import React, { useEffect, useState } from 'react';
import SidebarWidgetTag from '../../ui/shopUi/SidebarWidgetTag';
import SideBarSingleitem from './SideBarSingleitem';
import SideBarSingleItemCategory from './SideBarSingleItemCategory';
import SideBarSingleItemColor from './SideBarSingleItemColor';
import SideBarSingleItemSize from './SideBarSingleItemSize';

function Sidebar() {

	const [checkLists, setCheckLists] = useState([])

	useEffect(() => {
		console.log(checkLists)
	}, [checkLists])

	return (
		<div className="siderbar-section">
			<SideBarSingleItemCategory />
			<SideBarSingleItemColor />
			<SideBarSingleItemSize />
		</div>
	);
}

export default Sidebar;