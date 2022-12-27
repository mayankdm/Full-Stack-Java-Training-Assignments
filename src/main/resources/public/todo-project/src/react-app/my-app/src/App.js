import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import { useState } from 'react';
import Home from './home/home';
import About from './about/about';
import Products from './products/products';
import Error from './error/error';
import SharedLayout from './utils/shared-layout';
import Product from './product/product';
import Dashboard from './dashboard/dashboard';
import Login from './login/login';
//import MyAppNavbar from './navbar/navbar';
import ProtectedRoute from "./utils/protected-route";
import SharedProductLayout from './utils/shared-product-layout';

function App() {
  const [user, setUser] = useState(null);
  return (
    <BrowserRouter>
      <Routes>
        <Route path='/' element={<SharedLayout />}>
          <Route path="/" element={<Home />} />
          <Route path='about' element={<About />} />

          <Route path='products' element={<SharedProductLayout />}>
            <Route index element={<Products />} />
            <Route path=':productId' element={<Product />} />
          </Route>

          <Route path='login' element={<Login setUser={setUser}></Login>} />
          <Route
            path='dashboard'
            element={
              <ProtectedRoute user={user}>
                <Dashboard user={user} />
              </ProtectedRoute>
            }
          />
          <Route path='*' element={<Error />} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
