import React from "react";
import "../css/UpdateTicket.css";
function UpdateTicket(props) {
  const dummy = [
    {
      commentId: "152",
      commentContent: "Lorem Ipsum is simply dummy text of the .",
      employee: "lorem@nucleusteq.com",
    },
    {
      commentId: "153",
      commentContent:
        "Lorem Ipsum is simply  to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
      employee: "lorem@nucleusteq.com",
    },
    {
      commentId: "154",
      commentContent: "Lorem Ipsum is standard Lorem Ipsum.",
      employee: "lorem@nucleusteq.com",
    },
    {
      commentId: "155",
      commentContent: "Lorem Ipsum is  of Lorem Ipsum.",
      employee: "lorem@nucleusteq.com",
    },
    {
      commentId: "152",
      commentContent: "Lorem Ipsum is simply dummy text of the .",
      employee: "lorem@nucleusteq.com",
    },
    {
      commentId: "153",
      commentContent:
        "Lorem Ipsum is simply  to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
      employee: "lorem@nucleusteq.com",
    },
    {
      commentId: "154",
      commentContent: "Lorem Ipsum is standard Lorem Ipsum.",
      employee: "lorem@nucleusteq.com",
    },
    {
      commentId: "155",
      commentContent: "Lorem Ipsum is  of Lorem Ipsum.",
      employee: "lorem@nucleusteq.com",
    },
  ];

  return (
    <div className="modal">
      <div
        className="overlay"
        onClick={() => {
          props.setUpdate(false);
        }}
      ></div>
      <div className="view-detail-modal">
        <div className="header">
          <span>Update Ticket</span>
        </div>
        <div className="parent-div">
          <div className="left">
            <div className="left-parent">
              <div className="ticketdata">
                <h3>Ticket Name:</h3>
                <p>kjcbsdjcbd</p>
              </div>

              <div className="ticketdata">
                <h3>Ticket Description:</h3>
                <p>kjcbsdjcbd</p>
              </div>

              <div className="ticketdata">
                <h3>Created By:</h3>
                <p>kjcbsdjcbd</p>
              </div>

              <div className="ticketdata">
                <h3>Assigned to:</h3>
                <p>kjcbsdjcbd</p>
              </div>

              <div className="ticketdata">
                <h3>Status:</h3>
                <select name="" defaultValue="" onChange="">
                  <option value="" disabled>
                    --Select--
                  </option>

                  <option key="" value="">
                    OPEN
                  </option>
                  <option key="" value="">
                    BEING_ADDRESSED
                  </option>
                  <option key="" value="">
                    CLOSED
                  </option>
                </select>
              </div>

              <div className="ticketdata">
                <textarea placeholder="Enter your Comment" />
              </div>
            </div>
          </div>
          <div className="right">
            <div className="comment">
              {dummy.map((m) => {
                return (
                  <div className="comment-content">
                    <h3>{m.employee}</h3>
                    <p>{m.commentContent}</p>
                  </div>
                );
              })}
            </div>
          </div>
        </div>
        <div className="button-update">
          <button>Update</button>
        </div>
      </div>
    </div>
  );
}

export default UpdateTicket;
