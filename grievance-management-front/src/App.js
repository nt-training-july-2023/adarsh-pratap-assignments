import React, { useState } from "react";
import UserRegistration from "./Pages/UserRegistration";
import AddTicket from "./Pages/AddTicket";
import { Route, Routes, useNavigate } from "react-router-dom";
import Department from "./components/Department";
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
        {user && user.role === "ROLE_ADMIN" ? (
          <Route path="/admin" element={<AdminDashboard />} />
        ) : (
          navigate("/")
        )}
        <Route path="/reset" element={<ResetPassword />} />
        <Route path="/alldep" element={<AllDepartment />} />
        <Route path="/update" element={<UpdateTicket />} />
        <Route path="/demo" element={<Admin />} />
      </Routes>
    </div>
  );
}

export default App;
