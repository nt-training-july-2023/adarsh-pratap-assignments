import React, { useEffect, useState } from "react";
import "../css/UserRegistration.css";
import { getAllDepartment } from "../api/Department_API";

import { useNavigate } from "react-router-dom";
import { addEmployee } from "../api/Employee_API";
import PopUp from "../components/PopUp/PopUp";
import { setPopUpDataInPopUp } from "../components/PopUp/SetPopUp";

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
      })
      .catch((error) => {
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
    setEmployee({
      ...employee,
      department: {
        [name]: Number(value),
      },
    });
  };

  const isValid = () => {

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
    if (employee.password.length > 18 || employee.password.length < 5) {
      let newState = { ...valid };

      newState.password.isError = true;
      newState.password.errorMessage = "Password should between 5 to 18";

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
    }
  };

  const navigate = useNavigate();
  const [popUpData, setPopUpData] = useState();
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
      var emp = { ...employee };
      emp.password = btoa(employee.password);

      addEmployee(emp)
        .then((resp) => {
          const data = setPopUpDataInPopUp(
            "Employee",
            "Added Sucessfully!!",
            "success-popup-message"
          );
          setPopUpData(data);
          setpopup(true);
          setTimeout(() => {
            navigate("/admin/allEmployee");
          }, 1000);
        })
        .catch((error) => {
          alert(error.message);
        });
    }
  };
  const [popup, setpopup] = useState(false);
  return (
    <>
      {popup && <PopUp set={setpopup} data={popUpData} />}
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
                  value={employee.role}
                  onChange={handleChange}
                >
                  <option value="" disabled>--Select--</option>
                  <option value="ROLE_ADMIN">ADMIN</option>
                  <option value="ROLE_USER">USER</option>
                </select>
                {valid.role.isError ? <p>{valid.role.errorMessage}</p> : null}
              </div>

              <div className="inner-div">
                <label>Department:</label>

                <select
                  name="depId"
                  onChange={handleSelectChange}
                >
                  <option value="" disabled>--Select--</option>
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
