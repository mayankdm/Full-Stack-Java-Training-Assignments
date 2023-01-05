import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Navbar from './components/navbar';
import Home from './components/home';
import About from './components/about';
import SingleCocktail from './components/single-cocktail';
import Posts from './components/posts';
import AddPost from './components/add-post';
import Error from './components/error';
import './App.css';

function App() {
  return (
    <Router>
      <Navbar />
      <Routes>
        <Route path='/' element={<Home />} />
        <Route path='about' element={<About />} />
        <Route path='cocktail/:id' element={<SingleCocktail />} />
        <Route path="/posts" element={<Posts />} />
        <Route path="/add-posts" element={<AddPost />} />
        <Route path='*' element={<Error />} />
      </Routes>
    </Router>
  );
}

export default App;
