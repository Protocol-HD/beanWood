import React, { useState } from 'react';
import AddProduct from './AddProduct';
import AddProductInfo from './AddProductInfo';
import EditProduct from './EditProduct';
import EditProductList from './EditProductList';

function AdminMenu() {
	const [editId, setEditId] = useState();
	const [showMenu, setShowMenu] = useState(0);

	return (
		<div className="account-dashboard section-fluid-270 section-top-gap-100">
			<div className="container-fluid">
				<div className="row">
					<div className="col-sm-12 col-md-3 col-lg-3">
						<div className="dashboard_tab_button">
							<ul role="tablist" className="nav flex-column dashboard-list">
								<li>
									<button
										onClick={() => setShowMenu(1)}
										className={`nav-link btn btn-sm btn-default-outline ${showMenu === 1 ? "active" : ""}`}
									>
										Add Product
									</button>
								</li>
								<li>
									<button
										onClick={() => setShowMenu(2)}
										className={`nav-link btn btn-sm btn-default-outline ${showMenu === 2 ? "active" : ""}`}
									>
										Edit Product
									</button>
								</li>
								<li><a href="#addProductInfo" data-bs-toggle="tab" className="nav-link btn btn-sm btn-default-outline">Add ProductInfo</a></li>
								<li><a href="#test" data-bs-toggle="tab" className="nav-link btn btn-sm btn-default-outline ">test</a></li>
							</ul>
						</div>
					</div>
					<div className="col-sm-12 col-md-9 col-lg-9">
						<div className="tab-content dashboard_content">
							<AddProduct showMenu={showMenu} />
							<EditProductList showMenu={showMenu} setShowMenu={setShowMenu} setEditId={setEditId} />
							<EditProduct showMenu={showMenu} editId={editId} />
							<AddProductInfo />
						</div>
					</div>
				</div>
			</div>
		</div>
	);
}

export default AdminMenu;
