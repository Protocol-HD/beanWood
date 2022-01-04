import React, { useState } from 'react';
import AddProduct from './AddProduct';
import EditProduct from './EditProduct';
import AddProductInfo from './AddProductInfo';
import EditProductList from './EditProductList';

function AdminMenu() {
	const [editId, setEditId] = useState(null);

	return (
		<div className="account-dashboard section-fluid-270 section-top-gap-100">
			<div className="container-fluid">
				<div className="row">
					<div className="col-sm-12 col-md-3 col-lg-3">
						<div className="dashboard_tab_button">
							<ul role="tablist" className="nav flex-column dashboard-list">
								<li><a href="#addProduct" data-bs-toggle="tab" className="nav-link btn btn-sm btn-default-outline active">Add Product</a></li>
								<li><a href="#addProductInfo" data-bs-toggle="tab" className="nav-link btn btn-sm btn-default-outline">Add ProductInfo</a></li>
								<li><a href="#editProduct" data-bs-toggle="tab" className="nav-link btn btn-sm btn-default-outline">Edit Product</a></li>
								<li><a href="#downloads" data-bs-toggle="tab" className="nav-link btn btn-sm btn-default-outline ">Downloads</a></li>
								<li><a href="#address" data-bs-toggle="tab" className="nav-link btn btn-sm btn-default-outline ">Addresses</a></li>
								<li><a href="#account-details" data-bs-toggle="tab" className="nav-link btn btn-sm btn-default-outline ">Account details</a></li>
								<li><a href="login.html" className="nav-link btn btn-sm btn-default-outline">logout</a></li>
							</ul>
						</div>
					</div>
					<div className="col-sm-12 col-md-9 col-lg-9">
						<div className="tab-content dashboard_content">
							<AddProduct />
							<AddProductInfo />
							<EditProductList />
							{/* <EditProduct editId={editId} /> */}
							<div className="tab-pane fade" id="downloads">
								<h4>Downloads</h4>
								<div className="table_page table-responsive">
									<table>
										<thead>
											<tr>
												<th>Product</th>
												<th>Downloads</th>
												<th>Expires</th>
												<th>Download</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>Shopnovilla - Free Real Estate PSD Template</td>
												<td>May 10, 2018</td>
												<td><span className="danger">Expired</span></td>
												<td><a href="#" className="view">Click Here To Download Your File</a></td>
											</tr>
											<tr>
												<td>Organic - ecommerce html template</td>
												<td>Sep 11, 2018</td>
												<td>Never</td>
												<td><a href="#" className="view">Click Here To Download Your File</a></td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
							<div className="tab-pane" id="address">
								<p>The following addresses will be used on the checkout page by default.</p>
								<h5 className="billing-address">Billing address</h5>
								<a href="#" className="view">Edit</a>
								<p><strong>Bobby Jackson</strong></p>
								<address>Address: Your address goes here.</address>
							</div>
							<div className="tab-pane fade" id="account-details">
								<h3>Account details </h3>
								<div className="login">
									<div className="login_form_container">
										<div className="account_login_form">
											<form action="#">
												<p>Already have an account? <a href="#">Log in instead!</a></p>
												<div className="input-radio">
													<span className="custom-radio"><input type="radio" value="1" name="id_gender" /> Mr.</span>
													<span className="custom-radio"><input type="radio" value="1" name="id_gender" /> Mrs.</span>
												</div> <br />
												<div className="default-form-box mb-20">
													<label>First Name</label>
													<input type="text" name="first-name" />
												</div>
												<div className="default-form-box mb-20">
													<label>Last Name</label>
													<input type="text" name="last-name" />
												</div>
												<div className="default-form-box mb-20">
													<label>Email</label>
													<input type="text" name="email-name" />
												</div>
												<div className="default-form-box mb-20">
													<label>Password</label>
													<input type="password" name="user-password" />
												</div>
												<div className="default-form-box mb-20">
													<label>Birthdate</label>
													<input type="date" name="birthday" />
												</div>
												<span className="example">
													(E.g.: 05/31/1970)
												</span>
												<br />
												<label className="checkbox-default" htmlFor="offer">
													<input type="checkbox" id="offer" />
													<span>Receive offers from our partners</span>
												</label>
												<br />
												<label className="checkbox-default checkbox-default-more-text" htmlFor="newsletter">
													<input type="checkbox" id="newsletter" />
													<span>Sign up for our newsletter<br /><em>You may unsubscribe at any moment. For that purpose, please find our contact info in the legal notice.</em></span>
												</label>
												<div className="save_button mt-3">
													<button className="btn btn-sm btn-default-outline" type="submit">Save</button>
												</div>
											</form>
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

export default AdminMenu;