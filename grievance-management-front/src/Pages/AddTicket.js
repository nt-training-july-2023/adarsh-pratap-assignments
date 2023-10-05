import React, { useEffect, useState } from "react";
import "../css/UserRegistration.css";
import { getAllDepartment } from "../api/Department_API";
import { addTicket } from "../api/Ticket_API";
import { useNavigate } from "react-router-dom";
import PopUp from "../components/PopUp/PopUp";
import { setPopUpDataInPopUp } from "../components/PopUp/SetPopUp";

function AddTicket() {
  const navigate = useNavigate();

  const [department, setDepartment] = useState([]);

  const [ticket, setTicket] = useState({
    ticketName: "",
    description: "",
    status: "OPEN",
    ticketType: "",
    department: {
      depId: 0,
    },
    employee: {
      empId: JSON.parse(localStorage.getItem("user")).empId,
    },
  });

  const [valid, setValid] = useState({
    ticketName: {
      isError: false,
      errorMessage: "",
    },
    description: {
      isError: false,
      errorMessage: "",
    },
    ticketType: {
      isError: false,
      errorMessage: "",
    },
    department: {
      isError: false,
      errorMessage: "",
    },
  });

  const isValid = () => {
    if (ticket.ticketName === "") {
      const temp = { ...valid };
      temp.ticketName.isError = true;
      temp.ticketName.errorMessage = "Ticket name can not be Empty";
      setValid(temp);
    }
    if (ticket.ticketName.length > 100) {
      const temp = { ...valid };
      temp.ticketName.isError = true;
      temp.ticketName.errorMessage =
        "Ticket Name Lenght Should be less than 100";
      setValid(temp);
    }
    if (ticket.description === "") {
      const temp = { ...valid };
      temp.description.isError = true;
      temp.description.errorMessage =
        "Ticket description name can not be Empty";
      setValid(temp);
    }
    if (ticket.description.length > 220) {
      const temp = { ...valid };
      temp.description.isError = true;
      temp.description.errorMessage =
        "Ticket description Lenght Should be less than 100";
      setValid(temp);
    }
    if (ticket.ticketType === "") {
      const temp = { ...valid };
      temp.ticketType.isError = true;
      temp.ticketType.errorMessage = "Select ticket type";
      setValid(temp);
    }
    if (ticket.department.depId === 0) {
      const temp = { ...valid };
      temp.department.isError = true;
      temp.department.errorMessage = "Select department";
      setValid(temp);
    }
  };

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

  const checkErrorRendering = () => {
    if (
      valid.ticketType.isError ||
      valid.ticketName.isError ||
      valid.description.isError ||
      valid.department.isError
    ) {
      let temp = { ...valid };
      temp.ticketType.isError = false;
      temp.department.isError = false;
      temp.ticketName.isError = false;
      temp.description.isError = false;

      setValid(temp);
    }
  };

  const handleChange = (e) => {
    checkErrorRendering();
    setTicket({ ...ticket, [e.target.name]: e.target.value });
  };

  const handleSelectChange = (e) => {
    checkErrorRendering();

    const { name, value } = e.target;
    setTicket({
      ...ticket,
      department: {
        [name]: Number(value),
      },
    });
  };

  const [popUpData, setPopUpData] = useState();
  const handleSubmit = (e) => {
    e.preventDefault();
    isValid();
    if (
      !valid.ticketType.isError &&
      !valid.ticketName.isError &&
      !valid.description.isError &&
      !valid.department.isError
    ) {
      addTicket(ticket)
        .then((resp) => {
          const data = setPopUpDataInPopUp(
            "Ticket",
            "Ticket added successfully!!",
            "success-popup-message"
          );
          setPopUpData(data);
          setPopUp(true);

          setTimeout(() => {
            navigate("/admin");
          }, 1000);
        })
        .catch((error) => {
          if (error.code === "ERR_NETWORK") {
            const data = setPopUpDataInPopUp(
              "Ticket",
              "Network Error!!",
              "danger-popup-message"
            );
            setPopUpData(data);
            setPopUp(true);
            return;
          }
          const data = setPopUpDataInPopUp(
            "Ticket",
            "Ticket Not Saved!!",
            "danger-popup-message"
          );
          setPopUpData(data);
          setPopUp(true);
        });
    }
  };
  const [popUp, setPopUp] = useState(false);
  return (
    <>
      {popUp && <PopUp set={setPopUp} data={popUpData} />}
      <div className="registration">
        <div className="content">
          <div className="header">
            <h1>Add Ticket</h1>
          </div>

          <form onSubmit={handleSubmit}>
            <div className="user-details">
              <div className="inner-div">
                <label>Ticket Type:</label>

                <select
                  name="ticketType"
                  onChange={handleChange}
                  defaultValue=""
                >
                  <option value="" disabled>
                    --Select--
                  </option>
                  <option value="GRIEVANCE">Grievance</option>
                  <option value="FEEDBACK">Feedback</option>
                </select>

                {valid.ticketType.isError ? (
                  <p>{valid.ticketType.errorMessage}</p>
                ) : null}
              </div>
              <div className="inner-div">
                <label>Title</label>
                <input
                  type="text"
                  placeholder="Enter Title"
                  name="ticketName"
                  value={ticket.ticketName}
                  onChange={handleChange}
                />
                {valid.ticketName.isError ? (
                  <p>{valid.ticketName.errorMessage}</p>
                ) : null}
              </div>

              <div className="inner-div">
                <label>Description</label>
                <textarea
                  id=""
                  name="description"
                  placeholder="Enter Description"
                  rows="4"
                  cols="50"
                  value={ticket.description}
                  onChange={handleChange}
                />
                {valid.description.isError ? (
                  <p>{valid.description.errorMessage}</p>
                ) : null}
              </div>

              <div className="inner-div">
                <label>Department:</label>

                <select
                  name="depId"
                  defaultValue=""
                  onChange={handleSelectChange}
                >
                  <option value="" disabled>
                    --Select--
                  </option>
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
              <div className="inner-div">
                <label>Status</label>
                <input type="text" value="OPEN" disabled />
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

export default AddTicket;
