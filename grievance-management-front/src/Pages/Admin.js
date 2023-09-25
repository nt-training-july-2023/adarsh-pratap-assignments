import React, { useEffect, useState } from "react";
import Nav from "./Nav";
import AllTickets from "./AllTickets";
import AllDepartment from "./AllDepartment";
import AddTicket from "./AddTicket";
import UserRegistration from "./UserRegistration";
import { Link, Outlet, useNavigate } from "react-router-dom";
import AllEmployees from "./AllEmployees";

function AdminDashboard(props) {
  const ticket = [<Link to="/admin">All Tickets</Link>, <Link to="/admin/addTicket">Add Ticket</Link>];
  const department = ["All Department", "Create Department"];
  const employee = ["All Employee", "Add Employee"];
  const profile = ["Change Password", "Logout"];
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

  useEffect(()=>{
    const user = JSON.parse(localStorage.getItem("user"));
    if(user?.role !== "ROLE_ADMIN"){
      navigate("/")
    }
  })

  const [active, setActive] = useState("All Ticket");

  const renderComponent = () => {
    switch (active) {
      case "All Ticket":
        return <Link to="/admin">All Tickets</Link>;
      case "Create Department":
        return <AllDepartment />;
      case "Create Ticket":
        return <AddTicket />;
      case "Add Employee":
        return <UserRegistration />;
      case "All Department":
        return <AllDepartment />;
      case "All Employee":
        return <AllEmployees/>;
    }
  };
  return (
    <>
      <Nav tag={elements} setActive={setActive} />
      {/* <div>{renderComponent()}</div> */}
      <Outlet></Outlet>
    </>
  );
}

export default AdminDashboard;
