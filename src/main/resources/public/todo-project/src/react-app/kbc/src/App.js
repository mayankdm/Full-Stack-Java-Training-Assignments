import './App.css';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Game from './game/game';
import Quiz from './utils/data';
import Welcome from './welcome/welcome';

function App() {
  const data = { greeting: "Welcome User!", link: "Lets Begin!" };
  const over = { greeting: "Game Over!", link: "Restart again!" };
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Welcome data={data} />} />
        <Route path="/welcome" element={<Welcome data={over} />} />
        <Route path='/game' element={<Game quiz={Quiz} />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
