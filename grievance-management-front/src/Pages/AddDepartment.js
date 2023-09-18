import React, { useState } from "react";
import Modal from "../components/Modal/Modal";
import { addDepartment } from "../api/Department_API";

function AddDepartment(props) {
  const [department, setDepartment] = useState({
    depName: "",
  });

  const [valid, setValid] = useState({
    isError: false,
    errorMessage: "",
  });

  const handleChange = (e) => {
    if (valid.isError) {
      setValid({
        ...valid,
        isError: false,
      });
    }
    setDepartment({ ...department, [e.target.name]: e.target.value });
  };

  const isValid = () => {
    if (department.depName === "") {
      setValid({
        ...valid,
        isError: true,
        errorMessage: "Depatment name can not be empty",
      });
    }
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    isValid();
    if (valid.isError === false) {
      addDepartment(department)
        .then((resp) => {
          alert("Depatment is Added!!");
        })
        .catch((error) => {
          console.log(error);
          alert(error);
        });
    }
    return;
  };
  const fields = [
    {
      field: "Input",
      label: "Department Name",
      className: "details",
      type: "text",
      name: "depName",
      value: department.depName,
      placeholder: "Enter the Department Name",
      onChange: handleChange,
      isValid: valid.isError,
      errorMessage: valid.errorMessage,
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
      header={"Add Department"}
      fields={fields}
      onsubmit={handleSubmit}
    />
  );
}

export default AddDepartment;
