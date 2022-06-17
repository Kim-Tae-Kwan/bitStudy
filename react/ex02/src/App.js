import { Route, BrowserRouter as Router, Routes, Link } from 'react-router-dom';
import './App.css';
import Home from './page/Home';
import React from "react";
import Emp from './page/Emp';
import Dept from './page/Dept';
import Login from './page/Login';

function App() {
  return (
    <Router>
        <nav>
          <Link to="/">home</Link>
          <Link to="/emp">emp</Link>
          <Link to="/dept">dept</Link>
          <Link to="/login">login</Link>
        </nav>
        <Routes>
          <Route path="/" element={<Home/>}/>
          <Route path="/emp" element={<Emp/>}/>
          <Route path="/dept" element={<Dept/>}/>
          <Route path="/login" element={<Login/>}/>
        </Routes>
    </Router>
  );
}

export default App;
