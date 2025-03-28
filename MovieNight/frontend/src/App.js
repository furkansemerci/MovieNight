import "./App.css";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Feed from "./pages/Feed";
import MovieDetails from "./pages/MovieDetails";

function App() {
  return (
    <BrowserRouter>
      <Routes>
          <Route path="/" element={<Feed />}/>
          <Route path="/details/:id" element={<MovieDetails/>} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;