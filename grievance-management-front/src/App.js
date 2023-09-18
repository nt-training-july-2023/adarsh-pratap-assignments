import React, { useState } from 'react';
import UserRegistration from './Pages/UserRegistration';
import AddTicket from './Pages/AddTicket';
import { Route, Routes, useNavigate } from 'react-router-dom';
import Department from './components/Department';
import LoginPage from './Pages/LoginPage';
import AddDepartment from './Pages/AddDepartment';
import ResetPassword from './Pages/ResetPassword';
import Navbar from './components/Navbar';
import AllTickets from './Pages/AllTickets';
import AllDepartment from './Pages/AllDepartment';
import AdminDashboard from './Pages/AdminDashboard';



function App() {

  const [user , setUser] = useState();
  const navigate = useNavigate();
  return (
    <div className="">
      
      

      {user && <Navbar/>}
      
      
      <Routes>
        
        <Route path='/navbar' element={<Navbar/>}/>
        <Route path='/' element={<LoginPage setUser={setUser}/>}/>
      
        {user && user.role === "ROLE_ADMIN" ? (<Route path='depatment' element={<AddDepartment />}/>) : (null) }
        <Route path='/registration' element={<UserRegistration/>}/>
        <Route path='/addticket' element={<AddTicket/>}/>
        <Route path='/allticket' element={<AllTickets/>}/>
        <Route path='/admin' element={<AdminDashboard/>}/>
        <Route path='/reset' element={<ResetPassword/>}/>
        <Route path='/alldep' element={<AllDepartment/>}/>
      
      </Routes>
      
    </div>
  );
}

export default App;
