import React, { useState } from "react";
import UserRegistration from "./Pages/UserRegistration";
import AddTicket from "./Pages/AddTicket";
import { Navigate, Route, Routes } from "react-router-dom";
import LoginPage from "./Pages/LoginPage";

import AllTickets from "./Pages/AllTickets";
import AllDepartment from "./Pages/AllDepartment";
import Admin from "./Pages/Admin";
import AllEmployees from "./Pages/AllEmployees";
import User from "./Pages/User";
import { getCurrentUserDetails } from "./Authentication/auth";
import ResetPassword from "./Pages/ResetPassword";

function App() {
  const [user, setUser] = useState();
  const userDetails = getCurrentUserDetails();

  return (
    <div className="">
      <Routes>
        <Route path="*" element={<Navigate to={"/"} />} />
        <Route path="/" element={<LoginPage setUser={setUser} />} />
        {userDetails && userDetails.isFirstLogin && (
          <Route path="/reset" element={<ResetPassword set={() => {}} />} />
        )}

        {userDetails &&
          userDetails.role === "ROLE_ADMIN" &&
          !userDetails.isFirstLogin && (
            <Route path="/admin" element={<Admin user={user} />}>
              <Route index element={<AllTickets />} />
              <Route path="/admin/addTicket" element={<AddTicket />} />
              <Route
                path="/admin/registration"
                element={<UserRegistration />}
              />
              <Route path="/admin/allDepartment" element={<AllDepartment />} />
              <Route path="/admin/allEmployee" element={<AllEmployees />} />
            </Route>
          )}
        {userDetails &&
          userDetails.role === "ROLE_USER" &&
          !userDetails.isFirstLogin && (
            <Route path="/user" element={<User user={user} />}>
              <Route index element={<AllTickets />} />
              <Route path="/user/addTicket" element={<AddTicket />} />
            </Route>
          )}
      </Routes>
    </div>
  );
}

export default App;
