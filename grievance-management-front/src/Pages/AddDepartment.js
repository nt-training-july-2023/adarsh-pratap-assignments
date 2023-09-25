import React, { useEffect, useState } from "react";
import Modal from "../components/Modal/Modal";
import { addDepartment } from "../api/Department_API";
import PopUp from "../components/PopUp";

function AddDepartment(props) {
  const [department, setDepartment] = useState({
    depName: "",
  });
  const[deptError, setDeptError] = useState("");

  const [valid, setValid] = useState({
    isError: false,
    errorMessage: "",
  });

 
  // useEffect(()=>{
  //   setTimeout(()=>{
  //     props.set(false);
  //   },1000)
  // },[])

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

  const handleSubmit =  (e) => {
    e.preventDefault();

    const flag = isValid();

    if (!flag) {
       addDepartment(department)
        .then((resp) => {
          alert("Depatment is Added!!");
          
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
