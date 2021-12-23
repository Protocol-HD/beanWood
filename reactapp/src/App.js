import React , {useState} from 'react';
import {BrowserRouter, Routes, Route} from 'react-router-dom';
import Footer from './components/layout/Footer';
import Header from "./components/layout/Header";
import Cart from './components/page/Cart';
import Home from "./components/page/Home";
import Wish from './components/page/Wish';
import Shop from './components/page/Shop';
import TopScroll from './components/widget/TopScroll';
import Detail from './components/page/Detail';

import './css/style.css';

// import './css/style.min.css';
// import './css/vendor/bootstrap.min.css'
// import './css/vendor/jquery-ui.min.css'
// import './css/vendor/material-icons.css'
// import './css/vendor/vendor.min.css'
// import './css/plugins/swiper-bundle.min.css'
// import './css/plugins/animate.css'
// import './css/plugins/ion.rangeSlider.min.css'
// import './css/plugins/nice-select.css'
// import './css/plugins/plugins.min.css'
// import './css/plugins/venobox.min.css'

function App() {
  const [headerClass, setHeaderClass] = useState(true)
  
  return (
    <BrowserRouter>
      <div className="App">
      <Header 
        headerClass={headerClass}
      />
      <TopScroll/>
      <Routes>
        <Route path="/" element={<Home setHeaderClass={setHeaderClass}/>} />
        <Route path="/shop" element={<Shop setHeaderClass={setHeaderClass}/>} />
        <Route path="/cart" element={<Cart setHeaderClass={setHeaderClass}/>} />
        <Route path="/wish" element={<Wish setHeaderClass={setHeaderClass}/>} />
        <Route path="/detail" element={<Detail setHeaderClass={setHeaderClass}/>} />
        <Route path="/shop/detail/:id" element={<Detail setHeaderClass={setHeaderClass}/>} />
      </Routes>
      <Footer />
      </div>
      
    </BrowserRouter>
  );
}

export default App;
