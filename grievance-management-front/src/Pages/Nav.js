import React, { useEffect, useState } from "react";
import "../css/Nav.css";
import { NavLink, useNavigate } from "react-router-dom";
import AddDepartment from "./AddDepartment";
import ResetPassword from "./ResetPassword";
import { getCurrentUserDetails } from "../Authentication/auth";

function Nav(props) {
  const navigate = useNavigate();
  const [dep, setDep] = useState(false);
  const [resetPass, setResetPass] = useState(false);
  const [activeItem, setActiveItem] = useState(null);

  useEffect(() => {
    const location = window.location.href;
    if (getCurrentUserDetails().role === "ROLE_ADMIN") {
      if (
        location === "http://localhost:3000/admin" ||
        location === "http://localhost:3000/admin/addTicket"
      ) {
        setActiveItem("Ticket");
      } else if (
        location === "http://localhost:3000/admin/allDepartment" ||
        dep === true
      ) {
        setActiveItem("Department");
      } else if (
        location === "http://localhost:3000/admin/allEmployee" ||
        location === "http://localhost:3000/admin/registration"
      ) {
        setActiveItem("Employee");
      } else {
        setActiveItem("Profile");
      }
    } else {
      if (
        location === "http://localhost:3000/user" ||
        location === "http://localhost:3000/user/addTicket"
      ) {
        setActiveItem("Ticket");
      } else {
        setActiveItem("Profile");
      }
    }
  });

  return (
    <>
      {dep ? <AddDepartment set={setDep} /> : null}
      {resetPass ? <ResetPassword set={setResetPass} /> : null}

      <nav>
        <span
          className="logo"
          onClick={() => {
            getCurrentUserDetails().role === "ROLE_ADMIN"
              ? navigate("/admin")
              : navigate("/user");
          }}
        >
          Grievance Management
        </span>
        <ul>
          {props.tag.map((item, index) => {
            return (
              <li key={index}>
                <div className="drop-down">
                  {item.name === "Department" ? (
                    <a
                      key={index}
                      className={
                        activeItem === item.name ? "nav-link-active" : "active"
                      }
                      onClick={() => {
                        navigate("/admin/allDepartment");
                      }}
                    >
                      {item.name}
                    </a>
                  ) : (
                    <a
                      key={index}
                      className={
                        activeItem === item.name ? "nav-link-active" : "active"
                      }
                      onClick={() => {
                        navigate(item.value[0].to);
                      }}
                    >
                      {item.name}
                    </a>
                  )}
                  <div className="drop-down-content">
                    {item.value.map((value, index) => {
                      return value.name === "Create Department" ? (
                        <a
                          key={index}
                          onClick={() => {
                            setDep(true);
                          }}
                        >
                          {value.name}
                        </a>
                      ) : value.name === "Change Password" ? (
                        <a
                          key={index}
                          onClick={() => {
                            setResetPass(true);
                          }}
                        >
                          {value.name}
                        </a>
                      ) : value.name === "Logout" ? (
                        <a
                          key={index}
                          onClick={() => {
                            localStorage.clear();
                            navigate("/");
                          }}
                        >
                          {value.name}
                        </a>
                      ) : (
                        <NavLink
                          key={index}
                          to={value.to}
                          className="active-link"
                        >
                          {value.name}
                        </NavLink>
                      );
                    })}
                  </div>
                </div>
              </li>
            );
            // );
          })}
        </ul>
      </nav>
    </>
  );
}

export default Nav;
