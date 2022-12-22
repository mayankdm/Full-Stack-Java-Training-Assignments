import './App.css';
//import Employees from './component/employees'
import productLisrt from './products/products'
import Product from './products/product'



function App() {
  return (
    <div className="App">
      <Product data={productLisrt}/>
    </div>
  );
}

export default App;
