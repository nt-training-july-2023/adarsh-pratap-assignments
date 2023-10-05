import React, { useState } from "react";
import "../css/UpdateTicket.css";
import { updateTicket } from "../api/Ticket_API";
import { setPopUpDataInPopUp } from "../components/PopUp/SetPopUp";
import PopUp from "../components/PopUp/PopUp";

function UpdateTicket(props) {
  const employeeName = JSON.parse(localStorage.getItem("user")).userName;
  const canUpdate = () => {
    if (
      props.singleTicket.department.depName ===
        JSON.parse(localStorage.getItem("user")).depName ||
      props.singleTicket.employee.userName ===
        JSON.parse(localStorage.getItem("user")).userName
    ) {
      return true;
    }
    return false;
  };
  const [updatedTicketData, setUpdatedTicket] = useState({
    empName: employeeName,
    status: props.singleTicket.status,
    comment: "",
  });

  const handleChange = (e) => {
    setUpdatedTicket({ ...updatedTicketData, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    if (updatedTicketData.status === "" || updatedTicketData.status === null) {
      const data = setPopUpDataInPopUp(
        "Ticket",
        "Select Status",
        "danger-popup-message"
      );
      setPopupData(data);
      setPopUp(true);
      return;
    } else if (updatedTicketData.comment.length > 240) {
      const data = setPopUpDataInPopUp(
        "Ticket",
        "Comment size is less than 240 letter",
        "danger-popup-message"
      );
      setPopupData(data);
      setPopUp(true);
      return;
    } else if (
      props.singleTicket.comments.length === 0 &&
      updatedTicketData.status === "RESOLVED"
    ) {
      alert("Can not RESOLVE the Status because Comments are not present!!");
      return;
    } else {
      updateTicket(props.singleTicket.ticketId, updatedTicketData)
        .then((resp) => {
          props.setSingleTicket(resp.data);
          const data = setPopUpDataInPopUp(
            "Ticket",
            "Updated Sucessfully!!!",
            "success-popup-message"
          );
          setPopupData(data);
          setPopUp(true);
          setUpdatedTicket({ ...updatedTicketData, comment: "" });
        })
        .catch((err) => {
          if (err.response.data.comment) {
            alert(err.response?.data?.comment);
          } else {
            alert(err.response?.data?.status);
          }
        });
    }
  };
  const [popUpData, setPopupData] = useState();
  const [popUp, setPopUp] = useState(false);
  return (
    <>
      <div className="modal">
        <div
          className="overlay"
          onClick={() => {
            props.setUpdate(false);
          }}
        ></div>
        <div className="view-detail-modal">
          <div className="header">
            <span>{props.singleTicket.ticketName}</span>
          </div>
          <div className="parent-div">
            <div className="left">
              <div className="left-parent">
                <div className="ticketdata">
                  <h3>Ticket Type:</h3>
                  <p>{props.singleTicket.ticketType}</p>
                </div>

                <div className="ticket-des">
                  <h3>Ticket Description:</h3>
                  <textarea
                    id="ticket-des"
                    placeholder={props.singleTicket.description}
                    disabled
                  />
                </div>

                <div className="ticketdata">
                  <h3>Created By:</h3>
                  <p>{props.singleTicket.employee.userName}</p>
                </div>

                <div className="ticketdata">
                  <h3>Assigned to:</h3>
                  <p>{props.singleTicket.department.depName}</p>
                </div>

                <div className="ticketdata">
                  <h3>Status:</h3>

                  {canUpdate() ? (
                    <select
                      name="status"
                      defaultValue={props.singleTicket.status}
                      onChange={handleChange}
                    >
                      <option key="OPEN" value="OPEN">
                        OPEN
                      </option>
                      <option key="BEING_ADDRESSED" value="BEING_ADDRESSED">
                        BEING_ADDRESSED
                      </option>
                      <option key="RESOLVED" value="RESOLVED">
                        RESOLVED
                      </option>
                    </select>
                  ) : (
                    <p>{props.singleTicket.status}</p>
                  )}
                </div>

                <div className="ticketdata">
                  {canUpdate() ? (
                    <textarea
                      name="comment"
                      value={updatedTicketData.comment}
                      placeholder="Enter your Comment"
                      onChange={handleChange}
                    />
                  ) : (
                    <textarea
                      name="comment"
                      placeholder="You can not Comment on this ticket!!"
                      disabled
                    />
                  )}
                </div>
              </div>
            </div>
            <div className="right">
              <div className="comment">
                {props.singleTicket.comments.length !== 0 ? (
                  props.singleTicket.comments.map((m) => {
                    return (
                      <div className="comment-content">
                        <div className="comment-header">
                          <h3>{m.empName}</h3>
                          <p>{m.creationTime}</p>
                        </div>
                        <p>{m.content}</p>
                      </div>
                    );
                  })
                ) : (
                  <div className="no-comments">
                    <h1>No comments yet!</h1>
                  </div>
                )}
              </div>
            </div>
          </div>

          {canUpdate() ? (
            <div className="button-update">
              <button onClick={handleSubmit}>Update</button>
            </div>
          ) : (
            <div className="button-update">
              <h4>You can only view this ticket!!</h4>
            </div>
          )}
        </div>
      </div>
      {popUp && <PopUp set={setPopUp} data={popUpData} />}
    </>
  );
}

export default UpdateTicket;
