import React, { useEffect, useState } from "react";
import "../css/Nav.css";
import { Link, useNavigate } from "react-router-dom";
import AddDepartment from "./AddDepartment";
import ResetPassword from "./ResetPassword";

function Nav(props) {
  const navigate = useNavigate();
  const [dep, setDep] = useState(false);
  const [resetPass, setResetPass] = useState(false);

  return (
    <>
      {dep ? <AddDepartment set={setDep} /> : null}
      {resetPass ? <ResetPassword set={setResetPass} /> : null}

      <nav>
        <span class="logo">Grievance Management</span>
        <ul>
          {props.tag.map((item) => {
            console.log(item);
            return (
              <li>
                <div className="drop-down">
                  <a className="active nav-link">{item.name}</a>
                  <div className="drop-down-content">
                    {item.value.map((value) => {
                      return value.name === "Create Department" ? (
                        <a 
                          onClick={() => {
                            setDep(true);
                          }}
                        >
                          {value.name}
                        </a>
                      ) : value.name === "Change Password" ? (
                        <a
                          onClick={() => {
                            setResetPass(true);
                          }}
                        >
                          {value.name}
                        </a>
                      ) : value.name === "Logout" ? (
                        <a
                          onClick={() => {
                            localStorage.clear();
                            navigate("/");
                          }}
                        >
                          {value.name}
                        </a>
                      ) : (
                        <Link to={value.to}>{value.name}</Link>
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
