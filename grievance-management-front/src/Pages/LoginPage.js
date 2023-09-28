import React, { useEffect, useState } from "react";
import "../css/LoginPage.css";
import { useNavigate } from "react-router-dom";
import { login } from "../api/Employee_API";
import { doLogin, getCurrentUserDetails } from "../Authentication/auth";
function LoginPage(props) {
  const navigate = useNavigate();

  const [user, setUser] = useState({
    userName: "",
    password: "",
  });

  useEffect(()=>{
    const user = getCurrentUserDetails();
    if(user && !user?.isFirstLogin && user?.role === 'ROLE_ADMIN'){
      navigate("/admin")
    }
    else if(user && !user?.isFirstLogin && user?.role === 'ROLE_USER'){
      navigate("/user");
    }
  })
  const [valid, setValid] = useState({
    userName: {
      isError: false,
      errorMessage: "",
    },
    password: {
      isError: false,
      errorMessage: "",
    },
  });

  const handleChange = (e) => {
    if (valid.userName.isError || valid.password.isError) {
      const temp = { ...valid };

      temp.userName.isError = false;
      temp.password.isError = false;

      setValid(temp);
    }
    setUser({
      ...user,
      [e.target.name]: e.target.value,
    });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    validation();
    if (!valid.userName.isError && !valid.password.isError) {
      const pass = user.password;
      setUser({...user, password:pass})

      let value = {
        userName : user.userName,
        password : btoa(pass)
      }
      console.log(value);
      login(value)
        .then((res) => {
          localStorage.setItem("password", value.password);
          doLogin(res.data,()=>{
            if(res.data.isFirstLogin){
              navigate("/reset");
              return;
            }
            if(res.data.role === "ROLE_ADMIN"){
              navigate("/admin");
            }
            else{
              navigate("/user");
            }
          })
        })
        .catch((error) => {
          alert(error.response.data);
        });
    }
  };

  const validation = () => {
    const regex = /^[A-Za-z0-9._%+-]+@nucleusteq\.com$/;
    if (!regex.test(user.userName)) {
      const temp = { ...valid };

      temp.userName.isError = true;
      temp.userName.errorMessage = "Email ends with @nucleusteq.com";

      setValid(temp);
    }

    if (user.password.length < 5 || user.password.length > 15) {
      const temp = { ...valid };

      temp.password.isError = true;
      temp.password.errorMessage = "length of password is between 5 to 15";

      setValid(temp);
    }
  };
  return (
    <>
    <div className="outer-div">
      <div className="image-box">
        <img src="./logo.png" />
      </div>
      <div className="content-box">
        <div className="form-box">
          <h2>Login!</h2>
          <form onSubmit={handleSubmit}>
            <div className="input-box">
              <span>UserName</span>
              <input
                type="email"
                name="userName"
                value={user.userName}
                onChange={handleChange}
                required
              />
              {valid.userName.isError && <p>{valid.userName.errorMessage}</p>}
            </div>
            <div className="input-box">
              <span>Password</span>
              <input
                type="password"
                name="password"
                value={user.password}
                onChange={handleChange}
                required
              />
              {valid.password.isError && <p>{valid.password.errorMessage}</p>}
            </div>
            <div className="input-box">
              <input type="submit" value="Sign in" />
            </div>
          </form>
        </div>
      </div>
    </div>
    </>
  );
}

export default LoginPage;
