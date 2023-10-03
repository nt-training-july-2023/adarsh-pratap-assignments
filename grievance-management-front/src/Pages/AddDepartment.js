import React, { useEffect, useState } from "react";
import Modal from "../components/Modal/Modal";
import { addDepartment } from "../api/Department_API";
import { useNavigate } from "react-router-dom";

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

  const isValid =  () => {
    if (department.depName === "") {
      setValid((prevValid) => ({
        ...prevValid,
        isError: true,
        errorMessage: "Department name can not be empty",
      }));
      return true;
      
    }
  };

  const navigate = useNavigate();
  const handleSubmit =  (e) => {
    e.preventDefault();

    const flag = isValid();

    if (!flag) {
       addDepartment(department)
        .then((resp) => {
          alert("Depatment is Added!!");
          props.set(false);
          
          navigate("/admin/allDepartment");
        })
        .catch((error) => {
          if(error.code === "ERR_BAD_REQUEST"){
            alert(error.response.data.depName)
          }
          else{
          alert(error);
    }
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
    <>
    
    <Modal
      set={props.set}
      header={"Add Department"}
      fields={fields}
      onsubmit={handleSubmit}
    />
    </>
  );
}

export default AddDepartment;
