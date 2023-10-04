import React from "react";
import { Navigate, Outlet} from "react-router-dom";
import Nav from "./Nav";
import { isLoggedIn } from "../Authentication/auth";

function AdminDashboard() {
  const ticket = [
    { name: "All Tickets", to: "/admin" },
    { name: "Add Ticket", to: "/admin/addTicket" },
  ];
  const employee = [
    { name: "All Employee", to: "/admin/allEmployee" },
    { name: "Add Employee", to: "/admin/registration" },
  ];
  const profile = [{ name: "Change Password" }, { name: "Logout" }];
  
  const elements = [
    {
      name: "Ticket",
      value: ticket,
    },
    {
      name: "Department",
      value: [],
    },
    {
      name: "Employee",
      value: employee,
    },
    {
      name: "Profile",
      value: profile,
    },
  ];

  if (isLoggedIn()) {
    return (
      <>
        <Nav tag={elements} />
        <div style={{height:'85vh', overflowY:'scroll', marginTop:'10px'}}><Outlet></Outlet></div>
      </>
    );
  } else {
    return <Navigate to={"/"} />;
  }
}

export default AdminDashboard;
