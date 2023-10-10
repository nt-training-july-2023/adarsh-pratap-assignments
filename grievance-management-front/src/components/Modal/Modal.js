import React from "react";
import "../../css/Modal.css";
import Input from "./Input";
import Button from "./Button";



export default function Modal(props) {

    
    return (
        <>
        <div className="modal" >
            <div className="overlay" onClick={()=>{props.set(false);}}></div>
          <div className="modal-content">
            <div className="header">
            <span>{props.header}</span>
            </div>
                <form onSubmit={props.onsubmit}>
                    {
                        props.fields.map((tag, index)=>{
                            if (tag.field === "Input"){
                                return <Input key={index} fields={tag}/>
                            }
                            else{
                                return <Button key={index} fields={tag}/>
                            }
                        })
                    }
                </form>
                
          </div>
          
        </div>
        
        </>
      
    
  );
}