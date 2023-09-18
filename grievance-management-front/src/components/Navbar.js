import React, { useState } from "react";
import "../css/Navbar.css";
import { Link, useNavigate } from "react-router-dom";
import AddDepartment from "../Pages/AddDepartment";
import ResetPassword from "../Pages/ResetPassword";

function Navbar(props) {
  const navigate = useNavigate();
  const [dep, setDep] = useState(false);
  const [resetPass , setResetPass] = useState(false);
  return (
    <>
      {dep ? <AddDepartment set={setDep} /> : null}
      {resetPass ? <ResetPassword set={setResetPass}/> : null}
      {/* <nav>
        <span class="logo">Grievance Management</span>

        <ul>
          <li>
            <a class="active">Home</a>
          </li>
          <li>
            <a class="active" onClick={() => setDep(true)}>
              Add Department
            </a>
          </li>
          <li>
            <a
              class="active"
              onClick={() => {
                navigate("/addticket");
              }}
            >
              Add Ticket
            </a>
          </li>
          <li>
            <a
              class="active"
              onClick={() => {
                setResetPass(true);
              }}
            >
              Add User
            </a>
          </li>
        </ul>
      </nav> */}

      <nav>
      <span class="logo">Grievance Management</span>
      <ul>
        {props.tag.map(item=>{
          console.log(item);
          return( item === "Add Department" ? (<li>
            <a class="active" onClick={() => setDep(true)}>
              Add Department
            </a>
          </li>) : item === "Add User" ? (<li>
            <a
              class="active"
              onClick={() => {
                setResetPass(true);
              }}
            >
              Add User
            </a>
          </li>) : (<li onClick={()=> props.setActive(item)}>
          <a className="active">{item}</a>
      </li>)
          )
        })}
      </ul>
      </nav>
    </>
  );
}

export default Navbar;
