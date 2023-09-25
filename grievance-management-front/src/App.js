import React, { useState } from "react";
import UserRegistration from "./Pages/UserRegistration";
import AddTicket from "./Pages/AddTicket";
import { Route, Routes, useNavigate } from "react-router-dom";
import LoginPage from "./Pages/LoginPage";
import AddDepartment from "./Pages/AddDepartment";
import ResetPassword from "./Pages/ResetPassword";
import Navbar from "./components/Navbar";
import AllTickets from "./Pages/AllTickets";
import AllDepartment from "./Pages/AllDepartment";
import AdminDashboard from "./Pages/AdminDashboard";
import UpdateTicket from "./Pages/UpdateTicket";
import Admin from "./Pages/Admin";

function App() {
  const [user, setUser] = useState();
  const navigate = useNavigate();
  return (
    <div className="">
      <Routes>
        <Route path="/navbar" element={<Navbar />} />
        <Route path="/" element={<LoginPage setUser={setUser} />} />

        {user && user.role === "ROLE_ADMIN" ? (
          <Route path="depatment" element={<AddDepartment />} />
        ) : null}
        <Route path="/registration" element={<UserRegistration />} />
        <Route path="/addticket" element={<AddTicket />} />
        <Route path="/allticket" element={<AllTickets />} />
        
        <Route path="/admin" element={<Admin user={user}/>} >
          <Route index element={<AllTickets/>}/>
          <Route path="/admin/addTicket" element={<AddTicket/>}/>
          <Route path="/admin/registration" element={<UserRegistration />} />
          <Route path="/admin/allDepartment" element={<AllDepartment />} />
        </Route>
        
        <Route path="/reset" element={<ResetPassword />} />
        
        
        
      </Routes>
    </div>
  );
}

export default App;
