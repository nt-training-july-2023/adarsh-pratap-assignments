import React from 'react'
import "./Navbar.css"
import { Link, useNavigate } from 'react-router-dom'

function Navbar() {
    const navigate = useNavigate();
  return (
    <nav>
        <span class="logo">Grievance Management</span>
        
            <ul>
                <li><a class="active" >Home</a></li>
                <li><a class="active" onClick={()=>{navigate("/depatment")}}>Add Department</a></li>
                <li><a class="active" onClick={()=>{navigate("/addticket")}}>Add Ticket</a></li>
                <li><a class="active" onClick={()=>{navigate("/")}}>Add User</a></li>
            </ul>
        
      </nav>
  )
}

export default Navbar