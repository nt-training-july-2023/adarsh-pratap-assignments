import React from "react";
import Nav from "./Nav";
import { Outlet } from "react-router-dom";

function User() {
  const ticket = [
    { name: "All Tickets", to: "/user" },
    { name: "Add Ticket", to: "/user/addTicket" },
  ];
  const profile = [{ name: "Change Password" }, { name: "Logout" }];
  const elements = [
    {
      name: "Ticket",
      value: ticket,
    },
    {
      name: "Profile",
      value: profile,
    },
  ];

  return (
    <>
      <Nav tag={elements} />
      <div style={{height:'85vh', overflowY:'scroll', marginTop:'10px'}}><Outlet></Outlet></div>
    </>
  );
}

export default User;
