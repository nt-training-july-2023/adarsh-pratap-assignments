import React, { useState } from "react";
import Modal from "../components/Modal/Modal";
import { changePassword } from "../api/Employee_API";

function ResetPassword(props) {
  const [pass, setPass] = useState({
    oldPassword: "",
    newPassword: "",
    confirmPassword: "",
  });

  const [valid, setValid] = useState({
    oldPassword: {
      isError: false,
      errorMessage: "",
    },
    newPassword: {
      isError: false,
      errorMessage: "",
    },
    confirmPassword: {
      isError: false,
      errorMessage: "",
    },
  });

  const isValid = () => {
    if (pass.oldPassword === "") {
      const temp = { ...valid };
      temp.oldPassword.isError = true;
      temp.oldPassword.errorMessage = "Password can not be Empty";
      setValid(temp);
    } else if (pass.oldPassword.length < 5 || pass.oldPassword.length > 18) {
      const temp = { ...valid };
      temp.oldPassword.isError = true;
      temp.oldPassword.errorMessage = "Password Range should between 5 to 18";
      setValid(temp);
    }
    if (pass.newPassword === "") {
      const temp = { ...valid };
      temp.newPassword.isError = true;
      temp.newPassword.errorMessage = "Password can not be Empty";
      setValid(temp);
    } else if (pass.newPassword.length < 5 || pass.newPassword.length > 18) {
      const temp = { ...valid };
      temp.newPassword.isError = true;
      temp.newPassword.errorMessage = "Password Range should between 5 to 18";
      setValid(temp);
    } else if (pass.newPassword === pass.oldPassword) {
      const temp = { ...valid };
      temp.newPassword.isError = true;
      temp.newPassword.errorMessage = "Old and new Password can not be same";
      setValid(temp);
    }

    if (pass.confirmPassword === "") {
      const temp = { ...valid };
      temp.confirmPassword.isError = true;
      temp.confirmPassword.errorMessage = "Password can not be Empty";
      setValid(temp);
    } else if (pass.confirmPassword !== pass.newPassword) {
      const temp = { ...valid };
      temp.confirmPassword.isError = true;
      temp.confirmPassword.errorMessage =
        "New password is not matching with Confirm password";
      setValid(temp);
    } else if (
      pass.confirmPassword.length < 5 ||
      pass.confirmPassword.length > 18
    ) {
      const temp = { ...valid };
      temp.confirmPassword.isError = true;
      temp.confirmPassword.errorMessage =
        "Password Range should between 5 to 18";
      setValid(temp);
    }
  };

  const handleChange = (e) => {
    if (
      valid.oldPassword.isError ||
      valid.newPassword.isError ||
      valid.confirmPassword.isError
    ) {
      const temp = { ...valid };
      temp.oldPassword.isError = false;
      temp.oldPassword.errorMessage = "";
      temp.newPassword.isError = false;
      temp.newPassword.errorMessage = "";
      temp.confirmPassword.isError = false;
      temp.confirmPassword.errorMessage = "";
      setValid(temp);
    }
    setPass({ ...pass, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    isValid();
    console.log(pass);
  };

  const fields = [
    {
      field: "Input",
      label: "Old Password",
      className: "details",
      type: "password",
      name: "oldPassword",
      value: pass.oldPassword,
      placeholder: "Enter the old password",
      onChange: handleChange,
      isValid: valid.oldPassword.isError,
      errorMessage: valid.oldPassword.errorMessage,
    },
    {
      field: "Input",
      label: "New Password",
      className: "details",
      type: "password",
      name: "newPassword",
      value: pass.newPassword,
      placeholder: "Enter the new password",
      onChange: handleChange,
      isValid: valid.newPassword.isError,
      errorMessage: valid.newPassword.errorMessage,
    },
    {
      field: "Input",
      label: "Confirm Password",
      className: "details",
      type: "password",
      name: "confirmPassword",
      value: pass.confirmPassword,
      placeholder: "Retype new  password",
      onChange: handleChange,
      isValid: valid.confirmPassword.isError,
      errorMessage: valid.confirmPassword.errorMessage,
    },
    {
      field: "Button",
      type: "submit",
      className: "submit-box",
      value: "Submit",
    },
  ];

  return (
    <Modal
      set={props.set}
      header={"Change Password"}
      fields={fields}
      onsubmit={handleSubmit}
    />
  );
}

export default ResetPassword;
