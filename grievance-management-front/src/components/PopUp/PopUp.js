import React, { useEffect } from "react";

export default function PopUp(props) {
  useEffect(()=>{
      setTimeout(()=>{
          props.set(false)
      },2000)
  })

  return (
    <div className="modal">
      <div
        className="overlay"
        onClick={() => {
          props.set(false);
        }}
      ></div>
      <div className="modal-content" style={{ top: "15%" }}>
        <div className="header">
          <span>{props?.data?.header}</span>
        </div>
        <div className={props?.data?.classname}>
          <h3>{props?.data?.message}</h3>
        </div>
      </div>
    </div>
  );
}
