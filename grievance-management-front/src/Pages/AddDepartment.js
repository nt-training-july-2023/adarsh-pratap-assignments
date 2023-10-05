import React, { useState } from "react";
import Modal from "../components/Modal/Modal";
import { addDepartment } from "../api/Department_API";
import PopUp from "../components/PopUp/PopUp";
import { setPopUpDataInPopUp } from "../components/PopUp/SetPopUp";

function AddDepartment(props) {
  const [department, setDepartment] = useState({
    depName: "",
  });
  const [show, setShow] = useState(false);
  const [popUpData, setPopUpData] = useState();
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
    setDepartment({ ...department, [e.target.name]: e.target.value.toUpperCase() });
  };

  const isValid = () => {
    if (department.depName === "") {
      setValid((prevValid) => ({
        ...prevValid,
        isError: true,
        errorMessage: "Department name can not be empty",
      }));
      return true;
    }
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    const flag = isValid();

    if (!flag) {
      addDepartment(department)
        .then((resp) => {
          const data = setPopUpDataInPopUp(
            "Department",
            "Added Sucessfully!!!",
            "success-popup-message"
          );
          setPopUpData(data);
          setShow(true);
          setDepartment({ ...department, depName: "" });
        })
        .catch((error) => {
          if (error.code === "ERR_BAD_REQUEST") {
            const data = setPopUpDataInPopUp(
              "Department",
              error.response.data,
              "danger-popup-message"
            );
            setPopUpData(data);
            setShow(true);
          } else {
            const data = setPopUpDataInPopUp(
              "Department",
              "Try Again!!",
              "danger-popup-message"
            );
            setPopUpData(data);
            setShow(true);
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
      {show && <PopUp data={popUpData} set={setShow} />}
    </>
  );
}

export default AddDepartment;
