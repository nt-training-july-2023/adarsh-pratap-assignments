import React, { useState } from "react";
import "./Modal.css";

export default function Modal(props) {


  return (
    <>
        <div className="modal">
          <div className="modal-content">
            <div className="header">
            <span>Add Department</span>
            </div>
                <form>
                    <div className="details">
                    <label>
                        Department Name :
                    </label>
                    <input type="text" name="depName" placeholder="Enter the Departent name"/>
                    </div>

                    <div className='submit-box'>
                            <input type='submit' value='Submit'  />
                    </div>
                </form>
            
            {/* <button className="close-modal" onClick={()=>{props.setModal(false)}}>
              X
            </button> */}
          </div>
        </div>
      
    </>
  );
}