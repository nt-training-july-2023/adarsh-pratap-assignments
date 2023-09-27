import React, { useEffect, useState } from "react";
import "../css/Modal.css";



export default function PopUp(props) {

    useEffect(()=>{
        setTimeout(()=>{
            props.set(false)
        },2000)
    })
    
    return (
        
        <div className="modal" >
            <div className="overlay" onClick={()=>{props.set(false);}}></div>
          <div className="modal-content" style={{top:"16%"}}>
            <div className="header">
            <span>{props.header}</span>
            </div>
                <div style={{display:"flex",justifyContent:"center",padding:"10px",color:"green"}}>
                    <h3>{props.message}</h3>
                </div>
                
          </div>
          
        </div>
      
    
  );
}