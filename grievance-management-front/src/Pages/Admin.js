import React, { useState } from "react";
import Nav from "./Nav";
import AllTickets from "./AllTickets";
import AllDepartment from "./AllDepartment";
import AddTicket from "./AddTicket";
import UserRegistration from "./UserRegistration";

function AdminDashboard() {
  const ticket = ["All Ticket", "Create Ticket"];
  const department = ["All Department", "Create Department"];
  const employee = ["All Employee", "Add Employee"];
  const profile = ["Change Password", "Logout"];

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

  const [active, setActive] = useState("All Ticket");

  const renderComponent = () => {
    switch (active) {
      case "All Ticket":
        return <AllTickets />;
      case "Create Department":
        return <AllDepartment />;
      case "Create Ticket":
        return <AddTicket />;
      case "Add Employee":
        return <UserRegistration />;
      case "All Department":
        return <AllDepartment />;
      case "All Employee":
        return <></>;
    }
  };
  return (
    <>
      <Nav tag={elements} setActive={setActive} />
      <div>{renderComponent()}</div>
    </>
  );
}

export default AdminDashboard;
