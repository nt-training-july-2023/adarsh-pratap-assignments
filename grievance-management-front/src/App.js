import React from 'react';
import UserRegistration from './components/registration/UserRegistration';
import AddTicket from './components/add-ticket/AddTicket';
import { Route, Routes } from 'react-router-dom';
import LoginPage from './components/login-page/LoginPage';
import Modal from './components/utility/Model';

function App() {
  return (
    <div className="">
      
      {/* <UserRegistration/> */}
     
      {/* <AddTicket/> */}
      <Routes>
        

        <Route path='/' element={<LoginPage/>}/>
        <Route path='/registration' element={<UserRegistration/>}/>
        <Route path='/addticket' element={<AddTicket/>}/>
        <Route path='depatment' element={<Modal/>}/>
       
      </Routes>
      
    </div>
  );
}

export default App;
