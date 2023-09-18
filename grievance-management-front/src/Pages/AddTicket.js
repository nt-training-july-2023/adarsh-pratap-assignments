import React, { useEffect, useState } from "react";
import "../css/UserRegistration.css";
import { getAllDepartment } from "../api/Department_API";
import { addTicket } from "../api/Ticket_API";

function AddTicket() {
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
      empId: 1,
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
    if (ticket.description === "") {
      const temp = { ...valid };
      temp.description.isError = true;
      temp.description.errorMessage =
        "Ticket description name can not be Empty";
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
        console.log(resp.data);
      })
      .catch((error) => {
        console.log(error);
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
    // console.log(value + " " + name);
    setTicket({
      ...ticket,
      department: {
        [name]: Number(value),
      },
    });
  };

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
          alert("Added successfully");
        })
        .catch((error) => {
          console.log(error);
          alert("Not saved");
        });
    }
  };

  return (
    <>
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
                  placeholder="Enter Discription"
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
                  {/* <option value="saab">fired</option> */}
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
