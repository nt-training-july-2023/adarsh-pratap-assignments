import React, { useEffect, useState } from "react";
import { Navigate, Outlet, useNavigate } from "react-router-dom";
import Nav from "./Nav";
import { isLoggedIn } from "../Authentication/auth";

function AdminDashboard() {
  const ticket = [
    { name: "All Tickets", to: "/admin" },
    { name: "Add Ticket", to: "/admin/addTicket" },
  ];
  const department = [
    { name: "All Department", to: "/admin/allDepartment" },
    { name: "Create Department" },
  ];
  const employee = [
    { name: "All Employee", to: "/admin/allEmployee" },
    { name: "Add Employee", to: "/admin/registration" },
  ];
  const profile = [{ name: "Change Password" }, { name: "Logout" }];
  const navigate = useNavigate();
  const elements = [
    {
      name: "Ticket",
      value: ticket,
    },
    {
      name: "Department",
      value: department,
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
        <Outlet></Outlet>
      </>
    );
  } else {
    return <Navigate to={"/"} />;
  }
}

export default AdminDashboard;
