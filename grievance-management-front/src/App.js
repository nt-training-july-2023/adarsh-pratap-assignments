import React from 'react';
import Login from './components/Login';
import LoginPage from './components/LoginPage';
import { Route, Routes } from 'react-router-dom';



function App() {
  return (
    <div className="">
      
      <Routes>
        

        <Route path='/' element={<LoginPage/>}/>
        <Route path='/welcome' element={<Login/>}/>
          
       
      </Routes>
      
    </div>
  );
}

export default App;
