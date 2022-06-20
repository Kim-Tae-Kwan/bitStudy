import { useReducer } from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import './App.css';
import Menu from './modules/Menu';
import UserContext, {reducer, initialState} from './modules/Store';
import DeptAdd from './page/DeptAdd';
import DeptList from './page/DeptList';
import DeptOne from './page/DeptOne';
import Home from './page/Home';
import Intro from './page/Intro';
import JoinPage from './page/JoinPage';
import LoginPage from './page/LoginPage';

function App() {
  const [state, dispatch] = useReducer(reducer, initialState);
  return (
    <UserContext.Provider value={{state, dispatch}}>
    <BrowserRouter>
      <Menu/>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/intro" element={<Intro />} />
        <Route path="/dept" element={<DeptList />} />
        <Route path="/dept/:deptno" element={<DeptOne />} />
        <Route path="/dept/add" element={<DeptAdd />} />
        <Route path="/login" element={<LoginPage />} />
        <Route path="/join" element={<JoinPage />} />
      </Routes>
    </BrowserRouter>
    </UserContext.Provider>
  );
}

export default App;
