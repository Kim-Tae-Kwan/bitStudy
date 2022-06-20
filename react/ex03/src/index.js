import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import reportWebVitals from './reportWebVitals';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Home from './pages/Home';
import Intro from './pages/Intro';
import DeptList from './pages/DeptList';
import DeptAdd from './pages/DeptAdd';
import Login from './pages/Login';
import Mnav from './modules/Mnav';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <BrowserRouter>
  <Mnav/>
  <Routes>
    <Route path="/" element={<Home />}/>
    <Route path="/intro" element={<Intro />}/>
    <Route path="/dept" element={<DeptList />}/>
    <Route path="/add" element={<DeptAdd />}/>
    <Route path="/login" element={<Login />}/>
  </Routes>
  </BrowserRouter>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
