import React, { useEffect, useState } from "react";
import "../css/UserRegistration.css";
import { getAllDepartment } from "../api/Department_API";
import axios from "axios";
import { headers } from "../api/Headers";
import PopUp from "../components/PopUp";

function UserRegistration() {
  const [department, setDepartment] = useState([]);

  const [employee, setEmployee] = useState({
    userName: "",
    email: "",
    password: "",
    role: "",
    department: {
      depId: 0,
    },
  });

  const [valid, setValid] = useState({
    userName: {
      isError: false,
      errorMessage: "",
    },
    email: {
      isError: false,
      errorMessage: "",
    },
    password: {
      isError: false,
      errorMessage: "",
    },
    role: {
      isError: false,
      errorMessage: "",
    },
    department: {
      isError: false,
      errorMessage: "",
    },
  });

  const getDepartment = () => {
    getAllDepartment()
      .then((resp) => {
        setDepartment(resp.data);
        console.log(resp.data);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  useEffect(() => {
    getDepartment();
  }, []);

  const handleChange = (e) => {
    if (
      valid.userName.isError ||
      valid.email.isError ||
      valid.password.isError ||
      valid.role.isError
    ) {
      let state = { ...valid };
      state.userName.isError = false;
      state.email.isError = false;
      state.password.isError = false;
      state.role.isError = false;
      state.department.isError = false;
      setValid(state);
    }

    setEmployee({ ...employee, [e.target.name]: e.target.value });
  };

  const handleSelectChange = (e) => {
    const { name, value } = e.target;
    console.log(value);
    setEmployee({
      ...employee,
      department: {
        [name]: Number(value),
      },
    });
  };

  const isValid = () => {
    console.log(employee);

    if (employee.userName === "") {
      let newState = { ...valid };

      newState.userName.isError = true;
      newState.userName.errorMessage = "Username can not be empty";

      setValid(newState);
    }

    if (employee.password === "") {
      let newState = { ...valid };

      newState.password.isError = true;
      newState.password.errorMessage = "Password can not be empty";

      setValid(newState);
    }
    const regex = /^[A-Za-z0-9._%+-]+@nucleusteq\.com$/;
    if (!regex.test(employee.email)) {
      let newState = { ...valid };

      newState.email.isError = true;
      newState.email.errorMessage =
        "Email can not be empty and ends with @nucleusteq.com";

      setValid(newState);
    }

    if (employee.role === "") {
      let newState = { ...valid };

      newState.role.isError = true;
      newState.role.errorMessage = "Select Role";

      setValid(newState);
    }

    if (employee.department.depId === 0) {
      let newState = { ...valid };

      newState.department.isError = true;
      newState.department.errorMessage = "Select Department";

      setValid(newState);
      console.log("Inside valid department");
    }
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    isValid();
    if (
      !valid.userName.isError &&
      !valid.role.isError &&
      !valid.password.isError &&
      !valid.email.isError &&
      !valid.department.isError
    ) {
      const pass = employee.password;
      var emp={...employee};
      emp.password=btoa(employee.password);
      console.log(emp)
      axios
        .post("http://localhost:8080/employee/add", emp, {headers:headers()})
        .then((resp) => {
          setpopup(true);
        })
        .catch((error) => {
          alert(error.message);
        });
    }
  };
  const [popup , setpopup] = useState(false);
  return (
    <>
    {popup && <PopUp set={setpopup} header={"Employee"} message={"Registered Sucessfully!!!"}/>}
    <div className="registration">
      <div className="content">
        <div className="header">
          <h1>User-Registration</h1>
        </div>

        <form onSubmit={handleSubmit}>
          <div className="user-details">
            <div className="inner-div">
              <label>Username</label>
              <input
                type="text"
                placeholder="Enter your name"
                name="userName"
                value={employee.userName}
                onChange={handleChange}
              />
              {valid.userName.isError ? (
                <p>{valid.userName.errorMessage}</p>
              ) : null}
            </div>
            <div className="inner-div">
              <label>Email</label>
              <input
                type="email"
                placeholder="Enter your email"
                name="email"
                value={employee.email}
                onChange={handleChange}
              />
              {valid.email.isError ? <p>{valid.email.errorMessage}</p> : null}
            </div>
            <div className="inner-div">
              <label>Password</label>
              <input
                type="password"
                placeholder="Enter your password"
                name="password"
                value={employee.password}
                onChange={handleChange}
              />
              {valid.password.isError ? (
                <p>{valid.password.errorMessage}</p>
              ) : null}
            </div>
            <div className="inner-div">
              <label>Role:</label>

              <select
                name="role"
                defaultValue=""
                value={employee.role}
                onChange={handleChange}
              >
                <option value="">--Select--</option>
                <option value="ROLE_ADMIN">ADMIN</option>
                <option value="ROLE_USER">USER</option>
              </select>
              {valid.role.isError ? <p>{valid.role.errorMessage}</p> : null}
            </div>

            <div className="inner-div">
              <label>Department:</label>

              <select
                name="depId"
                defaultValue=""
                onChange={handleSelectChange}
              >
                <option value="">--Select--</option>
                {department.map((dep) => {
                  return (
                    <option key={dep.depId} value={dep.depId}>
                      {dep.depName}
                    </option>
                  );
                })}
              </select>

              {valid.department.isError ? (
                <p>{valid.department.errorMessage}</p>
              ) : null}
            </div>

            <div className="submit-box">
              <input type="submit" value="Submit" />
            </div>
          </div>
        </form>
      </div>
    </div>
    </>
  );
}

export default UserRegistration;
