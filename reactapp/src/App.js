import React, { useState } from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Footer from './components/layout/Footer';
import Header from "./components/layout/Header";
import Cart from './components/page/Cart';
import Home from "./components/page/Home";
import Wish from './components/page/Wish';
import Shop from './components/page/Shop';
import TopScroll from './components/widget/TopScroll';
import Detail from './components/page/Detail';
import './App.css'
import './css/style.css';
import Join from './components/page/Join';
import Login from './components/page/Login';
import AddProductInfo from './components/page/AddProductInfo';
import EditProduct from './components/page/EditProduct';
import AdminMenu from './components/page/AdminMenu';

function App() {
	const [headerClass, setHeaderClass] = useState(true)

	return (
		<BrowserRouter>
			<div className="App">
				<Header
					headerClass={headerClass}
				/>
				<TopScroll />
				<Routes>
					<Route path="/" element={<Home setHeaderClass={setHeaderClass} />} />
					<Route path="/signup" element={<Join />} />
					<Route path="/login" element={<Login />} />
					<Route path="/shop" element={<Shop setHeaderClass={setHeaderClass} />} />
					<Route path="/cart" element={<Cart setHeaderClass={setHeaderClass} />} />
					<Route path="/wish" element={<Wish setHeaderClass={setHeaderClass} />} />
					<Route path="/detail" element={<Detail setHeaderClass={setHeaderClass} />} />
					<Route path="/shop/detail/:id" element={<Detail setHeaderClass={setHeaderClass} />} />
					<Route path="/addproductinfo/" element={<AddProductInfo />} />
					<Route path="/editproduct/:id" element={<EditProduct />} />
					<Route path="/admin" element={<AdminMenu />} />
				</Routes>
				<Footer />
			</div>

		</BrowserRouter>
	);
}

export default App;
