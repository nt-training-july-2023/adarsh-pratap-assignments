import React from 'react';
import UserRegistration from './components/registration/UserRegistration';
import AddTicket from './components/add-ticket/AddTicket';
import { Route, Routes } from 'react-router-dom';
import LoginPage from './components/login-page/LoginPage';
import Modal from './components/utility/Model';
import Navbar from './components/navbar/Navbar';
import AdminProfile from './components/admin-profile/AdminProfile';
import Department from './components/Department';

function App() {
  return (
    <div className="">
      
      {/* <UserRegistration/> */}

      <Navbar/>
      
      {/* <AddTicket/> */}
      <Routes>
        

        <Route path='/' element={<LoginPage/>}/>
        <Route path='/registration' element={<UserRegistration/>}/>
        <Route path='/addticket' element={<AddTicket/>}/>
        <Route path='depatment' element={<Modal/>}/>
        <Route path='/profile' element={<AdminProfile/>}/>
        <Route path='/dep' element={<Department/>}/>
       
      </Routes>
      
    </div>
  );
}

export default App;
