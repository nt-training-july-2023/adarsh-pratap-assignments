import React, { useState } from 'react'
import Navbar from '../components/Navbar'
import AllTickets from './AllTickets';
import AddDepartment from './AddDepartment';
import AddTicket from './AddTicket';
import ResetPassword from './ResetPassword';
import AllDepartment from './AllDepartment';
import LoginPage from './LoginPage';

function AdminDashboard() {
  
  const elements = [
    "Home",
    "Add Department",
    "Add Ticket",
    "Add User"
  ]

  const [active , setActive] = useState("Home");

  const renderComponent=()=>{
    switch(active) {
        case "Home":
            return <AllTickets/>
        case "Add Department":
            return <AllDepartment />
        case "Add Ticket":
            return <AddTicket/>
        case "Add User":
            return <LoginPage/>
    }
  }
  return (
    <>
    <Navbar tag={elements} setActive={setActive}/>
    <div>{renderComponent()}</div>
    </>
  )
}

export default AdminDashboard